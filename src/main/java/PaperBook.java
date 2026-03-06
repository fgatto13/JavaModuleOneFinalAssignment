public class PaperBook extends Book {
    private int numberOfPages;

    /**
     * Constructs a new PaperBook object.
     *
     * @param title The title of the book.
     * @param author The author of the book.
     * @param isbn The International Standard Book Number (ISBN) of the book, can be any string.
     * @param numberOfPages The number of pages in the paper book.
     */
    public PaperBook(String title, String author, String isbn, int numberOfPages) {
        super(title, author, isbn);
        this.numberOfPages = numberOfPages;
    }

    /**
     * Returns the number of pages in the paper book.
     *
     * @return The number of pages in the paper book.
     */
    public int getNumberOfPages() {
        return this.numberOfPages;
    }

}
