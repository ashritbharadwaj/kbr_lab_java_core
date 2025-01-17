package day2.q5;

abstract class Employee implements Payable {
    protected String name;
    protected String employeeId;

    public Employee(String name, String employeeId) {
        this.name = name;
        this.employeeId = employeeId;
    }

    public abstract double getWeeklySalary();

    @Override
    public void getPayment() {
        System.out.println("Employee:");
        System.out.println("Name: " + name);
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Weekly Salary: " + getWeeklySalary());
    }

    public abstract void increaseSalary(double percentage);
}
