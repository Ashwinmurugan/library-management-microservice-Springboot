package com.project.rental_Service.Service;

import com.project.rental_Service.Client.BookClient;
import com.project.rental_Service.DTO.BookDTO;
import com.project.rental_Service.DTO.BorrowRequestDTO;
import com.project.rental_Service.Model.Rental;
import com.project.rental_Service.Repository.RentalRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Data
public class RentalService {

    @Autowired
    private RentalRepository rentalRepository;

    @Autowired
    private BookClient bookClient;

    public String borrowBook(BorrowRequestDTO request) {

        BookDTO book = bookClient.getBookById(request.getBookId());
        if (book == null) {
            throw new EntityNotFoundException("The requested book does not exists!!");
        }
        if (book.getAvailableCopies() <= 0) {
            return "Book Availability is not there currently , Please Try again later!!";
        }

        String feignResponse = bookClient.decreaseStock(request.getBookId());

        if (feignResponse.contains("SUCCESSFULLY BORROWED")) {
            Rental rentalBook = new Rental();
            rentalBook.setBookId(request.getBookId());
            rentalBook.setUserId(request.getUserId());
            rentalBook.setBorrowDate(LocalDate.now());
            rentalBook.setReturnDate(null);
            rentalBook.setStatus("ACTIVE");
            rentalRepository.save(rentalBook);

            System.out.println("==========================================");
            System.out.println(book.getBookTitle() + " borrowed successfully !!");
            System.out.println("==========================================");
            return "Book Borrowed Successfully Enjoy Reading !!";
        }
        return "!!! --- Failed to complete --- !!!";
    }

    public Optional<Rental> getrentalbooksbyId(Long id) {
        return rentalRepository.findById(id);
    }

    public List<Rental> getActiveRentals(String status) {
        return rentalRepository.findByStatus(status);
    }

    public String returnBook(Long id) {
        Rental returnbook = rentalRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Rental ID not found!"));

        if ((returnbook.getStatus()).equalsIgnoreCase("RETURNED")) {
            return "This book has already been returned!";
        }

        bookClient.increaseStock(returnbook.getBookId());
        returnbook.setStatus("RETURNED");
        returnbook.setReturnDate(LocalDate.now());
        rentalRepository.save(returnbook);
        return "BOOK RETURNED SUCCESSFULLY THANKS!!!";
    }
}
