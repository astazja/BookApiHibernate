package cz.pacewi.controller;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import cz.pacewi.model.Book;
import cz.pacewi.model.BookService;
import cz.pacewi.service.MemoryBookService;
import org.springframework.web.bind.annotation.*;

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
    @JsonDeserialize(as = BookController.class)
    public void addBook(@RequestBody Book book) {
        bookService.addBook(book);
    }
    @GetMapping("/{id}")
    public Book bookById(@PathVariable("id") long id) {
        return bookService.allBooksList().stream().filter(book -> book.getId() == id).findFirst().orElse(null);
    }
    @PutMapping("/{id}")
    @JsonDeserialize(as = BookController.class)
    public void putBook(@PathVariable long id, @RequestBody Book book) {
        Book bookToChange = bookService.bookById(id);
        bookService.removeBook(bookToChange);
        bookService.addBook(book);
    }
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable long id, @RequestBody Book book) {
        bookService.removeBook(bookService.bookById(id));
    }
}
