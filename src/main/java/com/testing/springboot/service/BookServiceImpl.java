package com.testing.springboot.service;

import com.testing.springboot.domain.Book;
import com.testing.springboot.dao.BookDao;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import static java.util.stream.Collectors.toList;

/**
 * @author Alimenkou Mikalai
 */
@Service
@Transactional
public class BookServiceImpl implements BookService {
    private final BookDao bookDao;
    private final ConcurrentMap<String, List<Book>> cache = new ConcurrentHashMap<>();

    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public List<Book> addBooks(Map<String, String> books) {
        return books.entrySet().stream()
                .map(entry -> new Book(entry.getKey(), entry.getValue()))
                .map(bookDao::save)
                .collect(toList());
    }

    @Override
    public List<Book> findBooksByAuthor(String author) {
        Assert.hasText(author, "Author is empty!");
        String normalizedAuthor = normalizeAuthorName(author);
        return cache.computeIfAbsent(normalizedAuthor, bookDao::findByAuthor);
    }

    private String normalizeAuthorName(String author) {
        String authorName = StringUtils.normalizeSpace(author);
        return isSingleWord(authorName) ? splitOnFirstAndLastNames(authorName) : authorName;
    }

    private boolean isSingleWord(String correctAuthor) {
        return !StringUtils.containsWhitespace(correctAuthor);
    }

    private String splitOnFirstAndLastNames(String author) {
        String[] parts = StringUtils.splitByCharacterTypeCamelCase(author);
        String firstName = parts[0];
        if (parts.length == 1) {
            return firstName;
        }
        String lastName = StringUtils.substringAfter(author, firstName);
        return String.join(" ", firstName, lastName);
    }

    @Override
    public List<Book> findAllBooks() {
        return bookDao.findAll();
    }
}
