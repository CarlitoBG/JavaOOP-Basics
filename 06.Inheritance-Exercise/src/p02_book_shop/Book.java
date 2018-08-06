package p02_book_shop;

public class Book {

    private static final String AUTHOR_ERROR_MESSAGE = "Author not valid!";
    private static final String TITLE_ERROR_MESSAGE = "Title not valid!";
    private static final String PRICE_ERROR_MESSAGE = "Price not valid!";

    private String author;
    private String title;
    private double price;

    Book(String author, String title, double price) {
        this.setAuthor(author);
        this.setTitle(title);
        this.setPrice(price);
    }

    private String getAuthor() {
        return this.author;
    }

    private void setAuthor(String author) {
        String[] authorTokens = author.split("\\s+");
        if (authorTokens.length == 2 && Character.isDigit(authorTokens[1].charAt(0))){
            throw new IllegalArgumentException(AUTHOR_ERROR_MESSAGE);
        }
        this.author = author;
    }

    private String getTitle() {
        return this.title;
    }

    private void setTitle(String title) {
        if (title.length() < 3){
            throw new IllegalArgumentException(TITLE_ERROR_MESSAGE);
        }
        this.title = title;
    }

    protected double getPrice() {
        return this.price;
    }

    private void setPrice(double price) {
        if (price < 1){
            throw new IllegalArgumentException(PRICE_ERROR_MESSAGE);
        }
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("Type: %s%nTitle: %s%nAuthor: %s%nPrice: %s%n",
                this.getClass().getSimpleName(), this.getTitle(), this.getAuthor(), this.getPrice());
    }
}