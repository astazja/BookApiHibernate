package cz.pacewi.model;

import java.util.List;

public interface BookService {
    public List<Book> allBooksList();
    public void addBook(Book book);
    public Book bookById(long id);
    public void removeBook(Book book);
}
