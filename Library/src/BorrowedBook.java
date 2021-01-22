public class BorrowedBook extends Book {
    private String borrowerName;
    private Date borrowDate;

    public BorrowedBook(Book b, String bN, Date d) {
        super(b.getTitle(), b.getAuthor());
        borrowerName = bN;
        borrowDate = d;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public boolean isOverdue(Date cur) throws Exception {
        if (borrowDate.compareTo(cur) > 0) {
            throw new InvalidDateException("Invalid input: Date entered comes before borrow date of book.");
        }
        return cur.dayDifference(borrowDate) > 14;
    }

    public String toString() {
        return getTitle() + ", " + getAuthor() + " borrowed by " + borrowerName + " on " + borrowDate.toString();
    }
}
