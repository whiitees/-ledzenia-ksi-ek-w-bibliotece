import java.util.ArrayList;
import java.util.List;

class Book {
    private String title;
    private String author;
    private int yearPublished;
    private boolean checkedOut;

    public Book(String title, String author, int yearPublished) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.checkedOut = false;
    }

    public void checkOut() {
        if (!checkedOut) {
            checkedOut = true;
            System.out.println("Book '" + title + "' by " + author + " has been checked out.");
        } else {
            System.out.println("Book '" + title + "' by " + author + " is already checked out.");
        }
    }

    public void checkIn() {
        if (checkedOut) {
            checkedOut = false;
            System.out.println("Book '" + title + "' by " + author + " has been checked in.");
        } else {
            System.out.println("Book '" + title + "' by " + author + " is not checked out.");
        }
    }

    @Override
    public String toString() {
        return title + " by " + author + " (" + yearPublished + ")" + (checkedOut ? " (Checked Out)" : "");
    }
}

public class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void displayBooks() {
        System.out.println("Library Catalog:");
        for (int i = 0; i < books.size(); i++) {
            System.out.println((i + 1) + ". " + books.get(i));
        }
    }

    public static void main(String[] args) {
        Library library = new Library();
        library.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925));
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee", 1960));
        library.addBook(new Book("1984", "George Orwell", 1949));

        library.displayBooks();
        System.out.println();

        library.books.get(0).checkOut();
        library.books.get(1).checkOut();
        library.books.get(0).checkIn();

        library.displayBooks();
    }
}
