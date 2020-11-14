package megaCoffee;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository {
    List<Menu> orderList = new ArrayList<>();

    public void getReceipt() {
        for (Menu m : orderList) {
            System.out.println(m);
        }
    }

}
