package day5.q4;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ProductApp {
    public static void main(String[] args) {
        PriorityQueue<Product> pq = new PriorityQueue<>(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return Double.compare(o1.getPrice(), o2.getPrice());
            }
        });
        pq.add(new Product(1,"ABC",1000));
        System.out.println(pq);
        pq.add(new Product(3,"def",500));
        System.out.println(pq);
        pq.add(new Product(2,"xyz",100));
        System.out.println(pq);
        pq.add(new Product(4,"mno",750));
        System.out.println(pq);
        pq.add(new Product(5,"tuv",250));
        System.out.println(pq);
        while(!pq.isEmpty()){
            System.out.println(pq.poll());
        }
    }
}
