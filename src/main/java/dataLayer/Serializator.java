package dataLayer;

import Model.Client;
import businessLayer.DeliveryService;
import businessLayer.MenuItem;
import businessLayer.Order;

import java.io.*;
import java.util.ArrayList;

public class Serializator implements Serializable {
    DeliveryService deliveryService = new DeliveryService();

    public Serializator(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    ArrayList<Client> clients = this.deliveryService.getClients();
    ArrayList<Order> orders = this.deliveryService.getOrders();
    ArrayList<MenuItem> menuItems = this.deliveryService.getMenuItems();

   public void Serializare() {
        FileOutputStream fileOut = null;
        try {
            fileOut = new FileOutputStream("DeliveryService.ser");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(fileOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
        deliveryService.setMenuItems(menuItems);
        deliveryService.setClients(clients);
        deliveryService.setOrders(orders);
        try {
            assert out != null;
            out.writeObject(deliveryService);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.printf("Serialized data is saved in DeliveryService.ser");
    }


}
