package day2.q1;

public class TestEmployee {
    public static void main(String[] args) {
        Employee e1 = new Employee(1, "ash", "bharadwaj", 10000);
        e1.raiseSalary(10);
        System.out.println(e1.toString());

        Employee e2 = new Employee(2, "rash", "bharadwaj", 10000);
        e2.raiseSalary(5);
        System.out.println(e2.toString());
    }
}
