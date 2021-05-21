package cz.pacewi.service;

import cz.pacewi.model.Book;
import cz.pacewi.model.BookService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemoryBookService implements BookService {
    private List<Book> bookList;
    private static Long nextId = 4L;

    public MemoryBookService(List<Book> bookList) {
        this.bookList = bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public static Long getNextId() {
        return nextId;
    }

    public static void setNextId(Long nextId) {
        MemoryBookService.nextId = nextId;
    }

    public MemoryBookService() {
        bookList = new ArrayList<>();
        bookList.add(new Book(1L, "9788324631766", "Thiniking	in	Java", "Bruce	Eckel", "Helion", "programming"));
        bookList.add(new Book(2L, "9788324627738", "Rusz	glowa	Java.", "Sierra	Kathy,	Bates	Bert", "Helion", "programming"));
        bookList.add(new Book(3L, "9780130819338", "Java	2.	Podstawy", "Cay	Horstmann,	Gary	Cornell", "Helion", "programming"));
    }

    public List<Book> allBooksList() {
        return bookList;
    }
    public void addBook(Book book) {
        book.setId(nextId++);
        bookList.add(book);
    }
    public Book bookById(long id) {
        return bookList.stream().filter(book -> book.getId() == id).findFirst().orElse(null);
    }
    public void removeBook(Book book) {
        bookList.remove(book);
    }
}
