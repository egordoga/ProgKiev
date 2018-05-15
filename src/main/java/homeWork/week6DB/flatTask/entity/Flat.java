package homeWork.week6DB.flatTask.entity;

public class Flat {

    private String region;
    private int square;
    private int roomQuantity;
    private int price;
    private String street;
    private int houseNumber;
    private int flatNumber;

    public Flat(String region, int square, int roomQuantity, int price, String street, int houseNumber, int flatNumber) {
        this.region = region;
        this.square = square;
        this.roomQuantity = roomQuantity;
        this.price = price;
        this.street = street;
        this.houseNumber = houseNumber;
        this.flatNumber = flatNumber;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getSquare() {
        return square;
    }

    public void setSquare(int square) {
        this.square = square;
    }

    public int getRoomQuantity() {
        return roomQuantity;
    }

    public void setRoomQuantity(int roomQuantity) {
        this.roomQuantity = roomQuantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public int getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(int flatNumber) {
        this.flatNumber = flatNumber;
    }

    @Override
    public String toString() {
        return "Flat{" +
                "region=" + region +
                ", square=" + square +
                ", roomQuantity=" + roomQuantity +
                ", price=" + price +
                ", street='" + street + '\'' +
                ", houseNumber=" + houseNumber +
                ", flatNumber=" + flatNumber +
                '}';
    }
}
