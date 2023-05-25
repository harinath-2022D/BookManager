package com.example.bookManager2;

public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException(String str){
        super(str);
    }
}
