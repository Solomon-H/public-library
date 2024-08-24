import PublicLibrary.Library;
import PublicLibrary.LibraryMember;

import java.util.Scanner;

public class Customer {
    private Library library;
    private LibraryMember member;
    private Scanner scanner;

    public Customer(Library library, LibraryMember member) {
        this.library = library;
        this.member = member;
        this.scanner = new Scanner(System.in);
    }

    public void showMenu() {
        int choice;
        do {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Check List of Books");
            System.out.println("2. Borrow a Book");
            System.out.println("3. Return a Book");
            System.out.println("4. View Borrowed Books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    checkListOfBooks();
                    break;
                case 2:
                    borrowBook();
                    break;
                case 3:
                    returnBook();
                    break;
                case 4:
                    viewBorrowedBooks();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }

    private void checkListOfBooks() {
        System.out.println("\n--- List of Books ---");
        library.displayBooks();
    }

    private void borrowBook() {
        System.out.println("\n--- Borrow a Book ---");
        System.out.print("Enter the ID of the book you want to borrow: ");
        String bookId = scanner.nextLine();
        member.borrowBook(library, bookId);
    }

    private void returnBook() {
        System.out.println("\n--- Return a Book ---");
        System.out.print("Enter the ID of the book you want to return: ");
        String bookId = scanner.nextLine();
        member.returnBook(library, bookId);
    }

    private void viewBorrowedBooks() {
        System.out.println("\n--- Borrowed Books ---");
        member.displayBorrowedBooks();
    }
}

