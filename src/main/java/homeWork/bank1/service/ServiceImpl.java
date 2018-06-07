package homeWork.bank1.service;

import homeWork.bank1.dao.*;
import homeWork.bank1.entity.Account;
import homeWork.bank1.entity.Client;
import homeWork.bank1.entity.Currency;

import javax.persistence.EntityManager;
import java.util.Scanner;

public class ServiceImpl implements Service {

    //Всё свалил в кучу - пока не понимаю смысл разделения

    private ClientDao clientDao = new ClientDaoImpl();
    private TransactionDao td = new TransactionDaoImpl();
    private AccountDao accountDao = new AccountDaoImpl();
    private RatesDao ratesDao = new RatesDaoImpl();
    private CurrencyDao currency = new CurrencyDaoImpl();

    @Override
    public void addClient(EntityManager em, Scanner sc) {
        clientDao.addClient(em, sc);
    }

    @Override
    public Client findClient(EntityManager em, Scanner sc) {
        return clientDao.findClient(em, sc);
    }

    @Override
    public void writeTransaction(Account from, Account to, Double summ, EntityManager em) {
        td.writeTransaction(from, to, summ, em);
    }

    @Override
    public void createAccount(EntityManager em, Scanner sc) {
        System.out.println("В какщй валюте счет?");
        System.out.println("1.USD");
        System.out.println("2.EUR");
        System.out.println("3.UAH");
        String curr = sc.nextLine();
        Long id = Long.parseLong(curr);

        Currency curren = currency.findCurrency(id, em);

        Client client = clientDao.findClient(em, sc);
        accountDao.createAccount(client, curren, em, sc);
    }

    @Override
    public void addSum(Account account, Double summ, EntityManager em) {
        accountDao.addSum(account, summ, em);
    }

    @Override
    public Account findAccount(EntityManager em, Scanner sc) {
        return accountDao.findAccount(em, sc);
    }

    @Override
    public Double getRate(EntityManager em, Currency currency) {
        return ratesDao.getRate(em, currency);
    }

    @Override
    public void changeRate(EntityManager em, Scanner sc) {
        ratesDao.changeRate(em, sc);
    }

    @Override
    public void addCurrency(EntityManager em, Scanner sc) {
        currency.addCurrency(em, sc);
    }
}
