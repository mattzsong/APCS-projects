import java.util.*;

public class PeopleSearchInterface {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int num;
        while (true) {
            try {
                num = retrieveNumPeople(sc);
                break;
            } catch (InvalidOperationException e) {
                System.out.println();
            } catch (InputMismatchException e) {
                System.out.println("Not an integer input.");
                sc.nextLine();
            }
        }
        Person[] people = new Person[num];
        for (int i = 0; i < num; i++) {
            while (true) {
                try {
                    people[i] = new Person(retrieveName(sc), retrieveAge(sc));
                    break;
                } catch (InvalidOperationException e) {
                    System.out.println(e);
                } catch (InputMismatchException e) {
                    System.out.println("Not an integer input.");
                    sc.nextLine();
                }
            }
        }

        PeopleSearch ps = new PeopleSearch(people);

        while (true) {
            System.out.print("Enter b for binary search, s for sequential search, a to print all, or q to quit: ");
            try {
                int[] result;
                String n;
                char searchOp = retrieveOperation(sc, new char[] { 'b', 's', 'a', 'q' });
                if (searchOp == 'b') {
                    n = retrieveName(sc);
                    result = ps.binarySearch(n);
                } else if (searchOp == 's') {
                    n = retrieveName(sc);
                    result = ps.sequentialSearch(n);
                } else if (searchOp == 'a') {
                    System.out.println(ps);
                    continue;
                } else
                    break;

                System.out.println("Searh iterations: " + result[1]);
                if (result[0] >= 0) {
                    System.out.println(ps.getPeople()[result[0]]);
                    System.out.print(
                            "Enter n to change name, a to change age, d to delete person, or q to do nothing: ");
                    char editOp = retrieveOperation(sc, new char[] { 'n', 'a', 'd', 'q' });
                    if (editOp == 'n') {
                        String newName = retrieveName(sc);
                        ps.getPeople()[result[0]].setName(newName);
                    } else if (editOp == 'a') {
                        int a = retrieveAge(sc);
                        ps.getPeople()[result[0]].setAge(a);
                    } else if (editOp == 'd') {
                        ps.deletePerson(result[0]);
                    }
                }
            } catch (InvalidOperationException e) {
                System.out.println(e);
            } catch (InputMismatchException e) {
                System.out.println("Not an integer input.");
                sc.nextLine();
            }
        }
    }

    static String retrieveName(Scanner sc) {
        System.out.print("Enter the name: ");
        return sc.next();
    }

    static int retrieveAge(Scanner sc) throws Exception {
        System.out.print("Enter the age: ");
        int n = sc.nextInt();
        if (n < 1)
            throw new InvalidOperationException("Age has to be positive number.");
        return n;
    }

    static int retrieveNumPeople(Scanner sc) throws Exception {
        System.out.print("Enter the number of people: ");
        int n = sc.nextInt();
        if (n < 1)
            throw new InvalidOperationException("Number of people has to be 1 or more");
        return n;
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
