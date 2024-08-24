package PublicLibrary;

import java.util.ArrayList;

public class LibraryMember {
    private String name;
    private ArrayList<Book> borrowedBooks;
    private static final int MAX_BORROW_LIMIT = 3;

    public LibraryMember(String name) {
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public void borrowBook(Library library, String bookId) {
        if (borrowedBooks.size() >= MAX_BORROW_LIMIT) {
            System.out.println(name + " has reached the maximum borrow limit.");
            return;
        }

        Book book = library.searchBookById(bookId);
        if (book != null && !book.isBorrowed()) {
            book.borrow();
            borrowedBooks.add(book);
            library.removeBook(book);
            System.out.println(name + " borrowed " + book.getTitle());
        } else if (book == null) {
            System.out.println("Book with ID " + bookId + " not found in the library.");
        } else {
            System.out.println("Book " + book.getTitle() + " is already borrowed.");
        }
    }

    public void returnBook(Library library, String bookId) {
        Book bookToReturn = null;
        for (Book book : borrowedBooks) {
            if (book.getId().equals(bookId)) {
                bookToReturn = book;
                break;
            }
        }

        if (bookToReturn != null) {
            bookToReturn.returnBook();
            borrowedBooks.remove(bookToReturn);
            library.addBook(bookToReturn);
            System.out.println(name + " returned " + bookToReturn.getTitle());
        } else {
            System.out.println("Book with ID " + bookId + " not found in borrowed books.");
        }
    }

    public void displayBorrowedBooks() {
        System.out.println(name + " has borrowed the following books:");
        for (Book book : borrowedBooks) {
            book.displayInfo();
        }
    }
}

