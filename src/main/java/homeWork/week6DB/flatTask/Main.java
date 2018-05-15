package homeWork.week6DB.flatTask;

import homeWork.week6DB.flatTask.dao.FlatDao;
import homeWork.week6DB.flatTask.dao.FlatDaoImpl;

public class Main {

    public static void main(String[] args) {
        FlatDao flatDao = new FlatDaoImpl();

        flatDao.getAll().forEach(System.out::println);
    }
}
