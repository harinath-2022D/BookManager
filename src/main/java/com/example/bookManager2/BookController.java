package com.example.bookManager2;

import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class BookController {
    private BookService bookService = new BookService();
   // private Book book  = new Book();
    @PostMapping("/add-book")
    public ResponseEntity<String> addbook(@RequestBody Book book){
        String str = bookService.addBook(book);
        return new ResponseEntity<>(str, HttpStatus.CREATED);
    }

    @GetMapping("/get-book-by-id")
    public ResponseEntity<?> getBook(@RequestParam Integer id){
        try{
            Book book = bookService.getBook(id);
            return new ResponseEntity<>(book, HttpStatus.OK);
        }catch(RuntimeException ex){
            return new ResponseEntity<>("book not found with id : "+id, HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/get-book-by-author/{name}")
    public ResponseEntity<?> getBook(@PathVariable String name){
        try{
            Book book = bookService.getBook(name);
            return new ResponseEntity<>(book, HttpStatus.OK);
        }catch (RuntimeException ex){
            return new ResponseEntity<>("Book not found with given author name", HttpStatus.NOT_FOUND);
        }
    }

//    @PutMapping("/update-pages/{id}/{pages}")
//    public ResponseEntity<Book> updateBookPages(@PathVariable Integer id, @PathVariable Integer pages){
//       try{
//           Book book = bookService.updateBookPages(id, pages);
//           return new ResponseEntity<>(book, HttpStatus.OK);
//       }catch (RuntimeException ex){
//           return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
//       }
//    }

    @PutMapping("/update-book-page/{id}/{pages}") //update-book-pages/1/500
    public ResponseEntity<?> updateBookPages(@PathVariable Integer id, @PathVariable Integer pages) {
        try {
            Book book = bookService.updateBookPages(id, pages);
            return new ResponseEntity<>(book, HttpStatus.CREATED);
        } catch(RuntimeException ex) {
            return new ResponseEntity<>("given id is not present", HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/delete-book-by-id")
    public ResponseEntity<?> deleteBook(@RequestParam Integer id){
        bookService.deleteBook(id);
        return new ResponseEntity<>("deletion success", HttpStatus.OK);
    }
}
