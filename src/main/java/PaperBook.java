/**
 * This is a subclass of the <code>Book</code> class that represents a paper book in the library.</br>
 *  The <code>PaperBook</code> class inherits the properties and methods of the <code>Book</code> class and adds its own specific functionality:</br>
 * - <code>weight</code>: An integer representing the weight of the paper book in grams.</br>
 * For this attribute, a <code>getter</code> and a <code>setter</code> are provided, in order to access and modify it.
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
