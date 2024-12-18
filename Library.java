import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<Patron> patrons;

    // Constructor
    public Library(String name, String address) {
        this.books = new ArrayList<>();
        this.patrons = new ArrayList<>();
    }

    // Add a book to the library
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added to the library: " + book.getTitle());
    }
    public void addPatron(Patron patron) {}

    // Register a patron
    public void registerPatron(Patron patron) {
        patrons.add(patron);
        System.out.println("Patron registered: " + patron.getName());
    }

    // Loan a book to a patron
    public void loanBook(String title, String patronId) {
        Book bookToLoan = null;
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && book.isAvailable()) {
                bookToLoan = book;
                break;
            }
        }

        if (bookToLoan == null) {
            System.out.println("Book not available for loan: " + title);
            return;
        }

        for (Patron patron : patrons) {
            if (patron.getPatronId().equals(patronId)) {
                patron.borrowBook(bookToLoan);
                return;
            }
        }

        System.out.println("Patron not found: " + patronId);
    }

    // Display all available books
    public void displayAvailableBooks() {
        System.out.println("Available books in the library:");
        for (Book book : books) {
            if (book.isAvailable()) {
                System.out.println(book.getTitle() + " by " + book.getAuthor());
            }
        }
    }

    // Display all patrons
    public void displayPatrons() {
        System.out.println("Registered patrons:");
        for (Patron patron : patrons) {
            System.out.println(patron.getName() + " (ID: " + patron.getPatronId() + ")");
        }
    }
}