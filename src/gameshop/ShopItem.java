package gameshop;

public class ShopItem {
    Weapon item;
    int numberInStock;
    ShopItem left;
    ShopItem right;
    
    public ShopItem(Weapon w, int nInStock){
        item=w;
        numberInStock=nInStock;
        left = null;
        right = null;
    }
    
}
