
package gameshop;

public class BinarySearchTree_Weapons {
    ShopItem root;
    public BinarySearchTree_Weapons()
    {
        root=null;
    }

    public void insert(Weapon w, int quantity)
    {
    ShopItem si = new ShopItem(w, quantity);
    if(root==null)
    {
        root=si;
        return;
    }
    ShopItem curr,parent;
        curr=parent=root;
        while(curr!=null)
        {
            if(w.weaponName.compareTo(curr.item.weaponName)<0)
                //n < curr
            {
                parent=curr;
                curr=curr.left;
            }
            if(w.weaponName.compareTo(curr.item.weaponName)>0)
                //n> curr
            {
                parent=curr;
                curr=curr.right;
            }
        }
        if(w.weaponName.compareTo(parent.item.weaponName)<0)
        {
            parent.left=si;
        }else
        {
            parent.right=si;
        }
        return;
    
    }
    
    public ShopItem search(String s)
    {
    return searchHelp(root, s);
    }
    public ShopItem searchHelp(ShopItem root, String n)
    {
    if (root==null || root.item.weaponName.compareTo(n)==0) 
        return root; 
    if (root.item.weaponName.compareTo(n) >0) 
        return searchHelp(root.left,n); 
    return searchHelp(root.right,n);
    }
    
    public ShopItem update(String oldVal,Weapon w, int quantity)  
{  
    remove(oldVal);
    insert(w, quantity);  
    return root;  
}  
    public void inorder(ShopItem root)  
{  
    if (root != null)  
    {  
        inorder(root.left);  
        System.out.print("Weapon Name: "+root.item.weaponName + " \t"
                        +"Range: "+root.item.range+" \t"
                        +"Damage: "+root.item.damage+" \t"
                        +"Weight: "+root.item.weight+" \t"
                        +"Cost: "+root.item.cost+" \n");
        inorder(root.right);
    }  
} 

    public void remove(String s)
    {
    root=delete(root,s);
    }
    public ShopItem delete(ShopItem root, String n) 
    { 
        if (root == null)  return root; 
        if (n.compareTo(root.item.weaponName) <0) 
            root.left = delete(root.left,n); 
        else if (n.compareTo(root.item.weaponName) >0) 
            root.right = delete(root.right,n); 
        else
        { 
            if (root.left == null) 
                return root.right; 
            else if (root.right == null) 
                return root.left; 
            root.item.weaponName = minValue(root.right);
            root.right = delete(root.right, root.item.weaponName); 
        } 
          return root; 
    } 
    public String minValue(ShopItem root) 
    { 
        String minv = root.item.weaponName; 
        while (root.left != null) 
        { 
            minv = root.left.item.weaponName; 
            root = root.left; 
        } 
        return minv; 
    }
  
}
