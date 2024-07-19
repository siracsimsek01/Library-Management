package librarymanagement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class LibraryTest {
    @Test
    public void testAddBook() {
        Library library = new Library();
        Book book = new Book("Test Title", "Test Author", "123456");
        library.addBook(book);

        assertEquals(1, library.getBooks().size());
        assertEquals("Test Title", library.getBooks().get("123456").getTitle());
    }

    @Test
    public void testRemoveBook() {
        Library library = new Library();
        Book book = new Book("Test Title", "Test Author", "123456");
        library.addBook(book);
        library.removeBook("123456");

        assertEquals(0, library.getBooks().size());
    }

    @Test
    public void testBorrowBook() {
        Library library = new Library();
        Book book = new Book("Test Title", "Test Author", "123456");
        Member member = new Member("testuser", "password");
        library.addUser(member);
        library.borrowBook("123456", "testuser");

        assertFalse(library.getBooks().get("123456").isAvailable());
    }

    @Test
    public void testReturnBook() {
        Library library = new Library();
        Book book = new Book("Test Title", "Test Author", "123456");
        library.addBook(book);
        Member member = new Member("testuser", "password");
        library.addUser(member);

        library.borrowBook("123456", "testuser");
        library.returnBook("123456", "testuser");

        assertTrue(library.getBooks().get("123456").isAvailable());
    }
}
