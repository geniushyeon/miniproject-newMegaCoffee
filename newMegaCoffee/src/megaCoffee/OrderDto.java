package megaCoffee;
public class OrderDto {

    OrderRepository orderRepository = new OrderRepository();
    public int sum = 0;

    public void getOrderSheet() {
        for (OrderProduct op : orderRepository.orderProductList) {
            System.out.println(op);
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
