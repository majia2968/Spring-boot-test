package com.testing.springboot.dao;

import com.testing.springboot.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Alimenkou Mikalai
 */
public interface BookDao extends JpaRepository<Book, Long> {
    List<Book> findByAuthor(String author);
}
