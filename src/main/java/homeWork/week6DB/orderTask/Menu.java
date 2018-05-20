package homeWork.week6DB.orderTask;

import homeWork.week6DB.orderTask.dao.OrderDaoImpl;
import homeWork.week6DB.orderTask.enity.Client;
import homeWork.week6DB.orderTask.enity.Order;
import homeWork.week6DB.orderTask.enity.Product;

import java.util.Scanner;

public class Menu {

    private OrderDaoImpl odi = new OrderDaoImpl();
    private Scanner sc = new Scanner(System.in);
    private Client client;
    private Product product;
    private Order order;
    private int clientId;
    private int productId;

    public void mainMenu() {
        String str;

        while (true) {
            System.out.println("1. Добавить клиента");
            System.out.println("2. Добавить товар");
            System.out.println("3. Сделать заказ");
            System.out.println("0. Выход");

            str = sc.nextLine();
            switch (str) {
                case  "1":
                    addClient();
                    break;
                case "2":
                    addProduct();
                    break;
                case "3":
                    if (client == null) {
                        System.out.println("Надо ввести клиента");
                        addClient();
                    }
                    if (product == null) {
                        System.out.println("Надо ввести товар");
                        addProduct();
                    }
                    order = new Order(clientId, productId);
                    odi.addOrder(order);
                    break;
                case "0":
                    sc.close();
                    return;
            }
        }
    }

    private void addProduct() {
        System.out.println("Введите наименование");
        String name = sc.nextLine();
        System.out.println("Введите цену");
        int price = Integer.parseInt(sc.nextLine());
        product = new Product(name, price);
        productId = odi.getIdProductIfExists(product);
    }

    private void addClient() {
        System.out.println("Введите ФИО");
        String fio = sc.nextLine();
        System.out.println("Введите номер телефона");
        String phone = sc.nextLine();
        client = new Client(fio, phone);
        clientId = odi.getIdClientIfExists(client);
    }
}
