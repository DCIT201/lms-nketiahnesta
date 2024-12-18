import java.util.ArrayList;
import java.util.List;

public class Patron {
    private String name;
    private String patronId;
    private List<Book> borrowedBooks;

    // Constructor
    public Patron(String name, String patronId) {
        this.name = name;
        this.patronId = patronId;
        this.borrowedBooks = new ArrayList<>();
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getPatronId() {
        return patronId;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    // Borrow a book
    public void borrowBook(Book book) {
        if (book.isAvailable()) {
            borrowedBooks.add(book);
            book.setAvailable(false); // Mark the book as borrowed
            System.out.println(name + " borrowed the book: " + book.getTitle());
        } else {
            System.out.println("The book is not available: " + book.getTitle());
        }
    }

    // Return a book
    public void returnBook(Book book) {
        if (borrowedBooks.remove(book)) {
            book.setAvailable(true); // Mark the book as returned
            System.out.println(name + " returned the book: " + book.getTitle());
        } else {
            System.out.println("This book was not borrowed by " + name);
        }
    }
}