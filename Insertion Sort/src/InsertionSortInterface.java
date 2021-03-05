import java.util.*;

public class InsertionSortInterface {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        StatsCalculator c;
        while (true) {
            try {
                c = new StatsCalculator(retrieveNumbers(sc));
                break;
            } catch (NumberFormatException e) {
                System.out.println("Non-integer input entered. Try again.");
            }
        }
        while (true) {
            System.out.println(
                "Enter a for adding new numbers, m for mean, e for median, o for modes, r for reset, p for print, q for quit");
            try {
                char op = retrieveOperation(sc, new char[] { 'a', 'm', 'e', 'o', 'r', 'p', 'q' });
                if (op == 'a') {
                    sc.nextLine();
                    ArrayList<Integer> newList = retrieveNumbers(sc);
                    newList.addAll(c.getNumbers());
                    c.setNumbers(newList);
                } else if (op == 'm')
                    System.out.println(c.findMean());
                else if (op == 'e')
                    System.out.println(c.findMedian());
                else if (op == 'o'){
                    ArrayList<Integer> modes = c.findModes();
                    if(!(modes == null)) System.out.println(modes);
                    else               System.out.println("NONE");
                }
                else if (op == 's')
                    System.out.println(c.findStandardDeviation());
                else if (op == 'r')
                    c.setNumbers(new ArrayList<Integer>());
                else if (op == 'p')
                    System.out.println(c.getNumbers());
                else
                    break;
            } catch (InvalidOperationException e) {
                System.out.println(e);
            } catch (EmptyListException e) {
                System.out.println(e);
            } catch (NumberFormatException e) {
                System.out.println("Non-integer input entered. Try again.");
            }
        }

    }

    static ArrayList<Integer> retrieveNumbers(Scanner sc) throws Exception {
        System.out.println("Enter the numbers (up to 25), with a space separating each number followed by an 'e' at the end. Ex. 1 2 3");
        ArrayList<Integer> numbers = new ArrayList<>();
        String sequence = sc.nextLine();
        for(String s : sequence.split(" +")) {
            numbers.add(Integer.parseInt(s));
            if (numbers.size() >= 25) {
                System.out.println("Maximum number of 25 numbers reached.");
                break;
            }
        }

        return numbers;
    }

    static char retrieveOperation(Scanner sc, char[] valid) throws Exception {
        char op = sc.next().charAt(0);
        for (int i = 0; i < valid.length; i++) {
            if (op == valid[i])
                return op;
        }
        throw new InvalidOperationException("Invalid input: Not a valid operation.");
    }

    public static class InvalidOperationException extends Exception {
        private static final long serialVersionUID = 1L;

        public InvalidOperationException(String string) {
            super(string);
        }
    }
}
