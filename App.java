
public class App {
    public static void main(String[] args) {
        // Create a library
        Library library = new Library("City Library", "123 Main St");

        // Add books to the library
        library.addBook(new Book("A bright flower", "Eugene Arthur", "123456789"));
        library.addBook(new Book("Kaya Boy", "Edna Quaye", "987654321"));
        library.addBook(new Book("The Great Tree", "Desmond Otu", "111222333"));

        // Register patrons
        Patron patron1 = new Patron("Jeff", "P001");
        Patron patron2 = new Patron("Mike", "P002");
        library.registerPatron(patron1);
        library.registerPatron(patron2);

        // Display available books
        library.displayAvailableBooks();

        // Loan a book
        library.loanBook("1984", "P001");

        // Display available books after loan
        library.displayAvailableBooks();

        // Return a book
        patron1.returnBook(new Book("1984", "Eugene Baidoo", "987654321"));
        library.loanBook("1984", "P001");



        // Display all patrons
        library.displayPatrons();
    }
}