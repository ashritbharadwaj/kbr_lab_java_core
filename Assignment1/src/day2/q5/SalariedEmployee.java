package day2.q5;

class SalariedEmployee extends Employee {
    private double weeklySalary;

    public SalariedEmployee(String name, String employeeId, double weeklySalary) {
        super(name, employeeId);
        this.weeklySalary = weeklySalary;
    }

    @Override
    public double getWeeklySalary() {
        return weeklySalary;
    }

    @Override
    public void increaseSalary(double percentage) {
        weeklySalary += weeklySalary * (percentage / 100);
    }
}

