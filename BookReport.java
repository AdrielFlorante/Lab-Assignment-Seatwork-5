import java.util.HashMap;

public class BookReport {

    public static void main(String[] args){
        // initialize BookDA
        BookDA bookDA = new BookDA();

        HashMap<String, Book> bookMap = bookDA.getBookMap();

        AuthorDA authorDA = bookDA.getAuthorDA();

        // loop thru the hashmap and print stuff
        for (String isbn : bookMap.keySet()) {
            Book book = bookMap.get(isbn);
            System.out.println(book.getIsbn() + " " + book.getTitle());

            String authorName = book.getAuthor();

            Author author = authorDA.getAuthorByName(authorName);

            // Check if author is null
            if (author != null) {
                // Print author's name and bio
                System.out.println("\t" + authorName + " - " + author.getBio());
            } else {
                // I do not know why this is not mapping correctly for J.R.R. Tolkien
                System.out.println("\tAuthor information is null for: " + authorName);
            }

            System.out.println();
        }
    }
}
