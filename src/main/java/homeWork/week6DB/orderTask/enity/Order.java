package homeWork.week6DB.orderTask.enity;

public class Order {
    private int clientId;
    private int productId;

    public Order() {
    }

    public Order(int clientId, int productId) {
        this.clientId = clientId;
        this.productId = productId;
    }

    public int getClientId() {
        return clientId;
    }

    public int getProductId() {
        return productId;
    }
}
