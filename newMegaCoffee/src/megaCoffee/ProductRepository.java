package megaCoffee;

import megaCoffee.entities.Product;
import megaCoffee.entities.ProductType;

import java.util.*;

public class ProductRepository {
    List<Product> productList = new ArrayList<>();
    List<Product> coffeeList = new ArrayList<>();
    List<Product> smoothieList = new ArrayList<>();
    List<Product> sideList = new ArrayList<>();

    public ProductRepository() {
        setMenu();
        getCoffeeList();
        getSmoothieList();
        getSideList();
    }

    private void setMenu() {
        productList.add(new Product(1, ProductType.COFFEE, "핫 아메리카노", 1500));
        productList.add(new Product(2, ProductType.COFFEE,"아이스아메리카노", 2000));
        productList.add(new Product(3, ProductType.COFFEE,"카페 라떼", 2500));
        productList.add(new Product(4, ProductType.COFFEE,"카페 모카", 3000));
        productList.add(new Product(5, ProductType.SMOOTHIE, "블루베리 스무디", 4000));
        productList.add(new Product(6, ProductType.SMOOTHIE,"스트로베리 스무디", 4500));
        productList.add(new Product(7, ProductType.SMOOTHIE,"요거트 스무디", 5500));
        productList.add(new Product(8, ProductType.SIDE, "허니브레드", 6000));
        productList.add(new Product(9, ProductType.SIDE, "딸기 빙수", 7000));
        productList.add(new Product(10, ProductType.SIDE, "아이스크림크로플", 8000));
    }

//    public List<Product> getCoffeeList() {
//
//        return productList.stream().filter(x -> ProductType.COFFEE.equals(x.getProductType()))
//                .collect(Collectors.toList()); // 코드 분석하기
//
//    }

    public List<Product> getCoffeeList() {
        for (int i=0; i<productList.size(); i++) {
            if (productList.get(i).getProductType() == ProductType.COFFEE) {
                coffeeList.add(productList.get(i));
            }
        }
        return coffeeList;
    }


    public List<Product> getSmoothieList() {
        for (int i=0; i<productList.size(); i++) {
            if (productList.get(i).getProductType() == ProductType.SMOOTHIE) {
            smoothieList.add(productList.get(i));
            }
        }
        return smoothieList;
    }

    public List<Product> getSideList() {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getProductType() == ProductType.SIDE) {
                sideList.add(productList.get(i));
            }
        }
        return sideList;
    }

}
