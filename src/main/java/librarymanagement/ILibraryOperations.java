package librarymanagement;

public interface ILibraryOperations {
    void addBook(Book book);
    void removeBook(String isbn);
    void borrowBook(String isbn, String username);
    void returnBook(String isbn, String username);
}
