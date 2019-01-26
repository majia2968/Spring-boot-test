package com.testing.springboot.service;

import com.testing.springboot.model.Book;

import java.util.List;
import java.util.Map;

public interface BookService {
    List<Book> addBooks(Map<String, String> books);

    List<Book> findBooksByAuthor(String author);

    List<Book> findAllBooks();
}
