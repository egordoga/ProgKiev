package homeWork.bank1.dao;

import homeWork.bank1.entity.Account;
import homeWork.bank1.entity.Client;
import homeWork.bank1.entity.Currency;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.Scanner;

public class AccountDaoImpl implements AccountDao {
    @Override
    public void createAccount(EntityManager em, Scanner sc) {
        Account account;
        ClientDao cd = new ClientDaoImpl();
        Client client = cd.findClient(em, sc);
        if (client == null) return;
        System.out.println("В какщй валюте счет?");
        System.out.println("USD");
        System.out.println("EUR");
        System.out.println("UAH");
        String currency = sc.nextLine();

        Currency c;
        try {
            Query query = em.createQuery("select c from Currency c where name = :curr", Currency.class);
            query.setParameter("curr", currency);
            c = (Currency) query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println("Такой валюты не найдено");
            return;
        }

        account = new Account(client, c);
        /*switch (currency) {
            case "1":
                break;
            case "2":
                account = new Account(client, new Currency("EUR"));
                break;
            case "3":
                account = new Account(client, new Currency("UAH"));
                break;
                default:
                    System.out.println("Такой валюты нет");
                    return;
        }*/

        try {
            em.getTransaction().begin();
            em.persist(account);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Счет не открыт");
            em.getTransaction().rollback();
        }
    }


    @Override
    public void addSum(Account account, Double sum, EntityManager em) {
        em.getTransaction().begin();
        try {
            Double summa;
            if (account.getSumm() == null) {
                summa = sum;
            } else {
                summa = sum + account.getSumm();
            }
            System.out.println("HHHHHHHHHHHHHH" + sum + account.getSumm());
            account.setSumm(summa);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public Account findAccount(EntityManager em, Scanner sc) {
        System.out.println("Введите номер счета (id)");
        Integer id = Integer.parseInt(sc.nextLine());
        Account account = em.find(Account.class, id);
        if (account == null) {
            System.out.println("Такого счета нет");
            return null;
        }
        return account;
    }
}
