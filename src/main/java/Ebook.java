
/**
 * This is a subclass of the <code>Book</code> class that represents an ebook in the library.</br>
 * 
 * The <code>Ebook</code> class inherits the properties and methods of the <code>Book</code> class and adds its own specific functionality:</br>
 * - <code>fileSize</code>: A double representing the file size of the ebook in megabytes.</br>
 * For this attribute, a <code>getter</code> and a <code>setter</code> are provided, in order to access and modify it.
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
