package megaCoffee;

import megaCoffee.entities.Product;

public class ProductService {
    ProductRepository productRepository = new ProductRepository();

    public void getCoffeeList() {
        for (Product p : productRepository.coffeeList) {
            System.out.println(p);
        }
    }

    public void getSmoothieList() {
        for (Product p : productRepository.smoothieList) {
            System.out.println(p);
        }
    }

    public void getSideList() {
        for (Product p : productRepository.sideList) {
            System.out.println(p);
        }
    }
}
