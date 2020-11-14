package megaCoffee;
import java.util.Scanner;
public class Kiosk {

    MenuRepository menuRepository = new MenuRepository();
    OrderRepository orderRepository = new OrderRepository();
    MemberRepository memberRepository = new MemberRepository();

    final Scanner scanner = new Scanner(System.in);

    private int packingType;
    private int stamp = 0;

    public Kiosk() {

    }

    public void run() {
        choosePackingType();
        chooseMenu();
    }

    private void choosePackingType() {
        System.out.println("1. 포장\t2. 매장");
        System.out.print("입력: ");
        packingType = scanner.nextInt();
    }

    private void chooseMenu() {
        for (;;) {
            System.out.println("1. 주문\t2. 결제");
            System.out.print("입력: ");
            int choice = scanner.nextInt();
            if (choice == 1)
                order();
            if (choice == 2) {
                payment();
                break;
            }
        }
    }

    private void order() {
        System.out.println("주문하실 메뉴를 골라주세요. ");
        System.out.println("1. 커피\t2. 스무디\t3. 사이드");
        System.out.print("입력: ");
        int choice = scanner.nextInt();
        if (choice == 1)
            orderCoffee();
        if (choice == 2)
            orderSmoothie();
        if (choice == 3)
            orderSide();
    }

    private void orderSide() {
        System.out.println("사이드 메뉴입니다. ");
        menuRepository.getSideMenu();
        System.out.print("입력: ");
        int choice = scanner.nextInt();
        orderRepository.orderList.add(menuRepository.sideMenu.get(choice - 1));
        orderRepository.sum += menuRepository.sideMenu.get(choice-1).getPrice();

    }

    private void orderSmoothie() {
        System.out.println("스무디 메뉴입니다.");
        menuRepository.getSmoothieMenu();
        System.out.print("입력: ");
        int choice = scanner.nextInt();
        orderRepository.orderList.add(menuRepository.smoothieMenu.get(choice - 1));
        orderRepository.sum += menuRepository.smoothieMenu.get(choice-1).getPrice();
    }

    private void orderCoffee() {
        System.out.println("커피 메뉴입니다.");
        menuRepository.getCoffeeMenu();
        System.out.print("입력: ");
        int choice = scanner.nextInt();
        orderRepository.orderList.add(menuRepository.coffeeMenu.get(choice - 1));
        orderRepository.sum += menuRepository.smoothieMenu.get(choice-1).getPrice();
        stamp++;
    }

    private void payment() {
        System.out.println("적립하시겠습니까? ");
        System.out.println("1. 예\t2. 아니오");
        System.out.print("입력: ");
        int choice = scanner.nextInt();
        if (choice == 1)
            stampcard();
        if (choice == 2)
            getReceipt();
    }

    private void getReceipt() {
        System.out.println("\n주문 내역입니다. ");
        orderRepository.getOrderList();
        if (packingType == 1) {
            orderRepository.getTogoReceipt();
        }
        if (packingType == 2) {
            orderRepository.getIndoorReceipt();
        }
    }

    private void stampcard() {
        for (;;) {
            System.out.println("아이디를 입력하세요.");
            System.out.print("입력: ");
            String id = scanner.next();
            // memberList 배열 돌면서 찾기
            for (int i = 0; i < memberRepository.memberList.size(); i++) {
                // 1. id 일치여부 확인
                if (id.equals(memberRepository.memberList.get(i).getId())) {
                    int clientIndex = i;
                    // 2. 비밀번호 일치여부 확인
                    System.out.println("비밀번호를 입력하세요. ");
                    System.out.print("입력: ");
                    int password = scanner.nextInt();
                    if (password == memberRepository.memberList.get(clientIndex).getPassword()) {
                        System.out.println("\n" + id + " 회원님의 적립 현황입니다. ");
                        memberRepository.memberList.get(clientIndex).setStamp(stamp);
                        System.out.println("스탬프 개수: " + stamp + "개");
                        if (stamp % 3 == 0) {
                            System.out.println("커피 쿠폰이 " + stamp / 3 + "개 발급되었습니다.");
                            break;
                        }
                        if (stamp < 3) {
                            System.out.println("발급된 쿠폰이 없습니다. ");
                            break;
                        }
                        getReceipt();
                    }
                }else {
                    System.out.println("잘못 입력하였습니다. ");
                    break;

                }
            }
        }
    }//stampcard();

}