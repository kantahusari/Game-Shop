/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameshop;

 

class Player
    {
        public String name;
        public Backpack backpack;
        public int numItems;
        public double money;
        BinarySearchTree_Weapons weapons;
        
        public Player(String n, double m)
        {
            name = n;
            money = m;
            numItems = 0;
            backpack = new Backpack();
        }

        public void buy(Weapon w)
        {
            System.out.println(w.weaponName+" bought...");
            backpack.addLast(w);
            numItems++;
            System.out.println(numItems);
        }
        public void withdraw(double amt)
        {
            money = money - amt;
        }
        public boolean inventoryFull()
        {
            return (numItems == 10) ;
        }
        public void printCharacter()
        {
            System.out.println(" Name:"+name+"\n Money:"+money);
            printBackpack();
        }
        public void printBackpack()
        {
            System.out.println(" "+name+", you own "+numItems+" Weapons:");
            backpack.printList();
            System.out.println();
        }
    }