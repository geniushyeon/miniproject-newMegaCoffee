package megaCoffee;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository {
    List<OrderProduct> orderProductList = new ArrayList<>();
    public int sum = 0;

    public void getOrderList() {
        for (OrderProduct m : orderProductList) {
            System.out.println(m);
        }
    }

    public String getIndoorReceipt() {
        return "총 결제 금액: " + sum + "원";
    }

    public String getTogoReceipt() {
        sum = (int)(sum * 0.9);
        return "포장할인 10%가 적용되었습니다.\n총 결제 금액: " + sum + "원";
    }

}
