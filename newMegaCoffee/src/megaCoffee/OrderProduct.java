package megaCoffee;

import megaCoffee.entities.Option;
import megaCoffee.entities.Product;

public class OrderProduct {
    private Product product;
    private Option option;

    public OrderProduct(Product product) {
        this.product = product;
    }


    public void setOption(Option option) {
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
