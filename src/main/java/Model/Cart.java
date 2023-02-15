package Model;

import businessLayer.MenuItem;

import java.util.ArrayList;

public class Cart {
    private ArrayList<MenuItem> menuItems = new ArrayList<>();
    private int totalPrice = 0;

    public ArrayList<MenuItem> getMenuItems() {
        return menuItems;
    }
    public int getTotalPrice() {
        return totalPrice;
    }
    public void addProduct(MenuItem menuItem){
        this.menuItems.add(menuItem);
        this.totalPrice += menuItem.computePrice();

    }

}
