package cz.pacewi.service;

import cz.pacewi.model.Book;
import cz.pacewi.model.BookRepository;
import cz.pacewi.model.BookService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class JpaBookService implements BookService {

    private final BookRepository bookRepository;

    public JpaBookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> allBooksList() {
        return bookRepository.findAll();
    }

    @Override
    public void addBook(Book book) {

    }

    @Override
    public Book bookById(long id) {
        return null;
    }

    @Override
    public void removeBook(Book book) {

    }
}
