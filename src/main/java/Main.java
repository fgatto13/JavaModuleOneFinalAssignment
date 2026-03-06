import java.util.Scanner;

/**
 * This class won't be necessary in this particular exercise.
 */
public class Main {
    private static void insertBookIntoLibrary(Book book, Library library){
        try {
            library.addBook(book);
        } catch (IllegalArgumentException e) {
            // If an exception is thrown, we can print an error message and return from the method.
            System.out.println("An error occurred while adding the book to the library: " + e.getMessage());
            return;
        }
    }
    private static String printMenuAndReturnSelection(){
        System.out.println("Welcome to the Library!");
        System.out.println("Please choose an option:");
        System.out.println("1. Add a book");
        System.out.println("2. Remove a book");
        System.out.println("3. List all books");
        System.out.println("4. Exit");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        scanner.close();
        return choice;
    }

    private static void printBooksInLibrary(Library library){
        System.out.println("Books in the library:");
        for (Book book : library.listBooks()) {
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("ISBN: " + book.getIsbn());
            if (book instanceof Ebook) {
                System.out.println("File Size: " + ((Ebook) book).getFileSize() + " MB");
            } else if (book instanceof PaperBook) {
                System.out.println("Weight: " + ((PaperBook) book).getWeight() + " grams");
            }
            System.out.println();
        }
    }

    private static void removeBookFromLibrary(Library library, String isbn){
        try {
            library.removeBook(isbn);
        } catch (IllegalArgumentException e) {
            // If an exception is thrown, we can print an error message.
            System.out.println("An error occurred while removing the book from the library: " + e.getMessage());
        }
    }
    
    private static void insertNewBookFromUserPrompt(Library library){
        Scanner scanner = new Scanner(System.in);
        // First of all, we need to know what type of book the user wants to add (Ebook or PaperBook).
        System.out.println("What type of book do you want to add? (Ebook/PaperBook)");
        String bookType = scanner.nextLine();
        if (bookType.equalsIgnoreCase("Ebook")) {
            // If the user wants to add an Ebook, we need to ask for the title, author, isbn, and file size.
            System.out.println("Enter the title of the book:");
            String title = scanner.nextLine();
            System.out.println("Enter the author of the book:");
            String author = scanner.nextLine();
            System.out.println("Enter the ISBN of the book:");
            String isbn = scanner.nextLine();
            System.out.println("Enter the file size of the ebook in MB:");
            double fileSize = Double.parseDouble(scanner.nextLine());
            // Then we can create a new Ebook object and add it to the library.
            Ebook ebook = new Ebook(title, author, isbn, fileSize);
            insertBookIntoLibrary(ebook, library);
        } else if (bookType.equalsIgnoreCase("PaperBook")) {
            // If the user wants to add a PaperBook, we need to ask for the title, author, isbn, and weight.
            System.out.println("Enter the title of the book:");
            String title = scanner.nextLine();
            System.out.println("Enter the author of the book:");
            String author = scanner.nextLine();
            System.out.println("Enter the ISBN of the book:");
            String isbn = scanner.nextLine();
            System.out.println("Enter the weight of the paper book in grams:");
            int weight = Integer.parseInt(scanner.nextLine());
            // Then we can create a new PaperBook object and add it to the library.
            PaperBook paperBook = new PaperBook(title, author, isbn, weight);
            insertBookIntoLibrary(paperBook, library);
        } else {
            // If the user enters an invalid book type, we can print an error message.
            System.out.println("Invalid book type. Please enter 'Ebook' or 'PaperBook'.");
        }
        scanner.close();
    }
    public static void main(String[] args) {
        // first of all, we want to create a library to manage our books.
        Library library = new Library();
        // then, using a while loop, we can prompt the user with a menu of options to manage the library.
        // we can use a Scanner to read user input and perform actions based on the user's choice
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            String choice = printMenuAndReturnSelection();
            switch (choice) {
                case "1":
                    insertNewBookFromUserPrompt(library);
                    break;
                case "2":
                    // to remove a book from the library, we first need to ask the user the isbn of the boo
                    System.out.println("Enter the ISBN of the book you want to remove:");
                    String isbn = scanner.nextLine();
                    removeBookFromLibrary(library, isbn);
                    break;
                case "3":
                    printBooksInLibrary(library);
                    break;
                default :
                    // To exit the program, we can set the exit variable to true.
                    exit = true;
                    System.out.println("Goodbye!");
                    scanner.close();
                    break;
            }
        }
    }

}
