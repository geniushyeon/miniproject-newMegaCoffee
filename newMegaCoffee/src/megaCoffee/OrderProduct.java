package megaCoffee;

import megaCoffee.entities.Product;

public class OrderProduct {
    private Product product;
    private String optionName;
    private int optionPrice;

    public OrderProduct(Product product) {
        this.product = product;
    }

    public OrderProduct(Product product, String optionName, int optionPrice) {
        this.product = product;
        this.optionName = optionName;
        this.optionPrice = optionPrice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    public int getOptionPrice() {
        return optionPrice;
    }

    public void setOptionPrice(int optionPrice) {
        this.optionPrice = optionPrice;
    }

    @Override
    public String toString() {
        return "OrderProduct{" +
                "product=" + product +
                ", optionName='" + optionName + '\'' +
                ", optionPrice=" + optionPrice +
                '}';
    }
}
