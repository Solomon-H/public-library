import PublicLibrary.Book;
import PublicLibrary.Library;
import PublicLibrary.LibraryMember;

public class Main {
    public static void main(String[] args) {

        Book book1 = new Book("1984", "George Orwell");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee");
        Book book3 = new Book("The Great Gatsby", "F. Scott Fitzgerald");
        Book book4 = new Book("Moby Dick", "Herman Melville");

        // Create a Library and add the books to it
        Library myLibrary = new Library();
        myLibrary.addBook(book1);
        myLibrary.addBook(book2);
        myLibrary.addBook(book3);
        myLibrary.addBook(book4);

        // Create a LibraryMember
        LibraryMember member = new LibraryMember("Alice");

        // Create a Customer and show the menu
        Customer customer = new Customer(myLibrary, member);
        customer.showMenu();
    }
}
