package com.obaid.RestAPI.Service;

import com.obaid.RestAPI.Entity.Book;
import com.obaid.RestAPI.Repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() { return bookRepository.findAll(); }

    public Book getBookById(int id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book with id " + id + " not found"));
    }

    public Book addBooks(Book book) {
        Optional<Book> existingBook = bookRepository.findById(book.getId());
        existingBook.ifPresent(value -> book.setInStock(book.getInStock() + value.getInStock()));
        bookRepository.save(book);
        return book;
    }

    public String deleteById(int id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return "Delete success";
        } else {
            return "Book with ID " + id + " does not exist";
        }
    }
}
