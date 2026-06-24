package com.project.Book_Service.Service;

import com.project.Book_Service.Model.Book;
import com.project.Book_Service.Repository.BookRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public void addBooks(Book book) {
        bookRepository.save(book);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public void updateBook(Long id, Book updateBook) {
        var currentBook = bookRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Book not found with ID : " + id));
        currentBook.updateDetails(updateBook);
        bookRepository.save(currentBook);
    }

    public void saveBook(Book book) {
        bookRepository.save(book);
    }


    public Map<String, Object> deleteBook(Long id) {
        var currentBook = bookRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Book not found with id: " + id));
        bookRepository.delete(currentBook);
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("message", "Record deleted successfully!");
        response.put("deletedRecord", currentBook);
        return response;
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Book not found with id : "+ id));
    }
}
