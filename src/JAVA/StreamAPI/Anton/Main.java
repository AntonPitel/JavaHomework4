package JAVA.StreamAPI.Anton;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        //Sum of all numbers between 1 and 10000 that are dividable by 3 and 5 but not dividable by 7
         Stream.iterate(1, A -> A + 1)
                 .limit(10000)
                 .filter(A -> A % 3 == 0 && A % 5 == 0 && A % 7 != 0)
                 .forEach(A -> System.out.println(A));

         //First 100 even numbers that are not dividable by 8
         Stream.iterate(0, A -> A + 2)
                 .limit(100)
                 .filter(A -> A % 8 != 0)
                 .forEach(A -> System.out.println(A));
         //ArrayList of books with names and price
        List<Book> List = new ArrayList<>();
        Book book1 = new Book("Oasis", 5);
        Book book2 = new Book("PearlJam", 10);
        Book book3 = new Book("RHCP", 15);
        Book book4 = new Book("RATM", 20);
        Book book5 = new Book("ArcticMonkeys", 25);
        Book book6 = new Book("Metallica", 30);
        Book book7 = new Book("Audioslave", 35);
        Book book8 = new Book("SystemofaDown", 740);
        Book book9 = new Book("R.E.M", 145);
        Book book10 = new Book("Nirvana", 250);
        Book book11 = new Book("FooFighters", 355);
        Book book12 = new Book("TheProdigy", 460);

        List.add(book1);
        List.add(book2);
        List.add(book3);
        List.add(book4);
        List.add(book5);
        List.add(book6);
        List.add(book7);
        List.add(book8);
        List.add(book9);
        List.add(book10);
        List.add(book11);
        List.add(book12);

        //Printed names of books alphabetical that cost less then 100
        List.stream()
                .filter(A -> A.getPrice() < 100)
                .sorted(Comparator.comparing(Book::getName))
                .forEach(A -> System.out.println(A.getName()));

        //How many books have name shorter than 5 characters
        System.out.println(List.stream()
                .filter(A -> A.getName().length() < 5)
                .count()
        );

        //Average price of the book in the List
        OptionalDouble price = List.stream()
                .mapToDouble(Book::getPrice)
                .average();
        System.out.println(price.getAsDouble());

        //If all books in List are cheaper than 500
        var price2 = List.stream()
                .allMatch(A -> A.getPrice() < 500);
        System.out.println(price2);
    }

}
