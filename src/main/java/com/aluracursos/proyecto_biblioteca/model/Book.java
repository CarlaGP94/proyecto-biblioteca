package com.aluracursos.proyecto_biblioteca.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "book")
public class Book {
    private String title;
    private List<AuthorsData> authorList;
    private List<String> languagesList;
    private Double downloadCount;
}
