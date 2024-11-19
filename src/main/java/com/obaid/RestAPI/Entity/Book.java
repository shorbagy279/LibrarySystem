package com.obaid.RestAPI.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Book {
    @Id
    private int id;
    private String title;
    private String author;
    private int inStock = 1;

    public Book() {}

    public Book(int id, String title, String author, double price, int inStock) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.inStock = inStock;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }


    public int getInStock() { return inStock; }
    public void setInStock(int inStock) { this.inStock = inStock; }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", inStock=" + inStock +
                '}';
    }
}
