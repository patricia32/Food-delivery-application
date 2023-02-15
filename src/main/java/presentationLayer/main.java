package presentationLayer;

import Model.Admin;
import businessLayer.*;
import businessLayer.MenuItem;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.List;

public class main {
    public static void main(String[] args) throws IOException {

        BaseProduct baseProduct = new BaseProduct();
        baseProduct.readProducts();
        List<BaseProduct> baseProducts = baseProduct.getBaseProductList();
        View view = new View();

        Admin admin = new Admin();
        ArrayList<BaseProduct> toAdd =new ArrayList<>();
        toAdd.add(baseProducts.get(0));
        toAdd.add(baseProducts.get(1));
        CompositeProduct compositeProduct1 = admin.createCompositeProduct(toAdd, "Menu 1");
        CompositeProduct compositeProduct2 = admin.createCompositeProduct(toAdd, "Menu 2");

        ArrayList<CompositeProduct> compositeProducts = new ArrayList<>();
        compositeProducts.add(compositeProduct1);
        compositeProducts.add(compositeProduct2);

        ArrayList<MenuItem> menuItems = new ArrayList<>();
        baseProduct = baseProducts.get(0);
        BaseProduct baseProduct1 = baseProducts.get(1);
        menuItems.add(baseProduct);
        menuItems.add(baseProduct1);
        Order order = new Order();
        order.setOrderHour(LocalTime.parse("12:32:34"));
        order.setOrderDate(LocalDate.parse("2020-12-12"));
        order.setClientID("Miruna");
        order.setOrderID(1);
        order.setMenuItems(menuItems);

        ArrayList<Order> orders = new ArrayList<>();
        orders.add(order);

        ControllerView controller = new ControllerView(view, baseProducts, compositeProducts, orders);


    }
}
