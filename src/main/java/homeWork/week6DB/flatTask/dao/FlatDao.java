package homeWork.week6DB.flatTask.dao;

import homeWork.week6DB.flatTask.entity.Address;
import homeWork.week6DB.flatTask.entity.Flat;

import java.util.List;

public interface FlatDao {
    List<Flat> getAll();
    void add(Flat flat);
    Flat findById(int id);
    Flat findByIAddress(Address address);
}
