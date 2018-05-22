package homeWork.taskClientWithPhoto.controlleer;

import homeWork.taskClientWithPhoto.entity.User;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class MainController {
    private User user = new User();

    public User getUser() {
        return user;
    }
}
