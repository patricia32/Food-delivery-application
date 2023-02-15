package businessLayer;
import java.io.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class BaseProduct extends MenuItem {
    private String title;
    private int  calories, protein, fat, sodium, price;
    private float rating;
    private int ordersNo = 0;
    ArrayList<BaseProduct> baseProductList = new ArrayList<>();

    public String getTitle() {
        return title;
    }
    public float getRating() {
        return rating;
    }
    public int getCalories() {
        return calories;
    }
    public int getProtein() {
        return protein;
    }
    public int getFat() {
        return fat;
    }
    public int getSodium() {
        return sodium;
    }
    public int getPrice() {
        return price;
    }

    @Override
    public int computePrice() {
        return getPrice();
    }
    public void setProtein(int protein) {
        this.protein = protein;
    }
    public int getOrdersNo() {
        return ordersNo;
    }
    public void setOrdersNo(int ordersNo) {
        this.ordersNo = ordersNo;
    }
    public void increment(){ordersNo++;}

    public ArrayList<BaseProduct> getBaseProductList() {
        return baseProductList;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setRating(float rating) {
        this.rating = rating;
    }
    public void setCalories(int calories) {
        this.calories = calories;
    }
    public void setProteins(int proteins) {
        this.protein = proteins;
    }
    public void setFat(int fat) {
        this.fat = fat;
    }
    public void setSodium(int sodium) {
        this.sodium = sodium;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    public void readProducts()  {
        String line;
        try(BufferedReader br = new BufferedReader(new FileReader("products.csv"))){
            line = br.readLine();
            while((line = br.readLine()) != null){
                BaseProduct baseProduct = new BaseProduct();
                String[] split = line.split(",");
                String title = split[0];
                baseProduct.setTitle(title);
                baseProduct.setRating(Float.parseFloat(split[1]));
                baseProduct.setCalories(Integer.parseInt(split[2]));
                baseProduct.setProteins(Integer.parseInt(split[3]));
                baseProduct.setFat(Integer.parseInt(split[4]));
                baseProduct.setSodium(Integer.parseInt(split[5]));
                baseProduct.setPrice(Integer.parseInt(split[6]));
                baseProductList.add(baseProduct);
                this.baseProductList = (ArrayList<BaseProduct>) this.baseProductList.stream().filter(x -> !(x.getTitle().equals(title))).collect(Collectors.toList());
                this.baseProductList.add(baseProduct);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
