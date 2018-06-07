package homeWork.bank1.dao;

import javax.persistence.EntityManager;
import java.util.Scanner;

public interface CurrencyDao {
    void addCurrency(EntityManager em, Scanner sc);
    homeWork.bank1.entity.Currency findCurrency(Long idc, EntityManager em);
}
