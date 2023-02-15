package businessLayer;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Order {
        private int orderID;
        private String Title;
        private String clientID;
        private LocalDate orderDate;
        private LocalTime orderHour;
        private int price;

        private ArrayList<MenuItem> menuItems;

        public int getPrice() {
                return price;
        }
        public void setPrice(int price) {
                this.price = price;
        }
        public int getOrderID() {
                return orderID;
        }
        public void setOrderID(int orderID) {
                this.orderID = orderID;
        }
        public String getTitle() {
                return Title;
        }
        public void setTitle(String title) {
                Title = title;
        }
        public String getClientID() {
                return clientID;
        }
        public void setClientID(String clientID) {
                this.clientID = clientID;
        }
        public LocalDate getOrderDate() {
                return orderDate;
        }
        public void setOrderDate(LocalDate orderDate) {
                this.orderDate = orderDate;
        }
        public LocalTime getOrderHour() {
                return orderHour;
        }
        public void setOrderHour(LocalTime orderHour) {
                this.orderHour = orderHour;
        }
        public ArrayList<MenuItem> getMenuItems() {
                return menuItems;
        }
        public void setMenuItems(ArrayList<MenuItem> menuItems) {
                this.menuItems = menuItems;
        }

}
