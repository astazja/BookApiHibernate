package cz.pacewi.model;

import java.util.List;
import java.util.Optional;

public interface BookService {
    public List<Book> allBooksList();
    public Optional<Book> getBook(Long id);
    public void addBook(Book book);
    public void updateBook(Book book);
    public void removeBook(Long id);


}
