import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

/**
 * The <code>Library</code> class manages a collection of books, allowing for adding, removing, and retrieving books by their ISBN.</br>
 * This class can contain any type of book, including <code>PaperBooks</code> and <code>Ebooks</code>, as they both extend the <code>Book</code> class.</br>
 * The primary way to identify and manage books in the library is through their ISBN, which is stored as a key in the HashMap.</br>
 * Since the ISBN is unique, this class adopts it to be used as the key for storing and retrieving books, ensuring that each book can be uniquely identified and accessed efficiently.
 */
public class Library {
    private HashMap<String, Book> books;

    public Library() {
        this.books = new HashMap<>();
    }

    /**
     * Adds a book to the library. 
     * If a book with the same ISBN already exists, 
     * it'll throw an IllegalArgumentException to prevent duplicate entries, 
     * with a custom error message indicating the issue.
     *
     * @param book The book to be added to the library.
     */
    public void addBook(Book book) throws IllegalArgumentException {
        if (this.books.containsKey(book.getIsbn())) {
            throw new IllegalArgumentException("A book with ISBN " + book.getIsbn() + " already exists in the library.");
        }
        this.books.put(book.getIsbn(), book);
    }
    /**
     * Removes a book from the library by its ISBN. 
     * If the book does not exist, throws an IllegalArgumentException.
     *
     * @param isbn The ISBN of the book to be removed.
     */
    public void removeBook(String isbn) throws IllegalArgumentException {
        if (!this.books.containsKey(isbn)) {
            throw new IllegalArgumentException("A book with ISBN " + isbn + " does not exist in the library.");
        }
        this.books.remove(isbn);
    }

    /**
     * Returns a list of all the books currently in the library.
     * If no books are present, it returns an empty list.
     * 
     * @return A list of all books in the library.
     */
    public List<Book> listBooks() {
        return new ArrayList<>(this.books.values());
    }

    /**
     * Retrieves a book from the library by its author. If the book does not exist, returns null.
     * 
     * @param author The author of the book to be retrieved.
     * @return a list of all books by the given author, or an empty list if no books by that author are found.
     */
    public List<Book> getBooksByAuthor(String author) {
        List<Book> booksByAuthor = new ArrayList<>();
        for (Book book : this.books.values()) {
            if (book.getAuthor().equals(author)) {
                booksByAuthor.add(book);
            }
        }
        return booksByAuthor; // Return the list of books by the given author
    }
}
