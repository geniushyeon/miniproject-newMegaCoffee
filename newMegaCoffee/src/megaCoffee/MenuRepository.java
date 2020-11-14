package megaCoffee;
import java.util.*;
public class MenuRepository {
    List<Menu> coffeeMenu = new ArrayList<>();
    List<Menu> smoothieMenu = new ArrayList<>();
    List<Menu> sideMenu = new ArrayList<>();

    public MenuRepository() {
        setMenu();
    }

    private void setMenu() {
        coffeeMenu.add(new Menu("핫 아메리카노", 1500));
        coffeeMenu.add(new Menu("아이스아메리카노", 2000));
        coffeeMenu.add(new Menu("카페 라떼", 2500));
        coffeeMenu.add(new Menu("카페 모카", 3000));
        smoothieMenu.add(new Menu("블루베리 스무디", 4000));
        smoothieMenu.add(new Menu("스트로베리 스무디", 4500));
        smoothieMenu.add(new Menu("요거트 스무디", 5500));
        sideMenu.add(new Menu("허니브레드", 6000));
        sideMenu.add(new Menu("딸기 빙수", 7000));
        sideMenu.add(new Menu("아이스크림크로플", 8000));

    }

    public void getCoffeeMenu() {
        for (Menu m : coffeeMenu) {
            System.out.println(m);
        }
    }
    public void getSmoothieMenu() {
        for (Menu m : smoothieMenu) {
            System.out.println(m);
        }
    }

    public void getSideMenu() {
        for (Menu m : sideMenu) {
            System.out.println(m);
        }
    }

}
