package megaCoffee;

import megaCoffee.entities.Product;

public class OrderProduct {
    private Product product;
    private boolean option;

    public OrderProduct(Product product) {
        this.product = product;
    }

    public OrderProduct(Product product, boolean option) {
        this.product = product;
        this.option = option;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public boolean getOption() {
        return option;
    }

    public void setOption(boolean option) {
        this.option = option;
    }

    @Override
    public String toString() {
        return "OrderProduct{" +
                "product=" + product +
                ", option=" + option +
                '}';
    }
}
