package day2.q2;

public class BookStoreApplication {
    public static void main(String[] args) {
        BookStore bookStore = new BookStore();

        bookStore.orderBook("abc", "xyz", "123", 200);
        bookStore.orderBook("def", "mno", "456", 500);
        bookStore.orderBook("abc", "xyz", "123", 150);
        bookStore.sellBook("def", "mno", "456", 600);
        bookStore.displayBooks();
    }
}
