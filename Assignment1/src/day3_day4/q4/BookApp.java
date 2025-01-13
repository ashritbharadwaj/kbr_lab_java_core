package day3_day4.q4;

import java.util.List;
import java.util.Objects;

class BookNotFound extends RuntimeException{
    BookNotFound(String msg){
        super(msg);
    }
}
class NotSufficientBooks extends RuntimeException{

}

public class BookApp {
    List<Book> books;

    public BookApp(List<Book> books) {
        this.books = books;
    }

    public Book searchBook(String isbn) {
        for(Book book:books){
            if(Objects.equals(book.getIsbn(), isbn)){
                return book;
            }
        }
        return null;
    }

    public void purchaseBook(String isbn, int numOfCopies){
        Book book = searchBook(isbn);
        if(book!=null)
            book.setNumOfCopies(book.getNumOfCopies()+numOfCopies);
        else throw new BookNotFound("Book Not Found with isbn:" + isbn);
    }

    public void sellBooks(String isbn, int numOfCopies){
        Book book = searchBook(isbn);
        if(book!=null){
            if(numOfCopies<=book.getNumOfCopies()) {
                book.setNumOfCopies(book.getNumOfCopies() - numOfCopies);
            }
            else throw new NotSufficientBooks();
        }
        else throw new BookNotFound("Book Not Found with isbn:" + isbn);
    }

    public void printBooks(){
        for(Book book:books){
            System.out.println(book);
        }
    }
}
