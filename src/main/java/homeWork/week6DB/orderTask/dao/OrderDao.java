package homeWork.week6DB.orderTask.dao;

import homeWork.week6DB.orderTask.enity.Client;
import homeWork.week6DB.orderTask.enity.Order;
import homeWork.week6DB.orderTask.enity.Product;

public interface OrderDao {
    int getIdClientIfExists(Client client);
    int getIdProductIfExists(Product product);
    void addOrder(Order order);
}
