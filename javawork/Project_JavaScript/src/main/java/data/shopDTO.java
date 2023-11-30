package data;

public class shopDTO {

    private String product;
    private String photo;
    private int price;
    private String color;

    public shopDTO() {
        super();
    }

    public shopDTO(String product, String photo, int price, String color) {
        this.product = product;
        this.photo = photo;
        this.price = price;
        this.color = color;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getProduct() {
        return product;
    }

    public String getPhoto() {
        return photo;
    }

    public int getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }
}

