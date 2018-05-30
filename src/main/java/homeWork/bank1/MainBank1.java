package homeWork.bank1;

import homeWork.bank1.dao.AccountDaoImpl;
import homeWork.bank1.entity.Account;
import homeWork.bank1.entity.Client;
import homeWork.bank1.service.Service;
import homeWork.bank1.service.ServiceImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class MainBank1 {
    public static void main(String[] args) {
        EntityManagerFactory mf = Persistence.createEntityManagerFactory("JPABank1");
        EntityManager em = mf.createEntityManager();

        Scanner sc = new Scanner(System.in);

        Service service = new ServiceImpl();

        try {
            while (true) {
                System.out.println("1.Добавить клиента");
                System.out.println("2.Добавить счет");
                System.out.println("3.Внести сумму");
                System.out.println("4.Выдать сумму");
                System.out.println("5.Произвести перевод средств");
                System.out.println("6.Добавить валюту");
                System.out.println("0.Выход");
                String choice = sc.nextLine();

                switch (choice) {
                    case "1":
                        service.addClient(em, sc);
                        break;
                    case "2":
                        service.createAccount(em, sc);
                        break;
                    case "3":
                        System.out.println("Какая сумма?");
                        Double sum = Double.parseDouble(sc.nextLine());
                        Account account = service.findAccount(em, sc);
                        Account account1 = em.find(Account.class, 5); //касса
                        service.addSum(account, sum, em);
                        service.writeTransaction(account1, account, sum, em);
                        break;
                    case "4":
                        System.out.println("Какая сумма?");
                        Double summ = Double.parseDouble(sc.nextLine());
                        Account from = service.findAccount(em, sc);
                        if (from.getSumm() > summ) {
                            Account to = em.find(Account.class, 5); //касса
                            summ = -summ;
                            service.addSum(from, summ, em);
                            service.writeTransaction(from, to, summ, em);
                        } else {
                            System.out.println("Не достаточно средств");
                        }
                        break;
                    case "5":
                        System.out.println("Какая сумма?");
                        Double summm = Double.parseDouble(sc.nextLine());
                        Account fromm = service.findAccount(em, sc);
                        Account too = service.findAccount(em, sc);
                        if (!(fromm.getCurrency().getName().equals(too.getCurrency().getName()))) {
                            summm = summm * fromm.getCurrency().getRates().getValue();
                        }
                        if (fromm.getSumm() > summm) {
                            service.addSum(fromm, summm, em);
                            service.writeTransaction(fromm, too, summm, em);
                        } else {
                            System.out.println("Не достаточно средств");
                        }
                        break;
                    case "6":
                        service.addCurrency(em, sc);
                        service.changeRate(em, sc);
                        break;
                    case "0":
                        return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            mf.close();
        }


    }
}
