package megaCoffee;
import java.util.Scanner;

public class Kiosk {
    // Repository 직접 참조하지 않게 하려면 어떻게 할지 고민해보기 - DTO
    // Product, Option 수량 구현하기
    // DB 연동 생각하기

    ProductDto productDto = new ProductDto();
    OrderDto orderDto = new OrderDto();
    OptionDto optionDto = new OptionDto();
    MemberRepository memberRepository = new MemberRepository();

    final Scanner scanner = new Scanner(System.in);

    private int packingType;
    private int stamp = 0;
    private int choiceMenu;
    private int orderIndex = 0;
    private String id;
    private int password;

    public Kiosk() {

    }

    public void run() {
        choosePackingType();
        chooseMenu();
    }

    private int choosePackingType() {
        System.out.println("1. 포장\t2. 매장");
        System.out.print("입력: ");
        return packingType = scanner.nextInt();
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
        choiceMenu = scanner.nextInt();
        if (choiceMenu == 1)
            orderCoffee();
        if (choiceMenu == 2)
            orderSmoothie();
        if (choiceMenu == 3)
            orderSide();
    }

    private void orderSide() {
        System.out.println("사이드 메뉴입니다. ");
        productDto.getSideList();
        System.out.print("입력: ");
        int choice = scanner.nextInt();
        orderDto.orderRepository.orderProductList.add(orderIndex, new OrderProduct(productDto.productRepository.sideList.get(choice - 1)));
        orderDto.sum += productDto.productRepository.sideList.get(choice - 1).getPrice();
        orderIndex++;
    }

    private void orderSmoothie() {
        System.out.println("스무디 메뉴입니다.");
        productDto.getSmoothieList();
        System.out.print("입력: ");
        int choice = scanner.nextInt();
        orderDto.orderRepository.orderProductList.add(orderIndex, new OrderProduct(productDto.productRepository.smoothieList.get(choice - 1)));
        orderDto.sum += productDto.productRepository.smoothieList.get(choice - 1).getPrice();
        orderIndex++;
    }

    private void orderCoffee() {
        System.out.println("커피 메뉴입니다.");
        productDto.getCoffeeList();
        System.out.print("입력: ");
        int choice = scanner.nextInt();
        orderDto.orderRepository.orderProductList.add(orderIndex, new OrderProduct(productDto.productRepository.coffeeList.get(choice - 1)));
        orderDto.sum += productDto.productRepository.coffeeList.get(choice - 1).getPrice();
        stamp++;
        orderCoffeeShot();
        orderIndex++;
    }

    private void orderCoffeeShot() {
        System.out.println("샷을 추가하시겠습니까? (500원)"); // ArrayList toString?
        System.out.println("1. 예\t2. 아니오");
        System.out.print("입력: ");
        int choice = scanner.nextInt();
        if (choice == 1) {
            orderDto.orderRepository.orderProductList.get(orderIndex).setOption(optionDto.optionRepository.optionList.get(0));
            orderDto.sum += optionDto.optionRepository.optionList.get(0).getOptionPrice();
        }
    }

    private void payment() {
        System.out.println("적립하시겠습니까? ");
        System.out.println("1. 예\t2. 아니오");
        System.out.print("입력: ");
        int choice = scanner.nextInt();
        if (choice == 1) {
            stampcard();
        }
        getReceipt();
    }

    private void getReceipt() {
        System.out.println("\n주문 내역입니다. ");
        orderDto.getOrderSheet();
        if (packingType == 1) {
            System.out.println(orderDto.getTogoReceipt());
        }
        if (packingType == 2) {
            System.out.println(orderDto.getIndoorReceipt());
        }
    }

    private void stampcard() {
        boolean checkMember = true;
        while (checkMember) {
            System.out.println("아이디를 입력하세요.");
            System.out.print("입력: ");
            id = scanner.next();
            System.out.println("비밀번호를 입력하세요. ");
            System.out.print("입력: ");
            password = scanner.nextInt();
            for (int i = 0; i < memberRepository.memberList.size(); i++) {
                if (id.equals(memberRepository.memberList.get(i).getId()) && password == memberRepository.memberList.get(i).getPassword()) {
                    int clientIndex = i;
                    System.out.println("\n" + memberRepository.memberList.get(clientIndex).getId() + " 회원님의 적립 현황입니다. ");
                    memberRepository.memberList.get(clientIndex).setStamp(stamp);
                    System.out.println("스탬프 개수: " + memberRepository.memberList.get(clientIndex).getStamp() + "개");
                    if (stamp >= 3) {
                        System.out.println("커피 쿠폰이 " + memberRepository.memberList.get(clientIndex).getStamp() / 3 + "개 발급되었습니다.");
                    } else {
                        System.out.println("발급된 쿠폰이 없습니다. ");
                    }
                    checkMember = false;
                }
                else {
                    System.out.println("잘못 입력하였습니다.");
                }
            }
        }//stampcard();
    }
}