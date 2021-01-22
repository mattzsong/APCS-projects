public class Book implements Comparable<Book> {
    private String title;
    private String author;

    public Book(String t, String a) {
        this.title = t;
        this.author = a;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public int compareTo(Book o) {
        if (title.equals(o.getTitle()))
            return author.compareTo(o.getAuthor());
        return title.compareTo(o.getTitle());
    }

    public String toString() {
        return title + ", " + author;
    }
}
