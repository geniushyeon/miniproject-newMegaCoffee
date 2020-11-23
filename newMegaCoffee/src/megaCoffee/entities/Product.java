package megaCoffee.entities;

public class Product {

    private ProductType productType;
    private int productId;
    private String name;
    private int price;

    public Product(int productId, ProductType productType, String name, int price) {
        this.productId = productId;
        this.productType = productType;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", name='" + name + ", " +
                ", price=" + price +
                "}";
    }
}
