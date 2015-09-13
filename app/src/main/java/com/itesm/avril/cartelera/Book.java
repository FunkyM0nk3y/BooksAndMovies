package com.itesm.avril.cartelera;

/**
 * Created by FunkyM0nk3y on 9/12/15.
 */
public class Book {
    private String title, authors, publisher, isbn, pages, price;

    public Book(String title, String authors, String publisher, String isbn, String pages, String price) {
        super();
        this.title = title;
        this.authors = authors;
        this.publisher = publisher;
        this.isbn = isbn;
        this.pages = pages;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthors() {
        return authors;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getPrice() {
        return price;
    }

    public String getPages() {
        return pages;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
