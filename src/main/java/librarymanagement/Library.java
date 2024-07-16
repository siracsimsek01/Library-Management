package librarymanagement;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
public class Library extends ILibraryOperations implements Serializable {
    private Map<String, Book> books;
    private Map<String, User> users;

    public Library() {
        books = new HashMap<>();
        users = new HashMap<>();
    }

    @Override
    public void addBook(Book book) {
//        books.put(book.getIsbn(), book);
    }

    @Override
    public void removeBook(String isbn) {
        books.remove(isbn);
    }

    @Override
    public void borrowBook(String isbn, String username) {
        Book book = books.get(isbn);
        if (book != null && book.isAvailable()) {
            book.setAvailable(false);
            Member member = (Member) users.get(username);
            if (member != null) {
                member.borrowBook(isbn);
            }
        }
    }

    @Override
    public void returnBook(String isbn, String username) {
        Book book = books.get(isbn);
        if (book != null && !book.isAvailable()) {
            book.setAvailable(true);
            Member member = (Member) users.get(username);
            if (member != null) {
                member.returnBook(isbn);
            }
        }
    }

    public void addUser(User user) {
        users.put(user.getUsername(), user);
    }

    public User getUser(String username) {
        return users.get(username);
    }

    public Map<String, Book> getBooks() {
        return books;
    }

    public Map<String, user> getUsers() {
        return users;
    }
}
