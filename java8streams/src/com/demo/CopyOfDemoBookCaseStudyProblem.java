package com.demo;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;



public class CopyOfDemoBookCaseStudyProblem {

	public static void main(String[] args) {

		List<Book> allBooks = loadAllBooks();

		// 1. Find books with more then 400 pages
		List<Book>booksMoreThen400Pages=allBooks.stream()
				.filter(b-> b.getPages()>400).toList();

		System.out.println("Answer 1");
		booksMoreThen400Pages.forEach(System.out::println);
		
		// 2. Find all books that are java books and more then 400 pages
		System.out.println("\nAnswer 2");
		booksMoreThen400Pages.stream().filter(b->b.getSubject().equals(Subject.JAVA)).forEach(System.out::println);
		
		// 3. We need the top three longest books
		System.out.println("\nAnswer 3");
		allBooks.stream().sorted(Comparator.comparing(Book::getPages).reversed()).limit(3).forEach(System.out::println);
	
		// 4. We need from the fourth to the last longest books
		System.out.println("\nAnswer 4");
		allBooks.stream().sorted(Comparator.comparing(Book::getPages).reversed()).skip(3).forEach(System.out::println);

		// 5. We need to get all the publishing years
		System.out.println("\nAnswer 5");
		allBooks.stream().map(Book::getYear).distinct().forEach(System.out::println);

		// 6. We need all the authors names who have written a book
		List<Author> authors=allBooks.stream().flatMap(b->b.getAuthors().stream()).toList();
		System.out.println("\nAnswer 6");
		authors.stream().map(Author::getName).distinct().forEach(System.out::println);
		
		// We need all the origin countries of the authors
		System.out.println("\nAnswer 7");
		authors.stream().map(Author::getCountry).distinct().forEach(System.out::println);

		// We want the most recent published book.
		System.out.println("\nAnswer 8");
		allBooks.stream().max(Comparator.comparing(Book::getYear)).ifPresent(System.out::println);

		// We want to know if all the books are written by more than one author
		System.out.println("\nAnswer 9");
		boolean allWrittenByMoreThanOneAuthor=allBooks.stream().allMatch(b->b.getAuthors().size()>1);
		System.out.println(allWrittenByMoreThanOneAuthor);

		// We want one of the books written by more than one author. (findFirst)

		System.out.println("\nAnswer 10");
		allBooks.stream().filter(b->b.getAuthors().size()>1).findFirst().ifPresent(System.out::println);
	
		// We want one of the books written by more than one author. (findAny)
		System.out.println("\nAnswer 11");
		allBooks.stream().filter(b->b.getAuthors().size()>1).findAny().ifPresent(System.out::println);
		
		// We want the total number of pages published.
		System.out.println("\nAnswer 12");
		int totalNumberOfPages= allBooks.stream().parallel().mapToInt(Book::getPages).reduce(0, Integer::sum); //allBooks.stream().mapToInt(Book::getPages).sum();
		System.out.println(totalNumberOfPages);

	
		// We want to know how many pages the longest book has.
		System.out.println("\nAnswer 13");
		int longestBookPage=allBooks.stream().mapToInt(Book::getPages).max().orElse(0);
		System.out.println(longestBookPage);

	
		// We want the average number of pages of the books
		System.out.println("\nAnswer 14");
		double averageNumberOfPages=allBooks.stream().mapToInt(Book::getPages).average().orElse(0.0);
		System.out.println(averageNumberOfPages);
	
		// We want all the titles of the books
		System.out.println("\nAnswer 15");
		allBooks.stream().map(Book::getTitle).forEach(System.out::println);

	
		// We want the book with the higher number of authors?
		System.out.println("\nAnswer 16");
		allBooks.stream().max(new Comparator<Book>(){
			@Override
			public int compare(Book o1, Book o2) {
				return o1.getAuthors().size()-o2.getAuthors().size();
			}
		}.thenComparing(Book::getTitle)).ifPresent(System.out::println);
		//allBooks.stream().max(((Book o1, Book o2) -> o1.getAuthors().size()-o2.getAuthors().size())).ifPresent(System.out::println);

	
		// We want a Map of book per year.
		System.out.println("\nAnswer 17");
		Map<Integer, List<Book>> booksPerYear=allBooks.stream().collect(Collectors.groupingBy(Book::getYear));
		booksPerYear.forEach((year, books)->System.out.println(year+" : "+books));

		

		// We want to count how many books are published per year.
		System.out.println("\nAnswer 18");
		booksPerYear.forEach((year, books)->System.out.println(year+" : "+books.size()));

	

	}

	private static List<Book> loadAllBooks() {
		List<Book> books = new ArrayList<Book>();
		List<Author> authors1 = Arrays.asList(new Author("raj", "gupta", "in"),
				new Author("ekta", "gupta", "in"));

		List<Author> authors2 = List.of(new Author("raj", "gupta", "in"));

		List<Author> authors3 = Arrays.asList(new Author("gunika", "gupta", "us"),
				new Author("keshav", "gupta", "us"));

		books.add(new Book("java", authors1, 400, Subject.JAVA, 2000, "1213"));
		books.add(new Book("python", authors2, 479, Subject.JAVA, 2007, "1218"));
		books.add(new Book("Mgt", authors3, 600, Subject.DOT_NET, 2000, "1293"));

		return books;
	}

}
