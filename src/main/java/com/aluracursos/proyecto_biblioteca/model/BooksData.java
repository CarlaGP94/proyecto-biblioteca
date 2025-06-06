package com.aluracursos.proyecto_biblioteca.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)

public record BooksData(@JsonAlias("title") String title,
                        @JsonAlias("authors") List<AuthorsData> authorList,
                        @JsonAlias("languages") List<String> languagesList,
                        @JsonAlias("download_count") Double downloadCount) {
}
