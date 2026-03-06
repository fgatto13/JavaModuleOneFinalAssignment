/**
 * Represents a book in the library.</br>
 * This class serves as a base for different types of books.
 */
public class Book {
    private String title;
    private String author;
    private String isbn;

    /**
     * Constructs a new Book object.
     *
     * @param title The title of the book.
     * @param author The author of the book.
     * @param isbn The International Standard Book Number (ISBN) of the book, can be any string.
     */
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    /**
     * Returns the title of the book.
     *
     * @return The title of the book.
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Returns the author of the book.
     *
     * @return The author of the book.
     */
    public String getAuthor() {
        return this.author;
    }

    /**
     * Returns the ISBN of the book.
     *
     * @return The ISBN of the book.
     */
    public String getIsbn() {
        return this.isbn;
    }
}
