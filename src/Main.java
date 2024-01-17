import classes.Customers;
import classes.Order;
import classes.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    static Predicate<Product> isMoreThan100 = num -> num.getPrice() > 100;
    static Predicate<Product> isBook = prod -> prod.getCategory().equals("Books");
    static Predicate<Product> isBaby = prod -> prod.getCategory().equals("Baby");
    static Predicate<Product> isBoys = prod -> prod.getCategory().equals("Boys");
    static Predicate<Order> isTier2 = order -> order.getCustomers().getTier().equals(2);
    static Predicate<Order> isBefore = order -> order.getOrderDate().isBefore(LocalDate.parse("2021-04-01"));
    static Predicate<Order> isAfter = order -> order.getOrderDate().isAfter(LocalDate.parse("2021-02-01"));


    public static void main(String[] args) {


        Product Book = new Product("Nome libro", "Books", 25.2);
        Product Book1 = new Product("Nome libro1", "Books", 25.2);
        Product Book2 = new Product("Nome libro2", "Books", 24.2);
        Product Book3 = new Product("Nome libro3", "Books", 45.2);
        Product BookExpensive = new Product("Nome libro4", "Books", 125.2);
        Product Boy = new Product("Nome boy", "Books", 100.);
        Product Boy1 = new Product("Boys1", "Boys", 100.);
        Product Boy2 = new Product("Boys2", "Boys", 100.);
        Product Boy3 = new Product("Boys3", "Boys", 100.);
        Product BoyExpensive = new Product("Boys4", "Boys", 100.);
        Product Baby = new Product("Nome baby", "Baby", 25.2);
        Product Baby1 = new Product("Nome baby1", "Baby", 25.2);
        Product Baby2 = new Product("Nome baby2", "Baby", 24.2);
        Product Baby3 = new Product("Nome baby3", "Baby", 45.2);
        Product BabyExpensive = new Product("Nome baby4", "Baby", 125.2);
        Customers Customers1 = new Customers("Marco", 2);
        Customers Customers2 = new Customers("Luca", 1);
        Customers Customers3 = new Customers("Marta", 3);
        Customers Customers4 = new Customers("Giovanni", 2);

        Product[] arrayProducts = new Product[0];
        arrayProducts = new Product[]{
                Book, Book1, Book2, Book3, BookExpensive,
                Boy, Boy1, Boy2, Boy3, BoyExpensive,
                Baby, Baby1, Baby2, Baby3, BabyExpensive
        };

        List<Product> Products = new ArrayList<>(Arrays.asList(arrayProducts));

        Customers[] arrayCustumers = new Customers[0];
        arrayCustumers = new Customers[]{
                Customers1, Customers2, Customers3, Customers4
        };
        List<Customers> Custumers = new ArrayList<>(Arrays.asList(arrayCustumers));

        Order Order1 = new Order("Complete", LocalDate.parse("2021-02-28"), LocalDate.parse("2021-03-31"), Products, Customers1);
        Order Order2 = new Order("Complete", LocalDate.parse("2021-02-28"), LocalDate.parse("2021-03-31"), Products, Customers2);
        Order Order3 = new Order("Complete", LocalDate.parse("2021-02-28"), LocalDate.parse("2021-03-31"), Products, Customers3);
        Order Order4 = new Order("Complete", LocalDate.parse("2021-10-31"), LocalDate.parse("2021-03-31"), Products, Customers4);


        Order[] arrayOrder = new Order[0];
        arrayOrder = new Order[]{
                Order1, Order2, Order3, Order4,
        };

        List<Order> Orders = new ArrayList<>(Arrays.asList(arrayOrder));
        System.out.println("--------------------------------------------------");
        System.out.println("Esercizio 1");

        bookFilter(Products).forEach(book -> System.out.println(book.getName()));
        System.out.println("--------------------------------------------------");

        System.out.println("Esercizio 2");

        babyFilter(Products).forEach(baby -> System.out.println(baby.getName()));
        System.out.println("--------------------------------------------------");

        System.out.println("Esercizio 3");
        System.out.println(boysFilter(Products));
        System.out.println("--------------------------------------------------");

        System.out.println("Esercizio 4");
        onlyTier2(Orders).forEach(System.out::println);


    }

    //*************************funzioni x esercizio1**********************
    public static List<Product> bookFilter(List<Product> Products) {
        return Products.stream().filter(isBook).filter(isMoreThan100).toList();
    }

    //*************************funzioni x esercizio2**********************
    public static List<Product> babyFilter(List<Product> Products) {
        return Products.stream().filter(isBaby).toList();
    }
    //*************************funzioni x esercizio3**********************

    public static List<Product> boysFilter(List<Product> Products) {
        return Products.stream().filter(isBoys).peek(product -> product.setPrice(product.getPrice() * 0.9)).toList();


    }

    //*************************funzioni x esercizio4**********************
    public static List<Order> onlyTier2(List<Order> Orders) {
        return Orders.stream().filter(isTier2).filter(isAfter.and(isBefore)).toList();
    }
}