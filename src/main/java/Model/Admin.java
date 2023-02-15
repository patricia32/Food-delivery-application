package Model;

import businessLayer.BaseProduct;
import businessLayer.CompositeProduct;

import java.util.ArrayList;
import java.util.List;

public class Admin {
    private String username;
    private String password;

    public CompositeProduct createCompositeProduct(ArrayList<BaseProduct> baseProductsList, String menuName){
        CompositeProduct compositeProduct = new CompositeProduct();
        compositeProduct.setMenuTitle(menuName);
        compositeProduct.setProductsList(baseProductsList);
        int price = compositeProduct.computePrice();
        compositeProduct.setPrice(price);

        return compositeProduct;
    }
}
