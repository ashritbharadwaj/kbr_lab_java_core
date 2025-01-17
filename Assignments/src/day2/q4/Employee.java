package day2.q4;

abstract class Employee {
    protected String name;
    protected String employeeId;

    public Employee(String name, String employeeId) {
        this.name = name;
        this.employeeId = employeeId;
    }

    public abstract double getWeeklySalary();

    public abstract void increaseSalary(double percentage);
}
