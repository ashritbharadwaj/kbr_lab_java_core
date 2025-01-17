package day2.q5;

class HourlyEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    public HourlyEmployee(String name, String employeeId, double hourlyRate, int hoursWorked) {
        super(name, employeeId);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double getWeeklySalary() {
        return hourlyRate * hoursWorked;
    }

    @Override
    public void increaseSalary(double percentage) {
        hourlyRate += hourlyRate * (percentage / 100);
    }
}