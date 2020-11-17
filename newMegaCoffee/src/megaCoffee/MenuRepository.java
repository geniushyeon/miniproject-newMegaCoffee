package megaCoffee;
import java.util.*;
public class MenuRepository {
    List<Product> coffeeProducts = new ArrayList<>();
    List<Product> smoothieProducts = new ArrayList<>();
    List<Product> sideProducts = new ArrayList<>();

    public MenuRepository() {
        setMenu();
    }

    private void setMenu() {
        coffeeProducts.add(new Product("핫 아메리카노", 1500));
        coffeeProducts.add(new Product("아이스아메리카노", 2000));
        coffeeProducts.add(new Product("카페 라떼", 2500));
        coffeeProducts.add(new Product("카페 모카", 3000));
        smoothieProducts.add(new Product("블루베리 스무디", 4000));
        smoothieProducts.add(new Product("스트로베리 스무디", 4500));
        smoothieProducts.add(new Product("요거트 스무디", 5500));
        sideProducts.add(new Product("허니브레드", 6000));
        sideProducts.add(new Product("딸기 빙수", 7000));
        sideProducts.add(new Product("아이스크림크로플", 8000));
    }

    public void getCoffeeMenu() {
        for (Product p : coffeeProducts) {
            System.out.println(p);
        }
    }

    public void getSmoothieMenu() {
        for (Product p : smoothieProducts) {
            System.out.println(p);
        }
    }

    public void getSideMenu() {
        for (Product p : sideProducts) {
            System.out.println(p);
        }
    }

}
