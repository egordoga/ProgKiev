package homeWork.bank1.service;

import homeWork.bank1.entity.Account;
import homeWork.bank1.entity.Client;
import homeWork.bank1.entity.Currency;

import javax.persistence.EntityManager;
import java.util.Scanner;

public interface Service {

    //Всё свалил в кучу - пока не понимаю смысл разделения

    void addClient(EntityManager em, Scanner sc);
    Client findClient(EntityManager em, Scanner sc);
    void writeTransaction(Account from, Account to, Double summ, EntityManager em);
    void createAccount(EntityManager em, Scanner sc);
    void addSum (Account account, Double summ, EntityManager em);
    Account findAccount(EntityManager em, Scanner sc);
    Double getRate(EntityManager em, Currency currency);
    void changeRate(EntityManager em, Scanner sc);
}
