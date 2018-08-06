package p02_book_shop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String author = reader.readLine();
        String title = reader.readLine();
        double price = Double.valueOf(reader.readLine());

        try {
            Book book = new Book(author, title, price);
            GoldenEditionBook goldenEditionBook = new GoldenEditionBook(author, title, price);

            System.out.println(book.toString());
            System.out.println(goldenEditionBook.toString());
        }
        catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
        }
    }
}