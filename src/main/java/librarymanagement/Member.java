package librarymanagement;

public class Member extends User{
    public Member(String username, String password) {
        super(username, password);
    }

    public void borrowBook(Library library, String isbn) {
        library.borrowBook(isbn, this.getUsername());
    }

    public void returnBook(Library library, String isbn) {
        library.returnBook(isbn, this.getUsername());
    }
}
