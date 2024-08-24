package PublicLibrary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Library {
    private ArrayList<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println(book.getTitle() + " added to the library.");
    }

    public void removeBook(Book book) {
        if (books.remove(book)) {
            System.out.println(book.getTitle() + " removed from the library.");
        } else {
            System.out.println(book.getTitle() + " not found in the library.");
        }
    }

    public void displayBooks() {
        System.out.println("Library Books:");
        for (Book book : books) {
            book.displayInfo();
        }
    }

    public Book searchBookById(String id) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }

    public ArrayList<Book> searchBooksByTitle(String title) {
        ArrayList<Book> foundBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    public void sortBooksByTitle() {
        Collections.sort(books, Comparator.comparing(Book::getTitle));
    }

    public void sortBooksByAuthor() {
        Collections.sort(books, Comparator.comparing(Book::getAuthor));
    }
}

