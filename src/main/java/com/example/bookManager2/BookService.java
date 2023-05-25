package com.example.bookManager2;

import java.util.Optional;

public class BookService {
    private BookRepository bookRepository = new BookRepository();
    public String addBook(Book book) {
        bookRepository.addBook(book);
        return new String("book added succesfully");
    }


    public Book getBook(Integer id) throws BookNotFoundException{
        Optional<Book> optionalBook = bookRepository.getBook(id);
        if(optionalBook.isEmpty()){
            throw new BookNotFoundException("Book not fount with given id");
        }
        return optionalBook.get();
    }

    public Book getBook(String name) throws BookNotFoundException{
        Optional<Book> optionalBook = bookRepository.getBook(name);
        if(optionalBook.isPresent()){
            return optionalBook.get();
        }
        throw  new BookNotFoundException("Book not found with given author name");
    }

//    public Book updateBookPages(Integer id, Integer pages) throws RuntimeException{
//       Book book = getBook(id);
//       book.setPages(pages);
//       bookRepository.updateBookPages(book);
//       return book;
//    }

    public Book updateBookPages(Integer id, Integer pages) throws BookNotFoundException {
        Book book = getBook(id);
        book.setPages(pages);
        bookRepository.update(book);
        return book;
    }

    public void deleteBook(Integer id) {
        bookRepository.deleteBook(id);
    }
}
