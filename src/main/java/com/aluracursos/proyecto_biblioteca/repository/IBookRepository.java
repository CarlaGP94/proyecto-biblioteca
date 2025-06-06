package com.aluracursos.proyecto_biblioteca.repository;

import com.aluracursos.proyecto_biblioteca.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IBookRepository extends JpaRepository<Book,Long> {

    Optional<Book> findByTitleContainsIgnoreCase(String userBook);
}
