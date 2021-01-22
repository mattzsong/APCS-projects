import java.util.*;

public class LibraryInterface {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();
        char yesNo = 'n';
        System.out.println("Enter the current library catalogue. ");
        do {
            try {
                String title = retrieveTitle(sc);
                System.out.print("Enter the author: ");
                String author = sc.nextLine();
                library.addBook(title, author);
                System.out.print("Are there other books? (type 'y' to add more) ");
                yesNo = sc.nextLine().charAt(0);
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("There was no action input.");
            }
        } while (yesNo == 'y');

        System.out.println(
                "Enter a for all books, b for borrowed books, o for overdue books, t for total books, l to loan a book out, r to return a book, s to search for a book, + to add a book, - to remove a Book, and anything else to quit.");
        while (true) {
            try {
                System.out.print("Enter a command: ");
                char action = sc.next().charAt(0);
                sc.nextLine();
                if (action == 'a')
                    System.out.print(library);
                else if (action == 'b')
                    library.displayBorrowed();
                else if (action == 'o') {
                    Date cur = retrieveDate(sc);
                    library.displayOverdue(cur);
                } else if (action == 't')
                    System.out.println(library.getSize());
                else if (action == 'l') {
                    String title = retrieveTitle(sc);
                    System.out.print("Enter the borrower name: ");
                    String borrower = sc.nextLine();
                    Date borrowDate = retrieveDate(sc);
                    library.loanBook(title, borrower, borrowDate);
                } else if (action == 'r') {
                    String title = retrieveTitle(sc);
                    library.returnBook(title);
                } else if (action == 's') {
                    String title = retrieveTitle(sc);
                    System.out.println(library.searchLibrary(title));
                } else if (action == '+') {
                    String title = retrieveTitle(sc);
                    System.out.print("Enter the author: ");
                    String author = sc.nextLine();
                    library.addBook(title, author);
                } else if (action == '-') {
                    String title = retrieveTitle(sc);
                    library.removeBook(title);
                } else
                    break;
            } catch (InvalidDateException e) {
                System.out.println(e);
            } catch (InvalidTitleException e) {
                System.out.println(e);
            } catch (InputMismatchException e) {
                System.out.println("Invalid input: entered a string for an integer.");
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("There was no action input.");
            }
        }
    }

    static Date retrieveDate(Scanner sc) throws Exception {
        System.out.print("Enter the month as integer: ");
        int month = sc.nextInt();
        System.out.print("Enter the day: ");
        int day = sc.nextInt();
        System.out.print("Enter the year: ");
        int year = sc.nextInt();
        Date d = new Date(day, month, year);
        if (!d.checkValid())
            throw new InvalidDateException("Invalid input: The date entered is not a real date.");
        return d;
    }

    static String retrieveTitle(Scanner sc) {
        System.out.print("Enter the title: ");
        String title = sc.nextLine();
        return title;
    }
}
