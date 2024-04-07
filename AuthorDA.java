import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class AuthorDA {
    private HashMap<String, Author> authorMap = new HashMap<>();

    public AuthorDA() {
        try {
            Scanner inputFile = new Scanner(new FileReader("src/Author.csv"));

            inputFile.nextLine();

            // create() Author
            while (inputFile.hasNext()) {
                String lineData = inputFile.nextLine();
                String[] splitData = lineData.split(",");

                Author author = new Author();

                author.setName(splitData[0].trim());
                author.setBio(splitData[1].trim());

                // adding author to hashmap
                authorMap.put(splitData[0].trim(), author);
            }

            inputFile.close();

        } catch (FileNotFoundException e) {
            System.err.println("Author.csv file not found.");
        }
    }

    public Author getAuthorByName(String name) {
        return authorMap.get(name);
    }

}
