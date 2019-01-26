package com.testing.springboot.web;

import com.testing.springboot.model.Book;
import com.testing.springboot.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class BookRestController {
    private final BookService bookService;

    @RequestMapping(method = RequestMethod.GET, path = "/books")
    public List<Book> findBooksByAuthor(@RequestParam String author) {
        return bookService.findBooksByAuthor(author);
    }
}
