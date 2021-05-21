package cz.pacewi.service;

import cz.pacewi.model.Book;
import cz.pacewi.model.BookRepository;
import cz.pacewi.model.BookService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Book bookById(Long id) {
        return null;
    }

    @Override
    public Optional<Book> getBook(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public void addBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void removeBook(Book book) {
        bookRepository.delete(book);
    }

    @Override
    public void updateBook(Book book) {
        bookRepository.save(book);
    }
}
