package businessLayer;

import java.util.*;

public class CompositeProduct extends MenuItem{
    private String menuTitle;
    private ArrayList<BaseProduct> ProductsList = new ArrayList<BaseProduct>();
    private ArrayList<CompositeProduct> compositeProductsList = new ArrayList<CompositeProduct>();
    private int price;
    private int ordersNo = 0;

    public void setMenuTitle(String menuTitle) {
        this.menuTitle = menuTitle;
    }
    public void setProductsList(ArrayList<BaseProduct> productsList) {
        this.ProductsList = productsList;
    }
    public void addBaseProduct(BaseProduct baseProduct){ this.ProductsList.add(baseProduct);}
    public void setCompositeProductsList(ArrayList<CompositeProduct> compositeProductsList) {
        this.compositeProductsList = compositeProductsList;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    public String getTitle() {
        return menuTitle;
    }
    public ArrayList<BaseProduct> getProductsList() {
        return ProductsList;
    }
    public ArrayList<CompositeProduct> getCompositeProductsList() {
        return compositeProductsList;
    }
    public int getPrice() {
        return price;
    }

    @Override
    public int computePrice() {
        int price = 0;
        for(BaseProduct baseProduct: this.ProductsList)
            price += baseProduct.getPrice();
        return price;
    }
    public void increment(){ordersNo++;}
    public int getOrdersNo(){ return ordersNo;}
}
