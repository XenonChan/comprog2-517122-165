import java.util.ArrayList;

class Book {
    public String isbn;
    public String title;
    public String type;
    public double price;

    public Book(String isbn, String title, String type, double price) {
        this.isbn = isbn;
        this.title = title;
        this.type = type;
        this.price = price;
    }

}
public class BookStore {

    ArrayList<Book> books = new ArrayList<Book>();

    public void addBook(String isbn, String title, String type, double price) {
        books.add(new Book(isbn, title, type, price));
    }
}