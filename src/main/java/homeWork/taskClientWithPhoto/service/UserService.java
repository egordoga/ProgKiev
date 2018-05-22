package homeWork.taskClientWithPhoto.service;

import homeWork.taskClientWithPhoto.entity.User;

public interface UserService {
    void addUser(User user);
    void deleteUser(int id);
}
