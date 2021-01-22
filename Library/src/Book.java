public class Book implements Comparable<Book>{
    private String title;
    private String author;

    public Book(String t, String a){
        title = t;
        author = a;
    }

    public boolean matchTitle(String t){
        return title.equals(t);
    }

    public boolean matchAuthor(String a){
        return author.equals(a);
    }

    public int compareTo(Book o){
        if(matchTitle(o.title)) return author.compareTo(o.author);
        return title.compareTo(o.title);
    }


}
