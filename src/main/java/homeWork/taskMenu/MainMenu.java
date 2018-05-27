package homeWork.taskMenu;

import homeWork.taskMenu.entity.Menu;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainMenu {
    private static EntityManagerFactory emf;
    private static EntityManager em;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        try {
            emf = Persistence.createEntityManagerFactory("JPAMenu");
            em = emf.createEntityManager();

            while (true) {
                System.out.println("1.Добавить блюдо");
                System.out.println("2.Задать границы цены");
                System.out.println("3.Выбрать со скидкой");
                System.out.println("0.Выход");
                String choice = sc.nextLine();

                switch (choice) {
                    case "1" :
                        addDish(sc);
                        break;
                    case "2" :
                        choiceLessKg(getDishByPrice(sc));
                        break;
                    case "3" :
                        choiceLessKg(getDishByDiscount());
                        break;
                    case "0" :
                        return;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            sc.close();
            em.close();
            emf.close();
        }
    }

    private static void addDish(Scanner sc) {
        System.out.println("Введите наименование");
        String name = sc.nextLine();
        System.out.println("Введите цену");
        int price = Integer.parseInt(sc.nextLine());
        System.out.println("Введите вес");
        int weight = Integer.parseInt(sc.nextLine());
        System.out.println("Введите процент скидки");
        Integer discount;
        Menu menu;
        String str = sc.nextLine();
        if ("".equals(str) || Integer.parseInt(str) == 0) {
            menu = new Menu(name, price, weight);
        } else {
            discount = Integer.parseInt(str);
            menu = new Menu(name, price, weight, discount);
        }


        try {
            em.getTransaction().begin();
            em.persist(menu);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("No transaction");
        }
    }

    private static List<Menu> getDishByPrice(Scanner sc) {
        List<Menu> list = new ArrayList<>();

        System.out.println("Введите min цену");
        int minPrice = Integer.parseInt(sc.nextLine());
        System.out.println("Введите max цену");
        int maxPrice = Integer.parseInt(sc.nextLine());

        try {
            Query query = em.createQuery("select m from Menu m " +
                    "where m.price >= :min_price and  m.price <= :max_price", Menu.class);
            query.setParameter("min_price", minPrice);
            query.setParameter("max_price", maxPrice);
            list = (List<Menu>) query.getResultList();
        } catch (NoResultException e) {
            System.out.println("No result");
        }
        return list;
    }

    private static List<Menu> getDishByDiscount() {
        List<Menu> list = new ArrayList<>();

        try {
            Query query = em.createQuery("select m from Menu m where m.discount is not null", Menu.class);

            list = (List<Menu>) query.getResultList();
        } catch (NoResultException e) {
            System.out.println("No result");
        }
        return list;
    }

    private static void choiceLessKg(List<Menu> list) {
        int weight = 0;
        Menu menu;
        List<Menu> thinList = new ArrayList<>();
        for (Menu aList : list) {
            weight += aList.getWeight();
            if (weight > 1000) {   //считаем, что нет блюд более 1 кг.
                thinList.forEach(System.out::println);
                return;
            } else {
                menu = aList;
                thinList.add(menu);
            }
        }
        list.forEach(System.out::println);
    }
}
