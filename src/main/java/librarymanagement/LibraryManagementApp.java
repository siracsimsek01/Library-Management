package librarymanagement;

import java.util.Scanner;

public class LibraryManagementApp {
    private static final String FILENAME = "library.dat";

    public static void main(String[] args) {
        Library library = Database.loadLibrary(FILENAME);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Management System Menu:");
            System.out.println("1. Register User");
            System.out.println("2. Login");
            System.out.println("3. Add Book (Admin)");
            System.out.println("4. Remove Book (Admin)");
            System.out.println("5. Borrow Book (Member)");
            System.out.println("6. Return Book (Member)");
            System.out.println("7. View Books");
            System.out.println("8. Save and Exit");
            System.out.println("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    registerUser(library, scanner);
                    break;
                case 2:
                    loginUser(library, scanner);
                    break;
                case 3:
                    addBook(library, scanner);
                    break;
                case 4:
                    removeBook(library, scanner);
                    break;
                case 5:
                    borrowBook(library, scanner);
                    break;
                case 6:
                    returnBook(library, scanner);
                    break;
                case 7:
                    viewBooks(library);
                    break;
                case 8:
                    Database.saveLibrary(library, FILENAME);
                    System.out.println("Data saved. Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void registerUser(Library library, Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine(); // Fixed: Added password input
        System.out.println("Enter role (admin/member): ");
        String role = scanner.nextLine();

        User user;
        if (role.equalsIgnoreCase("admin")) {
            user = new Admin(username, password);
        } else {
            user = new Member(username, password);
        }

        library.addUser(user);
        System.out.println("User registered successfully.");
    }

    private static void loginUser(Library library, Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        User user = library.getUser(username);
        if (user != null && user.getPassword().equals(password)) {
            System.out.println("Login successful.");
            // Handle user-specific actions (not shown in this snippet)
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    private static void addBook(Library library, Scanner scanner) {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter book author: ");
        String author = scanner.nextLine();
        System.out.print("Enter book ISBN: ");
        String isbn = scanner.nextLine();

        Book book = new Book(title, author, isbn);
        library.addBook(book);
        System.out.println("Book added successfully.");
    }

    private static void removeBook(Library library, Scanner scanner) {
        System.out.print("Enter book ISBN: ");
        String isbn = scanner.nextLine();
        library.removeBook(isbn);
        System.out.println("Book removed successfully.");
    }

    private static void borrowBook(Library library, Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter book ISBN: ");
        String isbn = scanner.nextLine();

        library.borrowBook(isbn, username);
        System.out.println("Book borrowed successfully.");
    }

    private static void returnBook(Library library, Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter book ISBN: ");
        String isbn = scanner.nextLine();

        library.returnBook(isbn, username);
        System.out.println("Book returned successfully.");
    }

    private static void viewBooks(Library library) {
        for (Book book : library.getBooks().values()) {
            System.out.println(book);
        }
    }
}