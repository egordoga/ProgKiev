package homeWork.taskClientWithPhoto.dao;

import homeWork.taskClientWithPhoto.entity.User;

public interface UserDao {
    void addUser(User user);
    void deleteUser(int id);
}
