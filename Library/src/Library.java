import java.util.*;

public class Library {
    private ArrayList<Book> library;
    private ArrayList<BorrowedBook> borrowed;

    public Library() {
        library = new ArrayList<>();
        borrowed = new ArrayList<>();
    }

    public int getSize() {
        return library.size();
    }

    public void displayOverdue(Date cur) throws Exception {
        for (BorrowedBook b : borrowed) {
            if (b.isOverdue(cur))
                System.out.println(b);
        }
    }

    public void displayBorrowed() {
        for (BorrowedBook b : borrowed) {
            System.out.println(b);
        }
    }

    public Book searchLibrary(String keyword) throws Exception {
        for (Book b : library) {
            if (keyword.equals(b.getTitle()))
                return b;
        }
        throw new InvalidTitleException("Invalid input: Non-existent title or borrowed book.");
    }

    public BorrowedBook searchBorrowed(String keyword) throws Exception {
        for (BorrowedBook b : borrowed) {
            if (keyword.equals(b.getTitle()))
                return b;
        }
        throw new InvalidTitleException("Invalid input: Non-existent title or unborrowed book.");
    }

    public Book loanBook(String title, String borrower, Date d) throws Exception {
        Book b = searchLibrary(title);
        if (b == null)
            return null;
        library.remove(b);
        borrowed.add(new BorrowedBook(b, borrower, d));
        return b;
    }

    public void returnBook(String title) throws Exception {
        BorrowedBook b = searchBorrowed(title);
        borrowed.remove(b);
        library.add(new Book(b.getTitle(), b.getAuthor()));
    }

    public void addBook(String title, String author) {
        Book b = new Book(title, author);
        int i = 0;
        while (i < library.size() && b.compareTo(library.get(i)) > 0)
            i++;
        library.add(b);

    }

    public void removeBook(String title) throws Exception {
        Book b = searchLibrary(title);
        library.remove(b);
    }

    public void sortLibrary() {
        ArrayList<Book> temp = new ArrayList<>();
        int i;
        for (Book b : library) {
            i = 0;
            while (i < temp.size() && b.compareTo(temp.get(i)) > 0)
                i++;
            temp.add(i, b);
        }
    }

    public String toString() {
        String s = "";
        for (Book b : library) {
            s += b.toString() + '\n';
        }
        return s;
    }
}
