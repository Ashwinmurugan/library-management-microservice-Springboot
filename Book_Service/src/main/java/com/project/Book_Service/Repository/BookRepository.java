package com.project.Book_Service.Repository;

import com.project.Book_Service.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
