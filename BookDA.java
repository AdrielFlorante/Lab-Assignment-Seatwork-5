import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashMap;

public class BookDA {
    private HashMap<String, Book> isbnToBookMap = new HashMap<>();
    private HashMap<String, Book> authorToBookMap = new HashMap<>();
    private AuthorDA authorDA = new AuthorDA();

    public Book getBookByIsbn(String isbn) { // Ended up never using this lol
        return isbnToBookMap.get(isbn);
    }

    public AuthorDA getAuthorDA() {
        return authorDA;
    }

    public BookDA() {
        try {
            Scanner inputFile = new Scanner(new FileReader("src/Book.csv"));

            inputFile.nextLine();

            while (inputFile.hasNext()) {
                String lineData = inputFile.nextLine();
                String[] splitData = lineData.split(",");

                Book book = new Book();

                book.setIsbn(splitData[0].trim());
                book.setTitle(splitData[1].trim());
                book.setAuthor(splitData[2].trim());

                // Map ISBN to Book object
                isbnToBookMap.put(splitData[0].trim(), book);

                // Map author name to Book object
                authorToBookMap.put(splitData[2].trim(), book);
            }

            inputFile.close();

        } catch (FileNotFoundException e) {
            System.err.println("File not found!");
        }
    }

    public HashMap<String, Book> getBookMap() {
        return isbnToBookMap;
    }

    public HashMap<String, Book> getAuthorToBookMap() {
        return authorToBookMap;
    }
}
