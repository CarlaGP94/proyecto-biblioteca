package com.aluracursos.proyecto_biblioteca;

import com.aluracursos.proyecto_biblioteca.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book,Long> {

}
