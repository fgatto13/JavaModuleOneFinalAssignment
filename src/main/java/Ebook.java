
/**
 * This is a subclass of the `Book` class that represents an ebook in the library.
 * 
 * The `Ebook` class inherits the properties and methods of the `Book` class and adds its own specific functionality:
 * - `fileSize`: A double representing the file size of the ebook in megabytes.
 * For this attribute, a `getter` and a `setter` are provided, in order to access and modify it.
 */
public class Ebook extends Book {
    private double fileSize; // in megabytes

    /**
     * Constructs a new Ebook object.
     *
     * @param title The title of the ebook.
     * @param author The author of the ebook.
     * @param isbn The International Standard Book Number (ISBN) of the ebook, can be any string.
     * @param fileSize The file size of the ebook in megabytes.
     */
    public Ebook(String title, String author, String isbn, double fileSize) {
        super(title, author, isbn);
        this.fileSize = fileSize;
    }

    /**
     * Sets the file size of the ebook in megabytes.
     * 
     * @param fileSize The file size of the ebook in megabytes.
     */
    public void setFileSize(double fileSize) {
        this.fileSize = fileSize;
    }

    /**
     * Returns the file size of the ebook in megabytes.
     *
     * @return The file size of the ebook in megabytes.
     */
    public double getFileSize() {
        return this.fileSize;
    }

}
