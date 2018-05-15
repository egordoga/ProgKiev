package homeWork.week6DB.flatTask.dao;

import homeWork.week6DB.flatTask.entity.Flat;

import java.util.List;

public interface FlatDao {
    List<Flat> getAll();
    List<Flat> findByRoomQuantity(int roomQuantity);
    Flat findByRegion(String region);
}
