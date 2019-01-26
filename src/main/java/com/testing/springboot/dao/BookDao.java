package com.testing.springboot.dao;

import com.testing.springboot.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookDao extends JpaRepository<Book, Long> {
    List<Book> findByAuthor(String author);
}
