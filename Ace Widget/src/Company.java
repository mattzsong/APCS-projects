import java.util.*;

public class Company {
    private Employee[] employees;
    private int employeeCount;
    private Employee[] highestSales;
    private Employee[] lowestSales;
    private Employee[] highestEfficiency;
    private Employee[] lowestEfficiency;

    public Company() {
        this.employees = new Employee[10];
        this.employeeCount = 0;
    }

    public Employee[] getEmployees() {
        return this.employees;
    }

    public int getEmployeeCount() {
        return this.employeeCount;
    }

    public Employee[] getHighestSales() {
        return this.highestSales;
    }

    public Employee[] getLowestSales() {
        return this.lowestSales;
    }

    public Employee[] getHighestEfficiency() {
        return this.highestEfficiency;
    }

    public Employee[] getLowestEfficiency() {
        return this.lowestEfficiency;
    }

    public Employee getEmployeeByName(String name) {
        for (int i = 0; i < employeeCount; i++) {
            if (employees[i].getName().equals(name))
                return employees[i];
        }
        return null;
    }

    public void addEmployee(Employee e) {
        employees[employeeCount] = e;
        employeeCount++;
        // set first employee as everything
        if (employeeCount == 1) {
            this.highestSales = new Employee[] { e };
            this.lowestSales = new Employee[] { e };
            this.highestEfficiency = new Employee[] { e };
            this.lowestEfficiency = new Employee[] { e };

            // compare new employee stats to current extremes and update
        } else {
            if (e.getTotal() > highestSales[0].getTotal())
                highestSales = new Employee[] { e };
            else if (e.getTotal() == highestSales[0].getTotal())
                highestSales = addEmployeeToArray(highestSales, e);

            if (e.getTotal() < lowestSales[0].getTotal())
                lowestSales = new Employee[] { e };
            else if (e.getTotal() == lowestSales[0].getTotal())
                lowestSales = addEmployeeToArray(lowestSales, e);

            if (e.getEfficiency() > highestEfficiency[0].getEfficiency())
                highestEfficiency = new Employee[] { e };
            else if (e.getEfficiency() == highestEfficiency[0].getEfficiency())
                highestEfficiency = addEmployeeToArray(highestEfficiency, e);

            if (e.getEfficiency() < lowestEfficiency[0].getEfficiency())
                lowestEfficiency = new Employee[] { e };
            else if (e.getEfficiency() == lowestEfficiency[0].getEfficiency())
                lowestEfficiency = addEmployeeToArray(lowestEfficiency, e);
        }

    }

    private Employee[] addEmployeeToArray(Employee[] a, Employee e) {
        Employee[] newA = Arrays.copyOf(a, a.length + 1);
        newA[newA.length - 1] = e;
        return newA;
    }
}
