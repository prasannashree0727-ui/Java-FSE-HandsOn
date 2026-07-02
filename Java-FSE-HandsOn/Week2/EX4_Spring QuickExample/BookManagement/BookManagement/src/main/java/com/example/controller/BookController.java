package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.entity.Book;
import com.example.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService service;

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return service.saveBook(book);
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return service.getAllBooks();
    }

    @GetMapping("/{title}")
    public List<Book> getBookByTitle(@PathVariable String title) {
        return service.getBookByTitle(title);
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable int id) {
        service.deleteBook(id);
        return "Book deleted successfully";
    }
}