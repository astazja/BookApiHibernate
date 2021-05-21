package cz.pacewi.controller;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import cz.pacewi.model.Book;
import cz.pacewi.model.BookService;
import cz.pacewi.service.MemoryBookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @RequestMapping("/helloBook")
    public Book helloBook() {
        return new Book(1l, "9788324631766", "Thinking in Java", "Bruce Eckel", "Helion", "programming");
    }
    @GetMapping("")
    public List<Book> booksList() {
        return bookService.allBooksList();
    }

    @PostMapping("")
    public void addBook(@RequestBody Book book) {
        bookService.addBook(book);
    }

    @GetMapping("/{id}")
    public Book bookById(@PathVariable Long id) {
        return this.bookService.getBook(id).orElseThrow(()->{throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
        });
    }

    @PutMapping("")
    @ResponseBody
    public void putBook(@RequestBody Book book) {
        bookService.updateBook(book);

    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable long id) {
        bookService.removeBook(id);
    }
}
