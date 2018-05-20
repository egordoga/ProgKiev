package homeWork.week6DB.orderTask.dao;

import homeWork.week6DB.orderTask.enity.Client;
import homeWork.week6DB.orderTask.enity.Order;
import homeWork.week6DB.orderTask.enity.Product;
import homeWork.week6DB.orderTask.util.UtilsDB;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDaoImpl implements OrderDao {
    @Override
    public int getIdClientIfExists(Client client) {
        Connection conn = UtilsDB.getConnection();
        int id = -1;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            id = idIfExists(client, conn);
            if (id == 0) {
                ps = conn.prepareStatement("insert into orderdb.client (fio, phone) values (?, ?)");
                ps.setString(1, client.getFio());
                ps.setString(2, client.getPhone());
                ps.executeUpdate();
                ps = conn.prepareStatement("select * from orderdb.client where `fio` = ? and `phone` = ? limit 1");
                ps.setString(1, client.getFio());
                ps.setString(2, client.getPhone());

                rs = ps.executeQuery();
                while (rs.next()) {
                    id = rs.getInt("id");
                }

            }
        } catch (NoSuchFieldException | IllegalAccessException | SQLException e) {
            e.printStackTrace();
        } finally {
            UtilsDB.closeConnection(conn, ps, rs);
        }
        return id;
    }

    @Override
    public int getIdProductIfExists(Product product) {
        Connection conn = UtilsDB.getConnection();
        int id = -1;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            id = idIfExists(product, conn);
            if (id == 0) {
                ps = conn.prepareStatement("insert into orderdb.product (name, price) values (?, ?)");
                ps.setString(1, product.getName());
                ps.setInt(2, product.getPrice());
                ps.executeUpdate();
                ps = conn.prepareStatement("select * from product where name = ? and price = ? limit 1");
                ps.setString(1, product.getName());
                ps.setInt(2, product.getPrice());
                rs = ps.executeQuery();
                while (rs.next()) {
                    id = rs.getInt("id");
                }

            }
        } catch (NoSuchFieldException | IllegalAccessException | SQLException e) {
            e.printStackTrace();
        } finally {
            UtilsDB.closeConnection(conn, ps, rs);
        }
        return id;
    }

    @Override
    public void addOrder(Order order) {
        Connection conn = UtilsDB.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("insert into orderdb.order (client_id, product_id) values (?, ?)");
            ps.setInt(1, order.getClientId());
            ps.setInt(2, order.getProductId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            UtilsDB.closeConnection(conn, ps, null);
        }
    }

    private int idIfExists(Object obj, Connection conn) throws NoSuchFieldException, IllegalAccessException {
        int ifIdExists = 0;
        String sql = null;
        String firstPar = null;
        String secondPar = null;

        if (obj.getClass() == Client.class) {
            sql = "select * from orderdb.client where fio = ? and phone = ? limit 1";
            Field field;
            field = obj.getClass().getDeclaredField("fio");
            field.setAccessible(true);
            firstPar = (String) field.get(obj);
            field = obj.getClass().getDeclaredField("phone");
            field.setAccessible(true);
            secondPar = (String) field.get(obj);
        }
        if (obj.getClass() == Product.class) {
            sql = "select * from `product` where `name` = ? and `price` = ? limit 1";
            Field field;
            field = obj.getClass().getDeclaredField("name");
            field.setAccessible(true);
            firstPar = (String) field.get(obj);
            field = obj.getClass().getDeclaredField("price");
            field.setAccessible(true);
            secondPar = "" + field.get(obj);
        }
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, firstPar);
            ps.setString(2, secondPar);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    ifIdExists = rs.getInt("id");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ifIdExists;
    }

    /*
     * И сразу вопрос.
     * Как правильно (более эффективно) делать - двумя почти одинаковыми методами
     * getIdProductIfExists, getIdClientIfExists
     * или одним, но заморачиваться с рефлексией?
     * idIfExists
     **/
}
