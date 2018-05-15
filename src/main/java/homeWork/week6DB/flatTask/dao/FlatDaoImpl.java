package homeWork.week6DB.flatTask.dao;

import homeWork.week6DB.flatTask.entity.Flat;
import homeWork.week6DB.flatTask.utilsDB.UtilsDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FlatDaoImpl implements FlatDao {
    @Override
    public List<Flat> getAll() {

        List<Flat> list = new ArrayList<>();
        Connection conn = UtilsDB.getConnection();
        Statement st = null;
        ResultSet rs = null;
        try {
             st = conn.createStatement();
             rs = st.executeQuery("select f.square, f.room_quantity, f.price , a.street, a.house_number, a.flat_number, r.name from flat f " +
                    "inner join address a on f.address_id=a.id " +
                    "inner join region r on a.region_id=r.id ");


            while (rs.next()) {
                int square = rs.getInt("square");
                int roomQuantity = rs.getInt("room_quantity");
                int price = rs.getInt("price");
                String street = rs.getString("street");
                int houseNumber = rs.getInt("house_number");
                int flatNumber = rs.getInt("flat_number");
                String region = rs.getString("name");

                Flat flat = new Flat(region, square, roomQuantity, price, street, houseNumber, flatNumber);
                list.add(flat);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
           UtilsDB.closeConnection(conn, st, rs);
        }
        return list;
    }


    @Override
    public List<Flat> findByRoomQuantity(int roomQuantity) {
        List<Flat> list = new ArrayList<>();
        Connection conn = UtilsDB.getConnection();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = conn.createStatement();
            rs = st.executeQuery("select f.square, f.room_quantity, f.price , a.street, a.house_number, a.flat_number, r.name from flat f " +
                    "inner join address a on f.address_id=a.id " +
                    "inner join region r on a.region_id=r.id " +
                    "where room_quantity=" + roomQuantity);


            while (rs.next()) {
                int square = rs.getInt("square");
                int price = rs.getInt("price");
                String street = rs.getString("street");
                int houseNumber = rs.getInt("house_number");
                int flatNumber = rs.getInt("flat_number");
                String region = rs.getString("name");

                Flat flat = new Flat(region, square, roomQuantity, price, street, houseNumber, flatNumber);
                list.add(flat);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            UtilsDB.closeConnection(conn, st, rs);
        }
        return list;
    }

    @Override
    public Flat findByRegion(String region) {
        // В принципе всё то-же
        return null;
    }


}
