package cz.pacewi.controller;

import cz.pacewi.model.Book;
import cz.pacewi.model.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin/books")
public class ManageBookController {

    private final BookService bookService;

    public ManageBookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/all")
    public String showBooks(Model model) {
        List<Book> books = bookService.allBooksList();
        model.addAttribute("books", books);
        return "/book/all";
    }
    @GetMapping("/add")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        return "/book/add";
    }
    @PostMapping("/add")
    public String saveBook(@Valid Book book, BindingResult result) {
        if(result.hasErrors()) {
            return "/book/add";
        }
        bookService.addBook(book);
        return "redirect:/admin/books/all";
    }

}
