import java.util.*;

public class StudentDatabase {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = -1;
        while (n < 0) {
            try {
                n = retrieveAmount(sc);
            } catch (SizeException e) {
                System.out.println(e);
            } catch (InputMismatchException e) {
                System.out.println("A non-integer input was entered.");
            }
        }

        Person[] database = new Person[n];
        for (int i = 0; i < n; i++) {
            try {
                char type = retrieveType(sc);
                sc.nextLine();
                if (type == 'p') {
                    String name = retrieveName(sc);
                    database[i] = new Person(name);
                } else if (type == 's') {
                    String name = retrieveName(sc);
                    database[i] = new Student(name);
                } else if (type == 'u') {
                    String name = retrieveName(sc);
                    char grade = retrieveGrade(sc);
                    database[i] = new Undergraduate(name, grade);
                } else {
                    String name = retrieveName(sc);
                    String major = retrieveMajor(sc);
                    database[i] = new Graduate(name, major);
                }
            } catch (InvalidChoiceException e) {
                System.out.println(e);
            }
        }

        while (true) {
            try {
                char action = retrieveAction(sc);
                if (action == 'p') {
                    for (Person p : database) {
                        if (p instanceof Person && !(p instanceof Student))
                            System.out.println(p);
                    }
                } else if (action == 's') {
                    for (Person p : database) {
                        if (p instanceof Student && !(p instanceof Graduate || p instanceof Undergraduate)) {
                            System.out.println(p);
                        }
                    }
                } else if (action == 'u') {
                    for (Person p : database) {
                        if (p instanceof Undergraduate) {
                            System.out.println(p);
                        }
                    }
                } else if (action == 'g') {
                    for (Person p : database) {
                        if (p instanceof Graduate) {
                            System.out.println(p);
                        }
                    }
                } else if (action == 'l') {
                    char grade = retrieveGrade(sc);
                    for (Person p : database) {
                        if (p instanceof Undergraduate && ((Undergraduate) p).getGrade() == grade) {
                            System.out.println(p);
                        }
                    }
                } else if(action == 'm'){
                    sc.nextLine();
                    String major = retrieveMajor(sc);
                    for (Person p : database) {
                        if (p instanceof Graduate && ((Graduate) p).getMajor().equals(major)) {
                            System.out.println(p);
                        }
                    }
                } else break;
            } catch (InvalidChoiceException e) {
                System.out.print(e);
            }
        }
    }

    static int retrieveAmount(Scanner sc) throws Exception {
        System.out.print("Enter the number of people (max 10): ");
        int n = sc.nextInt();
        if (n <= 0 || n > 10)
            throw new SizeException("Invalid size: has to be positive and a max of 10.");
        return n;
    }

    static char retrieveType(Scanner sc) throws Exception {
        System.out.print("Enter the Person type (p for person, s for student, u for undergrad, and g for grad): ");
        char t = sc.next().charAt(0);
        if (!(t == 'p' || t == 's' || t == 'u' || t == 'g'))
            throw new InvalidChoiceException("Invalid option. ");
        return t;
    }

    static String retrieveName(Scanner sc) {
        System.out.print("Enter the name: ");
        return sc.nextLine();
    }

    static char retrieveGrade(Scanner sc) throws Exception {
        System.out.print("Enter the grade (f for freshman, o for sophomore, j for junior, s for senior): ");
        char g = sc.next().charAt(0);
        if (!(g == 'f' || g == 'o' || g == 'j' || g == 's'))
            throw new InvalidChoiceException("Invalid option. ");
        return g;
    }

    static String retrieveMajor(Scanner sc) {
        System.out.print("Enter the major: ");
        return sc.nextLine();
    }

    static char retrieveAction(Scanner sc) throws Exception {
        System.out.print(
                "Enter p to print persons, s to print students, u to print undergrads, g to print graduates, l to print persons of a grade level, m to print persons of a major, and q to stop: ");
        char a = sc.next().charAt(0);
        if (!(a == 'p' || a == 's' || a == 'u' || a == 'g' || a == 'l' || a == 'm' || a == 'q'))
            throw new InvalidChoiceException("Invalid option. ");
        return a;
    }

    static class SizeException extends Exception {
        public SizeException(String e) {
            super(e);
        }
    }

    static class InvalidChoiceException extends Exception {
        public InvalidChoiceException(String e) {
            super(e);
        }
    }
}