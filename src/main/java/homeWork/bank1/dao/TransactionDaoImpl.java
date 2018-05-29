package homeWork.bank1.dao;

import homeWork.bank1.entity.Account;
import homeWork.bank1.entity.Transaction;

import javax.persistence.EntityManager;

public class TransactionDaoImpl implements TransactionDao {
    @Override
    public void writeTransaction(Account from, Account to, Double summ, EntityManager em) {
        Transaction transaction = new Transaction(from, to, summ);
        em.getTransaction().begin();
        try {
            em.persist(transaction);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Транзакция не записана");
        }
    }
}
