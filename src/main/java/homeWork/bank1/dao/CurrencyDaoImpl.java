package homeWork.bank1.dao;

import homeWork.bank1.entity.Currency;

import javax.persistence.EntityManager;
import java.util.Scanner;

public class CurrencyDaoImpl implements CurrencyDao {
    @Override
    public void addCurrency(EntityManager em, Scanner sc) {
        System.out.println("Введите наименование валюты");
        String name = sc.nextLine();
        /*System.out.println("Введите курс по отношению к USD");
        Double rate = Double.parseDouble(sc.nextLine());*/
        Currency currency = new Currency(name);

        try {
            em.getTransaction().begin();
            em.persist(currency);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Валюта не добавлена");
        }
    }

    @Override
    public Currency findCurrency(Long idc, EntityManager em) {
        return em.find(Currency.class, idc);
    }
}
