package ch7;

public class Product {
    int price;
    int bonusPoint;

    Product() {}
    Product(int price){
        this.price = price;
        bonusPoint = (int)(price/10.0);
    }
}
