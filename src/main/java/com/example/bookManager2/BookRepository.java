package com.example.bookManager2;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class BookRepository {
    private Map<Integer,Book> db = new HashMap<>();

    public void addBook(Book book) {
        db.put(book.getId(), book);
    }

    public Optional<Book> getBook(Integer id) {
        if (db.containsKey(id)) {
            Book returnbook = db.get(id);
            return Optional.of(returnbook);
        }
        return Optional.empty();
    }
    public Optional<Book> getBook(String author_name){
        for(Integer id : db.keySet()){
            String name = db.get(id).getAuthor_name();
            if(author_name.equals(name)){
                return Optional.of(db.get(id));
            }
        }
        return Optional.empty();
    }

    public void update(Book book) {
//        Book book  = db.get(id);
//        book.setPages(pages);
//        return Optional.of(book);
        db.put(book.getId(), book);
    }

    public void deleteBook(Integer id) {

        db.remove(id);
    }
}
