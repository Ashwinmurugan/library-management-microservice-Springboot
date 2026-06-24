package com.project.Book_Service.Controller;

import com.project.Book_Service.Model.Book;
import com.project.Book_Service.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/addbook")
    public String addBook(@RequestBody Book book) {
        bookService.addBooks(book);
        return "success";
    }

    @GetMapping("/getbooks")
    public List<Book> getBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/getbooks/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    @PutMapping("/updatebook/{id}")
    public String updateBook(@PathVariable Long id, @RequestBody Book book) {
        bookService.updateBook(id, book);
        return "Update Successfully";
    }


    @DeleteMapping("/deletebook/{id}")
    public ResponseEntity<Map<String, Object>> deleteBook(@PathVariable Long id) {
        Map<String, Object> response = bookService.deleteBook(id);
        return ResponseEntity.ok(response);
    }


        @PutMapping("/updatebook/{id}/borrow")
    public ResponseEntity<String> decreaseStock(@PathVariable Long id) {
        Book book = bookService.getBookById(id);

        if (book.getAvailableCopies() <= 0) {
            return ResponseEntity.badRequest().body("OUT_OF_STOCK!");
        } else {
            book.setAvailableCopies(book.getAvailableCopies() - 1);
            bookService.saveBook(book);
            return ResponseEntity.ok("SUCCESSFULLY BORROWED");
        }
    }

    @PutMapping("/updatebook/{id}/return")
    public ResponseEntity<String> increaseStock(@PathVariable Long id) {
        Book book = bookService.getBookById(id);
        book.setAvailableCopies(book.getAvailableCopies() + 1);
        bookService.saveBook(book);
        return ResponseEntity.ok("SUCCESSFULLY RETURNED");
    }


}
