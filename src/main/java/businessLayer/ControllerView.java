package businessLayer;

import Model.Cart;
import Model.Client;
import dataLayer.Serializator;
import presentationLayer.*;
import presentationLayer.menuView;
import presentationLayer.ClientView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import dataLayer.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class ControllerView {
    View controllerView;
    ArrayList<Client> clientsList = new ArrayList<>();
    ArrayList<BaseProduct> baseProducts = new ArrayList<>();
    ArrayList<CompositeProduct> compositeProducts = new ArrayList<>();
    ClientView controllerClientView = new ClientView();
    menuView controllerMenuView = new menuView();
    OrderView controllerOrderView = new OrderView();
    AdminView controllerAdminView = new AdminView();
    EmployeeView controllerEmployeeView = new EmployeeView();
    ProductsManagementView controllerProductsManagementView = new ProductsManagementView();
    ReportsView controllerReportsView = new ReportsView();
    ArrayList<Order> orders = new ArrayList<>();
    DeliveryService deliveryService = new DeliveryService();
    CreateMenuView controllerCreateMenuView = new CreateMenuView();
    int orderNo = 0;
    FileWriter fileWriter = new FileWriter();
    ArrayList<BaseProduct> baseProductArrayList = new ArrayList<>();
    String productsList = "";
    Cart cart = new Cart();
    public ControllerView(View view, List<BaseProduct> baseProducts, List<CompositeProduct> compositeProducts, ArrayList<Order> orders) {
        this.controllerView = view;
        this.orders = orders;
        this.controllerView.setVisible(true);
        this.baseProducts.addAll(baseProducts);
        this.compositeProducts.addAll(compositeProducts);
        this.controllerView.addLoginListener(new loginListener());
        this.controllerView.addRegisterListener(new registerListener());
        this.controllerClientView.addTableListener(new tableClicked());
        this.controllerClientView.addBackListener(new backListenerClient());
        this.controllerMenuView.addTableListener(new tableClickedMenu());
        this.controllerClientView.addSearchListener(new searchListener());
        this.controllerClientView.addMenuListener(new menuListener());
        this.controllerClientView.addAddToCartListener(new addCartProductListener());
        this.controllerClientView.addViewCartListener(new viewCartProductListener());
        this.controllerMenuView.addViewCartListener(new  viewCartMenuListener());
        this.controllerMenuView.addAddToCartListener(new addCartMenuListener());
        this.controllerMenuView.addBackListeer(new backListenerViewMenus());
        this.controllerOrderView.addBackListener(new backListenerOrder());
        this.controllerOrderView.addOrderListener(new placeOrderListener());
        this.controllerAdminView.addManageListener(new manageListener());
        this.controllerAdminView.addBackListeer(new backListenerAdmin());
        this.controllerProductsManagementView.addTableListener(new tableClickedManage());
        this.controllerProductsManagementView.addBackListener(new backListenerProducts());
        this.controllerProductsManagementView.addAddListener(new addNewListener());
        this.controllerProductsManagementView.addEditListener(new editListener());
        this.controllerProductsManagementView.addDeleteListener(new deleteListener());
        this.controllerAdminView.addGenerateReportsListener(new generateReportsListener());
        this.controllerAdminView.addCreateListener(new createMenuListener());
        this.controllerCreateMenuView.addTableListener(new tableClickedCreate());
        this.controllerCreateMenuView.addBackListener(new backListenerCreate());
        this.controllerCreateMenuView.addAddToMenuListener(new addToMenu());
        this.controllerCreateMenuView.addCreateMenuListener(new createMenu());
        this.controllerReportsView.addBackListener(new backListenerGenerate());
        this.controllerReportsView.addGenerateListener(new generateListener());
    }
    public class loginListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String user = controllerView.getUser();
            String password = controllerView.getPassword();
            if (controllerView.getRole().equals("Client")) {
                for (Client client : clientsList)
                    if (client.getUsername().equals(user) && client.getPassword().equals(password)) {
                        controllerView.setVisible(false);
                        controllerClientView.table(baseProducts);
                        controllerClientView.setVisible(true);
                       // deliveryService.addClient(client);
                        break;
                    }
            }
            else if (controllerView.getRole().equals("Admin") && user.equals("a") && password.equals("a")) {
                controllerView.setVisible(false);
                controllerAdminView.setVisible(true);
            }
            else if (controllerView.getRole().equals("Employee") && user.equals("e") && password.equals("e")) {
                controllerView.setVisible(false);
                controllerEmployeeView.setVisible(true);
            }
        }
    }
    public class registerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (controllerView.getUser().equals("")) {
                controllerView.showError("Introduce an username.");
                return;
            }
            if (controllerView.getPassword().equals("")) {
                controllerView.showError("Introduce a password.");
                return;
            }
            if (!(controllerView.getRole().equals("Client"))) {
                controllerView.showError("You can't login as an admin or an employee.");
                return;
            }
            Client client = new Client(controllerView.getUser(), controllerView.getPassword() );
            clientsList.add(client);
            controllerView.setVisible(false);
            controllerView.setVisible(true);
            controllerView.showError("Your account has been registered. You can now login.");
        }
    }
    public class tableClicked implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            String productName = controllerClientView.jTable1MouseClicked();
            controllerClientView.setProductNameField(productName);
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }
        @Override
        public void mouseReleased(MouseEvent e) {

        }
        @Override
        public void mouseEntered(MouseEvent e) {

        }
        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
    public class tableClickedMenu implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            String productName = controllerMenuView.jTable1MouseClickedMenu();
            String price = "";
            for(CompositeProduct compositeProduct: compositeProducts)
                if(compositeProduct.getTitle().equals(productName))
                    price = String.valueOf(compositeProduct.computePrice());
            controllerMenuView.setProductPriceField(price);
            controllerMenuView.setProductNameField(productName);
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }
        @Override
        public void mouseReleased(MouseEvent e) {

        }
        @Override
        public void mouseEntered(MouseEvent e) {

        }
        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
    public class backListenerClient implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            controllerClientView.setVisible(false);
            controllerView.setVisible(true);
        }
    }

    public class searchListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String searchMode = controllerClientView.getSearchingMode();
            String valueIntroduced = controllerClientView.getSearchField();
            if(!(searchMode.equals("All products"))) {
                if ((searchMode.equals("title")) && valueIntroduced.equals("")) {
                    controllerView.showError("You need to introduce a title.");
                    return;
                }
                else if(!(searchMode.equals("title")) && valueIntroduced.equals("")){
                    controllerView.showError("You need to introduce a number.");
                    return;
                }
            }
            List<BaseProduct> baseProductsFinal = null;
            controllerClientView.setVisible(false);
            controllerClientView.setProductNameField("");
            controllerClientView.setSearchField("");
            if(searchMode.equals("All products"))
                controllerClientView.table(baseProducts);
            else if (searchMode.equals("title"))
                    baseProductsFinal = baseProducts.stream().filter(x -> x.getTitle().equals(valueIntroduced)).collect(Collectors.toList());
                else if (searchMode.equals("rating"))
                    baseProductsFinal = baseProducts.stream().filter(x -> x.getRating() == Integer.parseInt(valueIntroduced)).collect(Collectors.toList());
                else if (searchMode.equals("calories"))
                    baseProductsFinal = baseProducts.stream().filter(x -> x.getCalories() == Integer.parseInt(valueIntroduced)).collect(Collectors.toList());
                else if (searchMode.equals("protein"))
                    baseProductsFinal = baseProducts.stream().filter(x -> x.getProtein() == Integer.parseInt(valueIntroduced)).collect(Collectors.toList());
                else if (searchMode.equals("fat"))
                    baseProductsFinal = baseProducts.stream().filter(x -> x.getFat() == Integer.parseInt(valueIntroduced)).collect(Collectors.toList());
                else if (searchMode.equals("sodium"))
                    baseProductsFinal = baseProducts.stream().filter(x -> x.getSodium() == Integer.parseInt(valueIntroduced)).collect(Collectors.toList());
                else if (searchMode.equals("price"))
                    baseProductsFinal = baseProducts.stream().filter(x -> x.getPrice() == Integer.parseInt(valueIntroduced)).collect(Collectors.toList());
                controllerClientView.table((ArrayList<BaseProduct>) baseProductsFinal);

            controllerClientView.setVisible(true);
        }
    }
    public class menuListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            controllerClientView.setVisible(false);
            controllerMenuView.table(compositeProducts);
            controllerMenuView.setVisible(true);
        }
    }
    public class addCartProductListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String title = controllerClientView.getProductNameField();
            for(BaseProduct baseProduct: baseProducts)
                if(baseProduct.getTitle().equals(title)) {
                    controllerView.showError("Your product has been added to your cart.");
                    cart.addProduct(baseProduct);
                }
            System.out.println(cart.getTotalPrice());
        }
    }
    public class addCartMenuListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String title = controllerMenuView.getProductTitleField();
            for(CompositeProduct compositeProduct: compositeProducts)
                if(compositeProduct.getTitle().equals(title)) {
                    cart.addProduct(compositeProduct);
                    controllerView.showError("Your product has been added to your cart.");
                }
        }
    }
    public class viewCartProductListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            controllerClientView.setVisible(false);
            controllerOrderView.setVisible(true);
            String string = "";
            int price = 0;
            BaseProduct baseProduct = new BaseProduct();
            CompositeProduct compositeProduct = new CompositeProduct();
            for (MenuItem menuItem : cart.getMenuItems()) {
                if (menuItem.getClass().getSimpleName().equals("BaseProduct")) {
                    baseProduct = (BaseProduct) menuItem;
                    price = cart.getTotalPrice();
                    string = string.concat(baseProduct.getTitle());
                    string = string.concat(" - Price " + String.valueOf(menuItem.computePrice()));
                    string = string.concat("\n");
                }
                else{
                    compositeProduct = (CompositeProduct) menuItem;
                    price = cart.getTotalPrice();
                    string = string.concat(compositeProduct.getTitle());
                    string = string.concat(" - Price " + String.valueOf(menuItem.computePrice()));
                    string = string.concat("\n");
                }
                controllerOrderView.setCartText(string);
                controllerOrderView.setPrice(String.valueOf(price));
            }
        }
    }
    public class viewCartMenuListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            controllerMenuView.setVisible(false);
            controllerOrderView.setVisible(true);
            String string = "";
            int price = 0;
            BaseProduct baseProduct = new BaseProduct();
            CompositeProduct compositeProduct = new CompositeProduct();
            for (MenuItem menuItem : cart.getMenuItems()) {
                System.out.println(menuItem.getClass().getSimpleName());
                if (menuItem.getClass().getSimpleName().equals("CompositeProduct")) {
                    compositeProduct = (CompositeProduct) menuItem;
                    price = cart.getTotalPrice();
                    string = string.concat(compositeProduct.getTitle());
                    string = string.concat(" - Price " + String.valueOf(menuItem.computePrice()));
                    string = string.concat("\n");
                }
                else{
                    baseProduct = (BaseProduct) menuItem;
                    price = cart.getTotalPrice();
                    string = string.concat(baseProduct.getTitle());
                    string = string.concat(" - Price " + String.valueOf(menuItem.computePrice()));
                    string = string.concat("\n");
                }
                controllerOrderView.setPrice(String.valueOf(price));
                controllerOrderView.setCartText(string);
            }
        }
     }
     public class  backListenerOrder implements ActionListener{
         @Override
         public void actionPerformed(ActionEvent e) {
             controllerOrderView.setVisible(false);
             controllerClientView.setVisible(true);
         }
     }
     public  class placeOrderListener implements ActionListener{
         @Override
         public void actionPerformed(ActionEvent ev) {
             ArrayList<MenuItem> menuItems = new ArrayList<>();
             menuItems.addAll(baseProducts);
             menuItems.addAll(compositeProducts);
             deliveryService.setMenuItems(menuItems);
             Order order = new Order();
             order.setOrderID(orderNo);
             orderNo++;
             order.setOrderDate(java.time.LocalDate.now());
             order.setOrderHour(java.time.LocalTime.now());
             order.setClientID(clientsList.get(0).getUsername());
             order.setPrice(cart.getTotalPrice());
             order.setMenuItems(cart.getMenuItems());
             deliveryService.addOrder(order);

             orders.add(order);
             clientsList.get(0).setOrdersNo(clientsList.get(0).getOrdersNo() + 1);
             for(MenuItem menuItem: cart.getMenuItems())
                 menuItem.increment();

             String string = "";
             string = string.concat(clientsList.get(0).getUsername() + " ordered ");
             string = string.concat("\n");
             string = string.concat(order.getOrderDate() + " " + order.getOrderHour() + " price " + order.getPrice());

             fileWriter.billWriter(string);

             controllerOrderView.setVisible(false);
             controllerClientView.setVisible(true);
             Serializator serializator = new Serializator(deliveryService);
             serializator.Serializare();
         }
     }
     public class backListenerViewMenus implements ActionListener{
         @Override
         public void actionPerformed(ActionEvent e) {
             controllerMenuView.setVisible(false);
             controllerClientView.setVisible(true);
         }
     }

     public class manageListener implements ActionListener{
         @Override
         public void actionPerformed(ActionEvent e) {
             controllerAdminView.setVisible(false);
             controllerProductsManagementView.table(baseProducts);
             controllerProductsManagementView.setVisible(true);
         }
     }
    public class tableClickedManage implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            controllerProductsManagementView.jTable1MouseClicked();
          //  controllerClientView.setProductNameField(productName);
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }
        @Override
        public void mouseReleased(MouseEvent e) {

        }
        @Override
        public void mouseEntered(MouseEvent e) {

        }
        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
    public class backListenerAdmin implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            controllerAdminView.setVisible(false);
            controllerView.setVisible(true);
        }
    }
    public class backListenerProducts implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            controllerProductsManagementView.setVisible(false);
            controllerAdminView.setVisible(true);
        }
    }
    public class addNewListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            BaseProduct baseProduct = controllerProductsManagementView.getProduct();
            baseProducts.add(baseProduct);
            controllerView.showError("The product has been added.");
            controllerProductsManagementView.setVisible(false);
            controllerAdminView.setVisible(true);
        }
    }
    public class editListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            BaseProduct baseProduct = controllerProductsManagementView.getProduct();
            ArrayList<BaseProduct> copy = baseProducts;
            for(BaseProduct baseProduct1: copy)
                if(baseProduct1.getTitle().equals(baseProduct.getTitle())) {
                    baseProducts.remove(baseProduct1);
                    baseProducts.add(baseProduct);
                    break;
                }
            controllerView.showError("The product has been edited.");
            controllerProductsManagementView.setVisible(false);
            controllerAdminView.setVisible(true);
        }
    }
    public class deleteListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            BaseProduct baseProduct = controllerProductsManagementView.getProduct();
            ArrayList<BaseProduct> copy = baseProducts;
            for(BaseProduct baseProduct1: copy)
                if(baseProduct1.getTitle().equals(baseProduct.getTitle())) {
                    baseProducts.remove(baseProduct1);
                    break;
                }
            controllerProductsManagementView.setVisible(false);
            controllerAdminView.setVisible(true);
            controllerView.showError("The product has been deleted.");
        }
    }

    public class createMenuListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            controllerAdminView.setVisible(false);
            controllerCreateMenuView.table(baseProducts);
            controllerCreateMenuView.setVisible(true);
        }
    }
    public class tableClickedCreate implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            controllerCreateMenuView.jTable1MouseClicked();
            //  controllerClientView.setProductNameField(productName);
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }
        @Override
        public void mouseReleased(MouseEvent e) {

        }
        @Override
        public void mouseEntered(MouseEvent e) {

        }
        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
    public class backListenerCreate implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<BaseProduct> copy = baseProductArrayList;
            for (BaseProduct baseProduct: copy)
                baseProductArrayList.remove(baseProduct);
            controllerCreateMenuView.setListField("");
            controllerCreateMenuView.setVisible(false);
            controllerAdminView.setVisible(true);
        }
    }
    public class addToMenu implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            BaseProduct baseProduct = controllerCreateMenuView.getProduct();
            productsList = productsList.concat(baseProduct.getTitle());
            productsList = productsList.concat("\n");
            controllerCreateMenuView.setListField(productsList);
            baseProductArrayList.add(baseProduct);
        }
    }
    public class createMenu implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String title = controllerCreateMenuView.getMenuTitle();
            if(title.equals("")){
                controllerView.showError("Introduce a menu title.");
                return;
            }
            CompositeProduct compositeProduct = new CompositeProduct();
            compositeProduct.setMenuTitle(title);
            System.out.println(compositeProduct.getTitle());
            if(baseProductArrayList.isEmpty()){
                controllerView.showError("Select products.");
                return;
            }
            compositeProduct.setProductsList(baseProductArrayList);
            ArrayList<BaseProduct> copy = baseProductArrayList;
            for (BaseProduct baseProduct: copy)
                baseProductArrayList.remove(baseProduct);
            controllerCreateMenuView.setListField("");
            compositeProducts.add(compositeProduct);
            controllerView.showError("Your composite product has been created.");
            controllerCreateMenuView.setVisible(false);
            controllerAdminView.setVisible(true);
        }
    }

    public class generateReportsListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            DeliveryService deliveryService = new DeliveryService();
            ArrayList<MenuItem> menuItems = new ArrayList<>();
            menuItems.addAll(baseProducts);
            menuItems.addAll(compositeProducts);
            deliveryService.setMenuItems(menuItems);
            controllerAdminView.setVisible(false);
            controllerReportsView.setVisible(true);
        }
    }
    public class backListenerGenerate implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            controllerReportsView.setVisible(false);
            controllerAdminView.setVisible(true);
        }
    }
    public class generateListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String reportType = controllerReportsView.getReportType();
            String info = controllerReportsView.getInfo1();
            String info2 = controllerReportsView.getInfo2();
            if(info.equals("")) {
                controllerView.showError("Introduce data!");
                return;
            }

            ArrayList<Order> ordersFinal = new ArrayList<>();
            ArrayList<BaseProduct> baseProductsFinal = new ArrayList<>();
            ArrayList<Client> clientsFinal = new ArrayList<>();
            ArrayList<Integer> values = new ArrayList<>();
            String string = "";

            if(reportType.equals("Time interval")) {
                if(info2.equals("")) {
                    controllerView.showError("Introduce data!");
                    return;
                }
                LocalTime timeLow = LocalTime.parse(info);
                LocalTime timeHigh = LocalTime.parse(info2);
                ordersFinal = (ArrayList<Order>) orders.stream().filter(x -> (x.getOrderHour().isAfter(timeLow) && x.getOrderHour().isBefore(timeHigh))).collect(Collectors.toList());
                for(Order order: ordersFinal){
                    string = string.concat(order.getClientID() + " data "+order.getOrderDate() + " time "+ order.getOrderHour() + " price " + order.getPrice() + " \n products: ");
                    for (MenuItem menuItem: order.getMenuItems())
                        string = string.concat(menuItem.getTitle() + "\n   ");
                    string = string.concat("\n");
                }
                fileWriter.reportWriter(string);
            }
           else if(reportType.equals("Products ordered")){
               int ordersNo = Integer.parseInt(info);
               baseProductsFinal = (ArrayList<BaseProduct>) baseProducts.stream().filter(x -> x.getOrdersNo() > ordersNo).collect(Collectors.toList());
               for (BaseProduct baseProduct: baseProductsFinal) {
                   System.out.println(baseProduct.getTitle());
                   string = string.concat(baseProduct.getTitle() + "\n");
               }
                fileWriter.reportWriter(string);
           }
           else if(reportType.equals("Clients orders")){
                if(info2.equals("")) {
                    controllerView.showError("Introduce data!");
                    return;
                }
               int ordersNo = Integer.parseInt(info);
                int price = Integer.parseInt(info2);
               clientsFinal = (ArrayList<Client>) clientsList.stream().filter(x -> x.getOrdersNo() > ordersNo).collect(Collectors.toList());
               ordersFinal = (ArrayList<Order>) orders.stream().filter(x->x.getPrice() > price).collect(Collectors.toList());
                for (Client client: clientsFinal) {
                    System.out.println(client.getUsername());
                    string = string.concat(client.getUsername() + "\n");
                }
            }
            else if(reportType.equals("Products per day")){
                LocalDate date = LocalDate.parse(info);
                ordersFinal = (ArrayList<Order>) orders.stream().filter(x -> x.getOrderDate().equals(date)).collect(Collectors.toList());
                for(Order order: ordersFinal)
                    for (MenuItem menuItem: order.getMenuItems())
                        string = string.concat(menuItem.getTitle() + " ordersNo = "+ menuItem.getOrdersNo() + "\n    ");
            }
            fileWriter.reportWriter(string);
        }
    }
}


