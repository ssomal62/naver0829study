package myshop.data;

import java.sql.Timestamp;

public class myShopDTO {

    private int num;
    private String productName;
    private int photo;
    private int price;
    private String color;
    private Timestamp writeDay;

    public void setNum(int num) {
        this.num = num;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setWriteDay(Timestamp writeDay) {
        this.writeDay = writeDay;
    }

    public int getNum() {
        return num;
    }

    public String getProductName() {
        return productName;
    }

    public int getPhoto() {
        return photo;
    }

    public int getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }

    public Timestamp getWriteDay() {
        return writeDay;
    }
}



