package day3_day4.q4;

/*
Q4. Write an application to read a file data.txt containing data like (actually it is a record of an book consisting of
id, isbn, title, author and price)
file contain data like
books.txt
121:A234:java:raj:456
102:S234:c++:ekta:567
1. read the file and populate records in an LinkedList of books
2. write BookApp
3. write method searchBook(book id)
4. write method sellBook(String isbn, int noOfCopies)
5. write method purchageBook(String isbn,int noOfCopies)
6. if Not sufficient book throw exception NotSufficientBookException
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try(BufferedReader file = new BufferedReader(new FileReader(new File("C:\\Users\\ashrit.bharadwaj\\Desktop\\ASHRIT\\JavaTraining\\kbr_lab_java_core\\Assignment1\\src\\day3\\q4\\data.txt")))){
            String line;
            List<Book> bookList = new ArrayList<>();
            while((line=file.readLine())!=null){
                List<String> tokens = List.of(line.split(":"));
                bookList.add(new Book(Integer.parseInt(tokens.get(0)), tokens.get(1), tokens.get(2), tokens.get(3), Integer.parseInt(tokens.get(4)), 1));
            }
            BookApp bookApp = new BookApp(bookList);
            bookApp.printBooks();
            System.out.println("------------");

            bookApp.purchaseBook("A234",1000);
            bookApp.sellBooks("A234",500);
            bookApp.printBooks();
            System.out.println("-------------");

            bookApp.purchaseBook("b234",10);
            bookApp.sellBooks("S234",20);
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");;
        } catch (IOException e) {
            System.out.println("IO Exception");;
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
