package day3_day4.q4;

public class Book {
    private int id;
    private String isbn;
    private String title;
    private String author;
    private int price;
    private int numOfCopies;

    public Book(int id, String isbn, String title, String author, int price, int numOfCopies) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.price = price;
        this.numOfCopies = numOfCopies;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumOfCopies() {
        return numOfCopies;
    }

    public void setNumOfCopies(int numOfCopies) {
        this.numOfCopies = numOfCopies;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Book{");
        sb.append("id=").append(id);
        sb.append(", isbn='").append(isbn).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append(", author='").append(author).append('\'');
        sb.append(", price=").append(price).append('\'');
        sb.append(", numOfCopies=").append(numOfCopies);
        sb.append('}');
        return sb.toString();
    }
}
