package day2.q2;

import java.util.HashMap;
import java.util.Map;

class Book{
    private String bookTitle;
    private String author;
    private String isbn;
    private int numOfCopies;

    public Book(String bookTitle, String author, String isbn, int numOfCopies) {
        this.bookTitle = bookTitle;
        this.author = author;
        this.isbn = isbn;
        this.numOfCopies = numOfCopies;
    }

    public int getNumOfCopies() {
        return numOfCopies;
    }

    public void increaseQuantity(int q){
        numOfCopies+=q;
    }

    public void decreaseQuantity(int q){
        numOfCopies-=q;
    }

    public String display(){
        return bookTitle+"-"+author+"-"+isbn+"-"+numOfCopies;
    }
}

public class BookStore {
    private final Map<String, Book> bookMap = new HashMap<>();

    public void orderBook(String bookTitle, String author, String isbn, int quantity){
        if(bookMap.get(isbn)==null){
            bookMap.put(isbn,new Book(bookTitle,author,isbn,quantity));
        }else{
            bookMap.get(isbn).increaseQuantity(quantity);
        }
    }

    public void sellBook(String bookTitle, String author, String isbn, int quantity){
        if(bookMap.get(isbn)!=null) {
            if(bookMap.get(isbn).getNumOfCopies()>quantity)
                bookMap.get(isbn).decreaseQuantity(quantity);
            else
                bookMap.remove(isbn);
        }
    }

    public void displayBooks() {
        for (int i = 0; i < bookMap.size(); i++) {
            String isbn = (String) bookMap.keySet().toArray()[i];
            System.out.println(bookMap.get(isbn).display());
        }
    }
}
