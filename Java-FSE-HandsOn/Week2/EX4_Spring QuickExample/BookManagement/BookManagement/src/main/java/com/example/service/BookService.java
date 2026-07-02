package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Book;
import com.example.repository.BookRepository;

@Service
public class BookService {

    @Autowired
    BookRepository repo;

    public Book saveBook(Book book) {
        return repo.save(book);
    }

    public List<Book> getAllBooks() {
        return repo.findAll();
    }

    public List<Book> getBookByTitle(String title) {
        return repo.findByTitle(title);
    }

    public void deleteBook(int id) {
        repo.deleteById(id);
    }
}