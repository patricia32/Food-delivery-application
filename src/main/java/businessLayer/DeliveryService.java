
    // aici sunt stocate comenzile
    // cheile pt hash sunt fie orderID, fie data, fie ora
    // se foloseste Contract technique: @pre @post @inv si assertions
    // @preconditions - daca nu sunt respactate de client, cererea va fi respinsa
    // @postconditions - daca sunt violate, se descopera o problema din partea frunizorului de servicii
    // @invariant - -//-
    // errors: implementation error or not specific enough preconditions
    package businessLayer;

import Model.Client;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class DeliveryService {
   /* Map<Order, Collection<MenuItem>> orderCollectionMap = new Map<Order, Collection<MenuItem>>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean containsKey(Object key) {
            return false;
        }

        @Override
        public boolean containsValue(Object value) {
            return false;
        }

        @Override
        public Collection<MenuItem> get(Object key) {
            return null;
        }

        @Override
        public Collection<MenuItem> put(Order key, Collection<MenuItem> value) {
            return null;
        }

        @Override
        public Collection<MenuItem> remove(Object key) {
            return null;
        }

        @Override
        public void putAll(Map<? extends Order, ? extends Collection<MenuItem>> m) {

        }

        @Override
        public void clear() {

        }

        @Override
        public Set<Order> keySet() {
            return null;
        }

        @Override
        public Collection<Collection<MenuItem>> values() {
            return null;
        }

        @Override
        public Set<Entry<Order, Collection<MenuItem>>> entrySet() {
            return null;
        }
    }; // informatii despre comenzi
                                                                                                        // cheile sunt roderid, date etc*/

    ArrayList<Order> orders = new ArrayList<>();
    ArrayList<MenuItem> menuItems; // stocheaza toate produsele
    ArrayList<Client> clients;

    public ArrayList<Client> getClients() {
        return clients;
    }
    public void addClient(Client client) {
        this.clients.add(client);
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }
    public void setClients(ArrayList<Client> clients) {
        this.clients = clients;
    }

    public ArrayList<MenuItem> getMenuItems() {
        return menuItems;
    }
    public void setMenuItems(ArrayList<MenuItem> menuItemsAdd){
        this.menuItems = menuItemsAdd;
    }

    public void addOrder(Order order){
        this.orders.add(order);
    }
    public ArrayList<Order> getOrders(){ return orders;}

    /**
     *  @pre o != null
     *  @post !isEmpty()
     *  @post top() == o
     */
    public void wellFormed(){

    }
}
