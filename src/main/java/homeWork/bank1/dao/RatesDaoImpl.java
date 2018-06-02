package homeWork.bank1.dao;

import homeWork.bank1.entity.Currency;
import homeWork.bank1.entity.Rates;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.Scanner;

public class RatesDaoImpl implements RatesDao {
    @Override
    public Double getRate(EntityManager em, Currency currency) {
        Rates r;
        try {
            Query query = em.createQuery("select r from Rates r where currency = :curr", Rates.class);
            query.setParameter("curr", currency);
            r = (Rates) query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println("Такой валюты нет");
            return null;
        }
        return r.getValue();
    }

    @Override
    public void changeRate(EntityManager em, Scanner sc) {
        System.out.println("Введите наименование валюты");
        String curr = sc.nextLine();
        System.out.println("Введите курс по отношению к USD");
        Double rate = Double.parseDouble(sc.nextLine());
        Rates r;
        try {
            Query query = em.createQuery("select r from Rates r where currency.name = :curr", Rates.class);
            query.setParameter("curr", curr);
            r = (Rates) query.getSingleResult();
            em.getTransaction().begin();
            r.setValue(rate);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Курс не поменян");
            em.getTransaction().rollback();
        }
    }
}
