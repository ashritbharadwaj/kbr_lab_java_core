package day5.q2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.PriorityQueue;

public class BookCollection {
    private final String owner;
    ArrayList<Book> books = new ArrayList<>();

    public BookCollection(String owner) {
        this.owner = owner;
    }

    public void addBook(Book book){
        books.add(book);
        Collections.sort(books);
    }

    public int hasBook(Book b){
        int i=-1;
        for(Book book:books){
            i++;
            if(book.equals(b)) return i;
        }
        return -1;

    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BookCollection{");
        sb.append("owner='").append(owner).append('\n');
        sb.append(", books=").append("\n");
        for(Book book:books){
            sb.append("[");
            sb.append("id=").append(book.getId());
            sb.append(", title='").append(book.getTitle()).append('\'');
            sb.append(", author='").append(book.getAuthor()).append('\'');
            sb.append(", price=").append(book.getPrice()).append("]\n");
        }
        sb.append('}');
        return sb.toString();
    }
}
