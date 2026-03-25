package com.example.librarymvc.controller;

import org.springframework.web.bind.annotation.*;

import com.example.librarymvc.model.Book;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LibraryController {

    List<Book> bookList = new ArrayList<>();

    // 1. Welcome message
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to the Online Library System!";
    }

    // 2. Total books
    @GetMapping("/count")
    public int getBookCount() {
        return 120;
    }

    // 3. Sample book price
    @GetMapping("/price")
    public double getPrice() {
        return 499.99;
    }

    // 4. List of book titles
    @GetMapping("/books")
    public List<String> getBooks() {

        List<String> books = new ArrayList<>();
        books.add("Spring Boot in Action");
        books.add("Java Programming");
        books.add("Microservices with Spring");

        return books;
    }

    // 5. Get book details using PathVariable
    @GetMapping("/books/{id}")
    public String getBookById(@PathVariable int id) {
        return "Details of Book ID: " + id;
    }

    // 6. Search book using request parameter
    @GetMapping("/search")
    public String searchBook(@RequestParam String title) {
        return "You searched for book: " + title;
    }

    // 7. Author endpoint
    @GetMapping("/author/{name}")
    public String getAuthor(@PathVariable String name) {
        return "Books written by Author: " + name;
    }

    // 8. Add book (POST request)
    @PostMapping("/addbook")
    public String addBook(@RequestBody Book book) {

        bookList.add(book);
        return "Book added successfully!";
    }

    // 9. View all books
    @GetMapping("/viewbooks")
    public List<Book> viewBooks() {
        return bookList;
    }

}