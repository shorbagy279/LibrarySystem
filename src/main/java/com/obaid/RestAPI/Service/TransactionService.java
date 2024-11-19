package com.obaid.RestAPI.Service;

import com.obaid.RestAPI.Entity.Book;
import com.obaid.RestAPI.Entity.Transaction;
import com.obaid.RestAPI.Entity.User;
import com.obaid.RestAPI.Repository.BookRepository;
import com.obaid.RestAPI.Repository.TransactionRepository;
import com.obaid.RestAPI.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import static java.util.Collections.max;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;


    public TransactionService(TransactionRepository transactionRepository, UserRepository userRepository, BookRepository bookRepository) {
        this.transactionRepository = transactionRepository;
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Transaction addTransaction(Transaction transaction) {
        User user = transaction.getUser();
        Book book = transaction.getBook();

        // Validate user
        if (!userRepository.existsById(user.getId())) {
            throw new RuntimeException("User with ID " + user.getId() + " does not exist. Please sign up first.");
        }

        // Validate book
        if (!bookRepository.existsById(book.getId())) {
            throw new RuntimeException("Book with ID " + book.getId() + " not found or unavailable.");
        }

        Book foundBook = bookRepository.findById(book.getId())
                .orElseThrow(() -> new RuntimeException("Book not found"));


        // Update book stock
            foundBook.setInStock(foundBook.getInStock() - 1);
            bookRepository.save(foundBook);

        return transactionRepository.save(transaction);
    }




    public Transaction getTransactionById(int id) {
        return transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction with id " + id + " not found"));
    }

    // get all transaction for someone
    public List<Transaction> getTransactionsByUserId(int userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User with id " + userId + " not found"));
        return transactionRepository.findByUser(user);
    }

    public Transaction returnBook(int transactionId) {
        Transaction transaction = transactionRepository.findById(transactionId)
                .orElseThrow(() -> new RuntimeException("Transaction with ID " + transactionId + " not found"));

        Book book = transaction.getBook();
        book.setInStock(book.getInStock() + 1);
        bookRepository.save(book);
        transaction.setStatus("Completed");
        transaction.setReturnDate(LocalDate.now());
        transactionRepository.save(transaction);
        return transaction;
    }

}