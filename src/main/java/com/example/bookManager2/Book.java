package com.example.bookManager2;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book {
    private Integer id;
    private String book_name;
    private String author_name;
    private Integer pages;

    public Book() {
    }

    public Book(Integer id, String book_name, String author_name, Integer pages) {
        this.id = id;
        this.book_name = book_name;
        this.author_name = author_name;
        this.pages = pages;
    }
}
