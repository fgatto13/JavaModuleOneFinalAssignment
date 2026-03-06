
/**
 * This is a test class for the Book class.
 * 
 * To run all the tests in this class, run the following command from the project root:
 * `mvn test -Dtest=BookTest`
 * 
 * To run a single test method, run the following command from the project root:
 * `mvn test -Dtest=BookTest#testMethodName`
 * For example, to run the assertBookExists test, use the following command:
 * `mvn test -Dtest=BookTest#assertBookExists`
 * 
 * --------------------------------------------------------------------------------------
 * 
 * HOW TESTS ARE WRITTEN.
 * 
 * A test class is a class that contains methods that test the functionality of another class.
 * In this case, this class tests the functionality of the Library class.
 * 
 * Each method that tests a specific functionality is annotated with the `@Test` annotation.
 * This annotation tells the test runner that this method is a test case.
 * 
 * Inside each test method, you should:
 * 1. Set up the conditions for the test. This is called the "arrange" phase.
 * 2. Call the method that you want to test. This is called the "act" phase.
 * 3. Verify that the result is what you expect. This is called the "assert" phase.
 * 
 * For example, in the `assertBookExists` test, we want to verify that when a book is added to the library,
 * it can be retrieved.
 * 
 * 1. Arrange: we create a new Library and a new Book.
 * 2. Act: we add the book to the library.
 * 3. Assert: we retrieve the book from the library and verify that it is the same book that we added.
 * 
 * To verify the result, we use assertions. Assertions are methods that check for a specific condition and
 * throw an error if the condition is not met.
 * 
 * For example, `assertEquals(expected, actual)` verifies that the expected value is equal to the actual value.
 * `assertNotNull(object)` verifies that the object is not null.
 * 
 * You can find more assertions in the JUnit documentation: https://junit.org/junit5/docs/current/api/org.junit.jupiter.api/org/junit/jupiter/api/Assertions.html
 */
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

class BookTest {

    @Test
    void assertBookCreation() {
        // Arrange: we create a new Book object.
        final String title = "The Lord of the Rings";
        final String author =  "J.R.R. Tolkien";
        final String isbn = "f276d2bb-d9aa-43c0-9fe9-e1ec89a33c39";

        Book book = new Book(title, author, isbn);

        // Act: we don't need to do anything for this test.

        // Assert: we verify that the book object has the correct properties.
        assertNotNull(book);
        assertEquals(title, book.getTitle());
        assertEquals(author, book.getAuthor());
        assertEquals(isbn, book.getIsbn());
    }

    /**
     * This test verifies that a book can be added to the library 
     * and that it exists, using the ISBN to check for its existence.
     */
    @Test
    void testAddBook() {
        // 1. Create a new Library object.
        Library library = new Library();
        // 2. Create a new Book object.
        final String title = "The Lord of the Rings";
        final String author =  "J.R.R. Tolkien";
        final String isbn = "f276d2bb-d9aa-43c0-9fe9-e1ec89a33c39";
        Book book = new Book(title, author, isbn);
        // 3. Add the book to the library.
        try {
            library.addBook(book);
        } catch (IllegalArgumentException e) {
            // If an exception is thrown, the test should fail.
            assert false : "An exception was thrown when adding a book to the library: " + e.getMessage();
        }
        // 4. Verify that the book is in the library.
        Book retrievedBook = library.listBooks().stream()
                .filter(b -> b.getIsbn().equals(isbn))
                .findFirst()
                .orElse(null);
        assertNotNull(retrievedBook, "The book was not found in the library.");
        assertEquals(book, retrievedBook);
    }

    /**
     * This test verifies that a book can be removed from the library and that it no longer exists,
     * using the ISBN to check for its existence.
     */
    @Test
    void testRemoveBook() {
        // 1. Create a new Library object.
        Library library = new Library();
        // 2. Create a new Book object and add it to the library.
        final String title = "The Lord of the Rings";
        final String author = "J.R.R. Tolkien";
        final String isbn = "f276d2bb-d9aa-43c0-9fe9-e1ec89a33c39";
        Book book = new Book(title, author, isbn);
        try {
            library.addBook(book);
        } catch (IllegalArgumentException e) {
            assert false : "An exception was thrown when adding a book to the library: " + e.getMessage();
        }
        // 3. Remove the book from the library using its ISBN.
        try {
            library.removeBook(isbn);
        } catch (IllegalArgumentException e) {
            assert false : "An exception was thrown when removing a book from the library: " + e.getMessage();
        }
        // 4. Verify that the book is no longer in the library.
        Book retrievedBook = library.listBooks().stream()
                .filter(b -> b.getIsbn().equals(isbn))
                .findFirst()
                .orElse(null);
        assertNull(retrievedBook, "The book was found in the library after being removed.");
    }

    @Test
    void testListBooks() {
        // 1. Create a new Library object.
        Library library = new Library();
        // 2. Create multiple Book objects and add them to the library.
        final String title1 = "The Lord of the Rings";
        final String author1 = "J.R.R. Tolkien";
        final String isbn1 = "f276d2bb-d9aa-43c0-9fe9-e1ec89a33c39";
        Book book1 = new Book(title1, author1, isbn1);
        try {
            library.addBook(book1);
        } catch (IllegalArgumentException e) {
            assert false : "An exception was thrown when adding a book to the library: " + e.getMessage();
        }
        final String title2 = "Harry Potter and the Philosopher's Stone";
        final String author2 = "J.K. Rowling";
        final String isbn2 = "a5b6c7d8-e9f0-1234-5678-90abcdef12";
        Book book2 = new Book(title2, author2, isbn2);
        try {
            library.addBook(book2);
        } catch (IllegalArgumentException e) {
            assert false : "An exception was thrown when adding a book to the library: " + e.getMessage();
        }
        // 3. Call the listBooks() method.
        List<Book> books = library.listBooks();
        // 4. Verify that the returned list contains all the books that were added.
        assertEquals(2, books.size());
        assertTrue(books.contains(book1));
        assertTrue(books.contains(book2));
    }

    @Test
    void testGetBookByAuthor() {
        // 1. Create a new Library object.
        Library library = new Library();
        // 2. Create multiple Book objects with different authors and add them to the library.
        List<Book> booksToAdd = List.of(
            new Book("The Lord of the Rings", "J.R.R. Tolkien", "f276d2bb-d9aa-43c0-9fe9-e1ec89a33c39"),
            new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling", "a5b6c7d8-e9f0-1234-5678-90abcdef12"),
            new Book("The Hobbit", "J.R.R. Tolkien", "12345678-90ab-cdef-1234-567890abcdef")
        );
        for (Book book : booksToAdd) {
            try {
                library.addBook(book);
            } catch (IllegalArgumentException e) {
                assert false : "An exception was thrown when adding a book to the library: " + e.getMessage();
            }
        }
        // 3. Call the getBooksByAuthor() method with a specific author.
        List<Book> booksByAuthorT = library.getBooksByAuthor("J.R.R. Tolkien");
        List<Book> booksByAuthorR = library.getBooksByAuthor("J.K. Rowling");
        // 4. Verify that the returned list contains all the books by that author.
        assertEquals(2, booksByAuthorT.size());
        assertEquals(1, booksByAuthorR.size());
        assertTrue(booksByAuthorT.contains(booksToAdd.get(0)));
        assertTrue(booksByAuthorT.contains(booksToAdd.get(2)));
        assertTrue(booksByAuthorR.contains(booksToAdd.get(1)));
    }

    @Test
    void testEbookCreation() {
        // 1. Create a new Ebook object.
        Ebook ebook = new Ebook("The Hobbit", "J.R.R. Tolkien", "12345678-90ab-cdef-1234-567890abcdef", 2.5);
        // 2. Verify that the book object has the correct properties (title, author, isbn, and file size).
        assertEquals("The Hobbit", ebook.getTitle());
        assertEquals("J.R.R. Tolkien", ebook.getAuthor());
        assertEquals("12345678-90ab-cdef-1234-567890abcdef", ebook.getIsbn());
        assertEquals(2.5, ebook.getFileSize(), 0.0);
    }

    @Test
    void testPaperBookCreation() {
        // 1. Create a new PaperBook object.
        PaperBook paperBook = new PaperBook("The Hobbit", "J.R.R. Tolkien", "12345678-90ab-cdef-1234-567890abcdef", 500);
        // 2. Verify that the book object has the correct properties (title, author, isbn, and weight).
        assertEquals("The Hobbit", paperBook.getTitle());
        assertEquals("J.R.R. Tolkien", paperBook.getAuthor());
        assertEquals("12345678-90ab-cdef-1234-567890abcdef", paperBook.getIsbn());
        assertEquals(500, paperBook.getWeight());
    }
}
