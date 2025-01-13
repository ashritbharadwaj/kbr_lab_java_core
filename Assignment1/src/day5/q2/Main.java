package day5.q2;

public class Main {
    public static void main(String[] args) {
        BookCollection bookCollection = new BookCollection("ABC");
        bookCollection.addBook(new Book(1,"Game Of Thrones","gabe",2000));
        bookCollection.addBook(new Book(4,"Panchatantra","ravi varma", 500));
        bookCollection.addBook(new Book(2,"KGF","Prashant Neel",1000));
        bookCollection.addBook(new Book(3,"Java in Depth","Father of Java", 300));

        System.out.println(bookCollection);

        System.out.println(bookCollection.hasBook(new Book(3,"Java in Depth","Father of Java", 300)));
    }
}
