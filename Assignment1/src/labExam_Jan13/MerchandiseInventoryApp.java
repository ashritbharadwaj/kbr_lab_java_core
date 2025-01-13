package labExam_Jan13;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MerchandiseInventoryApp {
    String path;
    ArrayList<MerchandiseInventory> inventories = new ArrayList<>();

    public MerchandiseInventoryApp(String path) {
        this.path = path;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("C:\\Users\\ashrit.bharadwaj\\Desktop\\ASHRIT\\JavaTraining\\kbr_lab_java_core\\Assignment1\\src\\labExam_Jan13\\input.txt")))){
            String line;
            while((line = bufferedReader.readLine()) != null){
                String[] tokens = line.split(" ");
                MerchandiseInventory inventory = new MerchandiseInventory(tokens[0], Integer.parseInt(tokens[1]), Double.parseDouble(tokens[2]));
                boolean add = inventories.add(inventory);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void sortByNameAscending() {
        Collections.sort(inventories);
        System.out.println("Sort By Names in Ascending Order:");
        for(MerchandiseInventory inventory : inventories){
            System.out.println(inventory.toString());
        }
        System.out.println("---------------------------");
    }

    public void sortByPriceDescending() {
        inventories.sort(new Comparator<MerchandiseInventory>() {
            @Override
            public int compare(MerchandiseInventory o1, MerchandiseInventory o2) {
                return Double.compare(o2.getPrice(), o1.getPrice());
            }
        });
        System.out.println("Sort By Price in Descending Order:");
        for(MerchandiseInventory inventory : inventories){
            System.out.println(inventory.toString());
        }
    }

}
