package homeWork.bank1.dao;

import homeWork.bank1.entity.Client;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.Scanner;

public class ClientDaoImpl implements ClientDao {
    @Override
    public void addClient(EntityManager em, Scanner sc) {
        System.out.println("Введите фамилию");
        String str = sc.nextLine();
        Client client = new Client(str);
        try {
            em.getTransaction().begin();
            em.persist(client);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Can`t add client. Wrong transaction");
        }
    }

    @Override
    public Client findClient(EntityManager em, Scanner sc) {
        System.out.println("Введите фамилию"); // считаем, что фамилия уникальна
        String fio = sc.nextLine();
        Client client = null;
        try {
            Query query = em.createQuery("select client from Client client where client.fio = :fio", Client.class);
            query.setParameter("fio", fio);
            client = (Client) query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println("Такого клиента не найдено");
        }
        return client;
    }
}
