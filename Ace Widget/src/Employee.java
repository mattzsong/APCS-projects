import java.text.DecimalFormat;

public class Employee {
    private String name;
    private double[] quarters;
    private int timeWorked;
    private double total;
    private double efficiency;

    public Employee(String name, double[] qs, int timeWorked) {
        this.name = name;
        this.quarters = qs;
        this.timeWorked = timeWorked;
        this.total = qs[0] + qs[1] + qs[2] + qs[3];
        this.efficiency = total / timeWorked;
    }

    public String getName() {
        return this.name;
    }

    public double[] getQuarters() {
        return this.quarters;
    }

    public int getTimeWorked() {
        return this.timeWorked;
    }

    public double getTotal() {
        return this.total;
    }

    public double getEfficiency() {
        return this.efficiency;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTimeWorked(int timeWorked) {
        this.efficiency *= this.timeWorked;
        this.timeWorked = timeWorked;
        this.efficiency /= this.timeWorked;
    }

    public void setQuarter(double saleAmount, int quarterIndex) {
        this.total -= quarters[quarterIndex - 1];
        quarters[quarterIndex - 1] = saleAmount;
        this.total += quarters[quarterIndex - 1];
        this.efficiency = this.total / this.timeWorked;
    }

    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        String employeeInfo = "Name: " + name + "; ";
        for (int i = 1; i <= quarters.length; i++) {
            employeeInfo += "Q" + i + ": $" + df.format(quarters[i - 1]) + "; ";
        }
        employeeInfo += "Total Sales: $" + df.format(total) + "; ";
        employeeInfo += "Time Worked: " + timeWorked + " minutes; ";
        employeeInfo += "Efficiency: " + df.format(efficiency);
        return employeeInfo;
    }

}
