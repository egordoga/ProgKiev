package homeWork.bank1.dao;

import homeWork.bank1.entity.Account;

import javax.persistence.EntityManager;

public interface TransactionDao {
    void writeTransaction(Account from, Account to, Double summ, EntityManager em);
}
