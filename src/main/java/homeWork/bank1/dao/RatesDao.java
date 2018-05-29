package homeWork.bank1.dao;

import homeWork.bank1.entity.Currency;

import javax.persistence.EntityManager;
import java.util.Scanner;

public interface RatesDao {
    Double getRate(EntityManager em, Currency currency);
    void changeRate(EntityManager em, Scanner sc);
}
