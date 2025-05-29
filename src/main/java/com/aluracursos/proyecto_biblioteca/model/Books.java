package com.aluracursos.proyecto_biblioteca.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public record Books(@JsonAlias("title") String title,
                    @JsonAlias("authors") String author,
                    @JsonAlias("subjects") String gender,
                    @JsonAlias("languages") String languages) {
}
