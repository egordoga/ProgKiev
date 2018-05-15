package homeWork.week6DB.flatTask.dao;

import homeWork.week6DB.flatTask.entity.Address;
import homeWork.week6DB.flatTask.entity.Flat;
import homeWork.week6DB.flatTask.utilsDB.UtilsDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class FlatDaoImpl implements FlatDao {
    public List<Flat> getAll() {
        Connection conn = UtilsDB.getConnection();
        try {
           // PreparedStatement ps = conn.prepareStatement()
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void add(Flat flat) {

    }

    public Flat findById(int id) {
        return null;
    }

    public Flat findByIAddress(Address address) {
        return null;
    }
}
