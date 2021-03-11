/*
REVISED
 */
package gameshop;

import java.util.Scanner;

public class GameShop {

        public static int getInteger(Scanner sc,String message){
            System.out.print(message);
            while (!sc.hasNextInt()) 
            {
                sc.nextLine(); //clear the invalid input ...
                System.out.print(message);
            }
            return sc.nextInt();
        }
        
        public static double getDouble(Scanner sc,String message){
            System.out.print(message);
            while (!sc.hasNextDouble()) 
            {
                sc.nextLine(); //clear the invalid input ...
                System.out.print(message);
            }
            return sc.nextDouble();
        }
        
        public static void addWeapons(BinarySearchTree_Weapons h,Scanner sc)
        {
            System.out.println("***********WELCOME TO THE WEAPON ADDING MENU*********");
            String weaponName; 
            int weaponRange; 
            int weaponDamage; 
            double weaponWeight; 
            double weaponCost;
            int quantity;
            System.out.print("Please enter the NAME of the Weapon ('end' to quit): ");
            weaponName=sc.next();
            while (weaponName.compareTo("end") != 0)
            {
                weaponRange= getInteger(sc,"Please enter the Range of the Weapon (0-10): "); 
                weaponDamage=getInteger(sc,"Please enter the Damage of the Weapon: "); 
                weaponWeight= getDouble(sc,"Please enter the Weight of the Weapon (in pounds): ");
                weaponCost=getDouble(sc,"Please enter the Cost of the Weapon: ");
                
                Weapon w = new Weapon(weaponName, weaponRange, weaponDamage, weaponWeight, weaponCost);
                
                quantity=getInteger(sc,"Please enter the quantity in stock: "); 
                
                h.insert(w,quantity);
                System.out.print("Please enter the NAME of another Weapon ('end' to quit): ");
                weaponName = sc.next();
            }
        }
       
        public static void displayWeapons(BinarySearchTree_Weapons ht){
            ht.inorder(ht.root);
        }
        
        public static void deleteWeapons(BinarySearchTree_Weapons h,Scanner sc){
            String key = "";
            while(key.compareTo("end") != 0){
                System.out.println("***********WELCOME TO THE WEAPON DELETING MENU*********");
                displayWeapons(h);
                System.out.print("Please enter the NAME of the Weapon you want to delete ('end' to quit):");
                key = sc.next();
                h.remove(key);
                if(!(h.search(key) instanceof ShopItem))
                {
                    System.out.println("Item deleted!");
                }
                else{
                    System.out.println("Item does not exist!");
                }
            }            
        }

        public static void showRoomMenu(BinarySearchTree_Weapons ht,Player p){
            System.out.println("WELCOME TO THE SHOWROOM!!!!");
            displayWeapons(ht);
            
            System.out.println("You have "+p.money+" money.");
            System.out.println("Please select a weapon to buy('end' to quit): ");
            
            //p.buy(w);
        }
        public static void showRoom(BinarySearchTree_Weapons ht, Player p,Scanner sc)
        {
            String choice;
            showRoomMenu(ht,p);
            choice=sc.next();
            while (choice.compareTo("end") != 0 && !p.inventoryFull())
            {
                ShopItem si = ht.search(choice);
		if (si != null)
                {
                    if (si.item.cost >= p.money)
                    {
                        System.out.println("Insufficient funds to buy "+si.item.weaponName );
                    }
                    else if(si.numberInStock < 1){
                        System.out.println(si.item.weaponName + " is out of stock!");
                    }
                    else{
                        p.buy(si.item);
                        p.withdraw(si.item.cost);
                        si.numberInStock--;
                    }
                }
                else
                {
                    System.out.println(" ** "+choice+" not found!! **" );
                }
                showRoomMenu(ht,p);
                choice = sc.next();
                
            }
            System.out.println("");
        }
        
        public static void menu(BinarySearchTree_Weapons ht, Player pl,Scanner read){           
            int choice = 0;
            while(choice != 6){
                choice = 0;
                System.out.println("1) Add Items to the shop");
                System.out.println("2) Delete Items from the shop");
                System.out.println("3) Buy from the shop");
                System.out.println("4) View backpack");
                System.out.println("5) View Player");
                System.out.println("6) Exit");
           
                System.out.println("Please choose one of the above options!");
                if(read.hasNextInt()){
                    choice = read.nextInt();
                 
                    if(choice == 1){
                        addWeapons(ht, read);
                    }
                    
                    if(choice == 2){
                        deleteWeapons(ht, read);
                    }
                    
                    if(choice == 3){
                        showRoom(ht, pl, read);
                    }
                    
                    if(choice == 4){
                        pl.printBackpack();
                    }
                    
                    if(choice == 5){
                        pl.printCharacter();
                    }
                }
                else{
                    read.next();
                    System.out.println("You did not enter a valid option");
                }
            }
            System.out.println("Good Bye! :(");                        
        }
        
        public static void main(String[] args)
        {
            Scanner read = new Scanner(System.in);
            String pname;
            System.out.println("Please enter Player name:");
            pname=read.next();
            Player pl= new Player(pname,45);
            BinarySearchTree_Weapons ht= new BinarySearchTree_Weapons();
            menu(ht, pl, read);
            pl.printCharacter();
            
        }

}
