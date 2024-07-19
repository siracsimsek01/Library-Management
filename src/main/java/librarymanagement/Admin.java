package librarymanagement;

public class Admin extends User{
    public Admin(String username, String password)
    {
        super(username, password);
    }

    public void addBook(Library library, Book book) {
        library.addBook(book);
    }

    public void removeBook(Library library, String isbn) {
        library.removeBook(isbn);
    }
}
