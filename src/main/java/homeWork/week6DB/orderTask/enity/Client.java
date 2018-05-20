package homeWork.week6DB.orderTask.enity;

public class Client {
    private int id;
    private String fio;
    private String phone;

    public Client() {
    }

    public Client(String fio, String phone) {
        this.fio = fio;
        this.phone = phone;
    }

    public String getFio() {
        return fio;
    }

    public String getPhone() {
        return phone;
    }

}
