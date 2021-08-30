package ch7;

class Product5{
    int price;                  // 제품의 가격
    int bonusPoint;             // 제품 구매 시 제공하는 보너스 점수

    Product5(int price){
        this.price = price;
        bonusPoint = (int)(price / 10.0);       // 보너스 점수는 제품가격의 10%
    }

    Product5(){}        // 기본 생성자
}

class Tv5 extends Product5{
    Tv5(){
        // 조상클래스의 생성자 Product(int price) 를 호출한다.
        super(100);
    }

    public String toString(){      // Object클래스의 toString()을 오버라이딩 한다.
        return "Tv";
    }
}

class Computer5 extends Product5{
    Computer5(){
        super(200);
    }

    public String toString(){
        return "Computer";
    }
}

class Audio5 extends Product5{
    Audio5() {super(50); }

    public String toString(){
        return "Audio";
    }
}

class Buyer5{                // 고객, 물건을 사는 사람
    int money = 1000;       // 소유금액
    int bonusPoint = 0;     // 보너스 점수
    Product5[] item = new Product5[10];         // 구매한 제품을 저장하기 위한 배열
    int i = 0;

    void buy(Product5 p){
        if(money < p.price){
            System.out.println("잔액이 부족하여 물건을 살 수 없습니다.");
            return;
        }

        money -= p.price;               // 가진 돈에서 구입한 제품의 가격을 뺀다.
        bonusPoint += p.bonusPoint;     // 제품의 보너스 점수를 추가한다.
        item[i++] = p;
        System.out.println(p + "을/를 구입하셨습니다.");
    }

    void summary(){         // 구매한 물품에 대한 정보를 요약해서 보여 준다.
        int sum = 0;        // 구입한 물품의 가격합계
        String itemList = "";   // 구입한 물품 목록

        // 반목문을 이용해서 구입한 물품의 총 가격과 목록을 만든다.
        for (int i = 0; i < item.length; i++) {
            if(item[i] == null) break;
            sum += item[i].price;
            itemList += item[i] + ",";
        }
        System.out.println("구입하신 물품의 총 금액은 " + sum + "만원입니다.");
        System.out.println("구입하신 제품은 " + itemList + "입니다.");
    }
}

public class PolyArgumentTest2 {
    public static void main(String[] args) {
        Buyer5 b = new Buyer5();

        b.buy(new Tv5());
        b.buy(new Computer5());
        b.buy(new Audio5());
        b.summary();
    }
}

