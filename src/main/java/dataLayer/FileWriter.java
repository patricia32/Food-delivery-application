package dataLayer;

import java.io.IOException;

public class FileWriter {
    public void billWriter(String string){
        try {
            java.io.FileWriter myWriter = new java.io.FileWriter("bill.txt");
            myWriter.write(string);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void reportWriter(String string){
        try {
            java.io.FileWriter myWriter = new java.io.FileWriter("report.txt");
            myWriter.write(string);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
