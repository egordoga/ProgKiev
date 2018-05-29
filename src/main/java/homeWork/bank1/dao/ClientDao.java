package homeWork.bank1.dao;

import homeWork.bank1.entity.Client;

import javax.persistence.EntityManager;
import java.util.Scanner;

public interface ClientDao {
    void addClient(EntityManager em, Scanner sc);
    Client findClient(EntityManager em, Scanner sc);
}
