package PublicLibrary;
import java.util.UUID;

public class Book {
    private String id;
    private String title;
    private String author;
    private boolean isBorrowed;

    public Book(String title, String author) {
        this.id = UUID.randomUUID().toString(); // Generate a unique ID for each book
        this.title = title;
        this.author = author;
        this.isBorrowed = false;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void borrow() {
        isBorrowed = true;
    }

    public void returnBook() {
        isBorrowed = false;
    }

    public void displayInfo() {
        System.out.println("ID: " + id + ", Title: " + title + ", Author: " + author + ", Borrowed: " + isBorrowed);
    }
}

