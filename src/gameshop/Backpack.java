
package gameshop;
// This class should implement a backpack as a linked list
    // The backpack can hold any number of weapons as long as maxWeight is not crossed.
    // If an attempt to add a weapon to backpack is rejected due to weight
    class Backpack//linked list
    {
        double maxWeight;
        double presentWeight;
        private Slot head;
        
        public Backpack(){
            maxWeight = 20;
            presentWeight = 0;
            head = null;
        }
        
//add front
        public boolean addFront(Weapon item){
            if(presentWeight + item.weight <= maxWeight){                
                presentWeight += item.weight;        
                Slot slot = new Slot(item);
                if(head == null){
                    head = slot;
                    return true;
                }
                slot.next = head;
                head = slot;
                return true;
            }
            else{
                return false;
            }
        }
//add last
        public boolean addLast(Weapon item){
            if(presentWeight + item.weight <= maxWeight){
                presentWeight += item.weight;
                Slot slot = new Slot(item);
                if(head == null){
                    head = slot;
                    return true;
                }
                Slot current = head;
                while(current.next != null){
                    current = current.next;
                }
                current.next = slot;
                return true;
            }
            else{
                return false;
            }
        }
//remove weapon
        public Weapon removeFront(Weapon item){
            if(head != null){
                Slot current = head;
                head = head.next;
                return current.item;
            }
            return null;
        }
        
        public void printList(){
            Slot current = head;
            while(current != null){
                System.out.println(current.item.weaponName);
                current = current.next;
            }
        }
    }
