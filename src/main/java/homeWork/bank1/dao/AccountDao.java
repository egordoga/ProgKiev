package homeWork.bank1.dao;

import homeWork.bank1.entity.Account;

import javax.persistence.EntityManager;
import java.util.Scanner;

public interface AccountDao {
    void createAccount(EntityManager em, Scanner sc);
    void addSum (Account account, Double summ, EntityManager em);
    Account findAccount(EntityManager em, Scanner sc);
}
