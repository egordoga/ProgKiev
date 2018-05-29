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
        Account account = null;
        ClientDao cd = new ClientDaoImpl();
        Client client = cd.findClient(em, sc);
        if (client == null) return;
        System.out.println("В какщй валюте счет?");
        System.out.println("1. USD");
        System.out.println("2. EUR");
        System.out.println("3. UAH");
        String currency = sc.nextLine();

        switch (currency) {
            case "1":
                account = new Account(client, new Currency("USD"));
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
        }

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
            account.setSumm(account.getSumm() + sum);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public Account findAccount(EntityManager em, Scanner sc) {
        System.out.println("Введите номер счета (id)");
        Long id = Long.parseLong(sc.nextLine());
        Account account = em.find(Account.class, id);
        if (account == null) {
            System.out.println("Такого счета нет");
            return null;
        }
        return account;
    }
}
