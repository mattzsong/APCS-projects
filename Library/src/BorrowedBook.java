public class BorrowedBook extends Book {
    private String borrowerName;
    private Date borrowDate;

    public BorrowedBook(Book b, String bN, Date d){
        super(b.title, b.author);
        borrowerName = bN;
        borrowDate = d;
    }
    
    public boolean isOverdue(Date cur){
        
    }
}
