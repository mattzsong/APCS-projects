import java.util.*;
import java.text.DecimalFormat;

public class AceWidgetInterface {
    public static void main(String[] args) throws Exception {
        Company aceWidget = new Company();
        Scanner sc = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");

        for (int i = 1; i <= 2; i++) {
            aceWidget.addEmployee(retrieveEmployeeInfo(sc, aceWidget));
        }

        while (true) {
            System.out.print(
                    "Enter an operation to perform (a for add employee, i for info of all employees, s for info of specific employee,"
                            + '\n'
                            + "h for highest sales, l for lowest sales, e for highest efficiency, f for lowest efficiency, q for quit): ");
            char op = retrieveOperation(sc, new char[] { 'a', 'i', 's', 'h', 'l', 'e', 'f', 'q' });
            if (op == 'a') {
                if (aceWidget.getEmployeeCount() < 10)
                    aceWidget.addEmployee(retrieveEmployeeInfo(sc, aceWidget));
                else
                    System.out.println("The max employee limit of 10 has been reached.");
            } else if (op == 'i') {
                for (int i = 0; i < aceWidget.getEmployeeCount(); i++) {
                    System.out.println(aceWidget.getEmployees()[i]);
                }
            } else if (op == 's') {
                System.out.print("Enter the exact name of the employee you want to retrieve: ");
                String name;
                Employee e = null;
                while (e == null) {
                    name = sc.next();
                    e = aceWidget.getEmployeeByName(name);
                    if(e == null) System.out.print("Name not recognized. Try again: ");
                }
                System.out.println(e);

            } else if (op == 'h') {
                System.out.println("Highest sales: ");
                for (Employee e : aceWidget.getHighestSales()) {
                    System.out.println(e.getName() + ", $" + df.format(e.getTotal()));
                }
            }

            else if (op == 'l') {
                System.out.println("Lowest sales: ");
                for (Employee e : aceWidget.getLowestSales()) {
                    System.out.println(e.getName() + ", $" + df.format(e.getTotal()));
                }
            }

            else if (op == 'e') {
                System.out.println("Highest efficiency: ");
                for (Employee e : aceWidget.getHighestEfficiency()) {
                    System.out.println(e.getName() + ", " + df.format(e.getEfficiency()));
                }
            }

            else if (op == 'f') {
                System.out.println("Lowest efficiency: ");
                for (Employee e : aceWidget.getLowestEfficiency()) {
                    System.out.println(e.getName() + ", " + df.format(e.getEfficiency()));
                }
            } else
                break;
        }

    }

    static Employee retrieveEmployeeInfo(Scanner sc, Company aw) {
        // obtaining all info of an employee and creating Employee object
        System.out.print("Enter name of employee " + (aw.getEmployeeCount() + 1) + ": ");
        String name = sc.next();
        double[] quarters = new double[4];
        for (int j = 1; j <= 4; j++) {
            System.out.print("Enter quarter " + j + " sales: ");
            quarters[j - 1] = retrieveQuarterSale(sc);
        }
        System.out.print("Enter the amount of time the employee worked in minutes: ");
        int timeWorked = retrieveTimeWorked(sc);
        return new Employee(name, quarters, timeWorked);
    }

    static char retrieveOperation(Scanner sc, char[] validOps) {
        // obtaining and error checking action input
        while (true) {
            char op = sc.next().charAt(0);
            for (int i = 0; i < validOps.length; i++) {
                if (op == validOps[i])
                    return op;
            }
            System.out.print("Invalid input: the input does not correspond to an operation. Try again: ");
        }
    }

    static int retrieveTimeWorked(Scanner sc) {
        // obtaining and error checking time worked
        while (true) {
            String s = sc.next();
            try {
                int timeWorked = Integer.parseInt(s);
                if (timeWorked > 0) {
                    return timeWorked;
                } else
                    System.out.print("Invalid input: time worked is positive. Try again: ");
            } catch (NumberFormatException e) {
                System.out.print("Invalid input: the input was not an integer. Try again: ");
            }
        }
    }

    static double retrieveQuarterSale(Scanner sc) {
        // obtaining and error checking action input
        while (true) {
            String s = sc.next();
            try {
                double quarter = Double.parseDouble(s);
                if (quarter < 0.0)
                    System.out.print("Invalid input: quarter sales can't be negative. Try again: ");
                else
                    return roundDoubleTwoPlaces(quarter);
            } catch (NumberFormatException e) {
                System.out.print("Invalid input: the input cannot be converted to double. Try again: ");
            }
        }
    }

    static double roundDoubleTwoPlaces(double d) {
        int temp = (int) (d * 100 + 0.5);
        d = temp / 100.0;
        return d;
    }
}
