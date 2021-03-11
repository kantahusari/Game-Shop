package gameshop;

public class Slot {
    public Slot next;
    //Data
    public Weapon item;

    public Slot(Weapon item){
        this.item = item;
        //me
        next=null;
    }
}
