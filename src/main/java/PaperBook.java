/**
 * The PaperBook class represents a physical book with a weight property.
 * It extends the Book class and adds functionality specific to paper books.
 * This class includes a constructor to initialize the book's properties and getter/setter methods for the weight.
 * The weight is measured in grams and can be set and retrieved using the provided methods.
 * This class is meant to represent physical books, allowing us to manage and track the weight of each book.
 */
public class PaperBook extends Book {
    private int weight;

    /**
     * Constructs a new PaperBook object.
     *
     * @param title The title of the book.
     * @param author The author of the book.
     * @param isbn The International Standard Book Number (ISBN) of the book, can be any string.
     * @param weight The weight of the paper book in grams.
     */
    public PaperBook(String title, String author, String isbn, int weight) {
        super(title, author, isbn);
        this.weight = weight;
    }

    /**
     * Sets the weight of the paper book in grams.
     * 
     * @param weight The weight of the paper book in grams.
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }
    /**
     * Returns the weight of the paper book in grams.
     *
     * @return The weight of the paper book in grams.
     */
    public int getWeight() {
        return this.weight;
    }

}
