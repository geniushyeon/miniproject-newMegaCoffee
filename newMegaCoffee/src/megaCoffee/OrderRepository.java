package megaCoffee;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository {
    List<Menu> orderList = new ArrayList<>();
    public int sum = 0;

    public void getOrderList() {
        for (Menu m : orderList) {
            System.out.println(m);
        }
    }

    public void getIndoorReceipt() {
        System.out.println("총 결제 금액: " + sum + "원");
    }
    public void getTogoReceipt() {
        sum = (int)(sum * 0.9);
        System.out.println("포장할인 10%가 적용되었습니다. ");
        System.out.println("총 결제 금액: " + sum + "원");
    }

}
