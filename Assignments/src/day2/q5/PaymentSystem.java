package day2.q5;

import java.util.ArrayList;

public class PaymentSystem {
    public static void main(String[] args) {
        ArrayList<Payable> payables = new ArrayList<>();

        payables.add(new SalariedEmployee("Alice", "E001", 1000));
        payables.add(new HourlyEmployee("Bob", "E002", 20, 40));
        payables.add(new CommissionEmployee("Charlie", "E003", 5000, 10));

        payables.add(new Invoice("P001", "Part 1", 10, 15.5));
        payables.add(new Invoice("P002", "Part 2", 5, 25.0));

        for (Payable payable : payables) {
            payable.getPayment();
            System.out.println();
        }
    }
}
