package ch7;

public class Buyer {
    int money = 1000;
    int bonusPoint = 0;
    Product[] item = new Product[10];
    int i = 0;

    void buy(Product p) {
        if (money < p.price) {
            System.err.println("잔액이 부족해요.");
            return;
        }
        money -= p.price;
        bonusPoint += p.bonusPoint;
        item[i++] = p;
        System.out.println(p + "을(를) 구입하셨어요.");
    }

    void summary() {
        int sum = 0 ;
        String itemList = "";
        for(int i = 0 ; i < item.length; ++i){
            if(null ==item[i]){
                break;
            }

            sum += item[i].price;
            itemList += item[i] + ", ";
        }

        System.out.println("구입하신 물품의 총 금액은" + sum + "만원이에요.");
        System.out.println("구입하신 물품은" + itemList + "만원이에요.");
    }
}
