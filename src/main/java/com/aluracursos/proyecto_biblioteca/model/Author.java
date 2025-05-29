package com.aluracursos.proyecto_biblioteca.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record Author(@JsonAlias("name") String completeName,
                     @JsonAlias("birth_year") Integer birthYear,
                     @JsonAlias("death_year") Integer deathYear) {
}
