package Model;

public class Client {
    private String username;
    private String password;
    private String role = "Client";
    private int ordersNo = 0;

    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getRole() {
        return role;
    }
    public int getOrdersNo() {
        return ordersNo;
    }
    public void setOrdersNo(int ordersNo) {
        this.ordersNo = ordersNo;
    }

    public Client(String username, String password) {
        this.username = username;
        this.password = password;
        this.role = "Client";
    }
}
