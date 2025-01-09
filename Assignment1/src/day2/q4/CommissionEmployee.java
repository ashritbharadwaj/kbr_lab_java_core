package day2.q4;

class CommissionEmployee extends Employee {
    private double sales;
    private double commissionRate;

    public CommissionEmployee(String name, String employeeId, double sales, double commissionRate) {
        super(name, employeeId);
        this.sales = sales;
        this.commissionRate = commissionRate;
    }

    @Override
    public double getWeeklySalary() {
        return sales * (commissionRate / 100);
    }

    @Override
    public void increaseSalary(double percentage) {
        commissionRate += commissionRate * (percentage / 100);
    }
}
