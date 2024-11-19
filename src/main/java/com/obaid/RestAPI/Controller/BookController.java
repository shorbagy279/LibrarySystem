package com.obaid.RestAPI.Controller;

import com.obaid.RestAPI.Entity.Book;
import com.obaid.RestAPI.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // Get all books
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    // Get a book by its ID
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable int id) {
        try {
            Book book = bookService.getBookById(id);
            return new ResponseEntity<>(book, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // Add a new book or update the quantity of an existing one
    @PostMapping
    public ResponseEntity<Book> addBooks(@RequestBody Book book) {
        Book updatedBook = bookService.addBooks(book);
        return new ResponseEntity<>(updatedBook, HttpStatus.CREATED);
    }

    // Delete a book by its ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBookById(@PathVariable int id) {
        String result = bookService.deleteById(id);
        if (result.equals("Delete success")) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
    }

}
