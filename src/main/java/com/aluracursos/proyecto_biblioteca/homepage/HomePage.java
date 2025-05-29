package com.aluracursos.proyecto_biblioteca.homepage;

import com.aluracursos.proyecto_biblioteca.model.Books;
import com.aluracursos.proyecto_biblioteca.model.GeneralData;
import com.aluracursos.proyecto_biblioteca.service.APIConsumption;
import com.aluracursos.proyecto_biblioteca.service.ConvertsData;

import java.util.*;
import java.util.stream.Collectors;

public class HomePage {
    private Scanner keyboard = new Scanner(System.in);
    private APIConsumption consumingAPI = new APIConsumption();
    private ConvertsData converter = new ConvertsData();
    private final String URL_BASE= "https://gutendex.com/books/?";

    public void showMenu(){
        // JSON tal cual lo devuelve la API.
        var json = consumingAPI.getData(URL_BASE);
        System.out.println(json);
        System.out.println("");

        // Datos pasados de Json a Java.
        var data = converter.getData(json, GeneralData.class);
        data.booksList().stream()
                .limit(5)
                .forEach(System.out::println);
        System.out.println("");

        // Top 10 de los más descargados
        System.out.println("Top 10 de los libros más descargados:");
        data.booksList().stream()
                .sorted(Comparator.comparing(Books::downloadCount).reversed())
                .limit(10)
                .map(b -> b.title().toUpperCase())
                .forEach(System.out::println);

        // Filtro para buscar un libro.
        System.out.println("\nIngresa el nombre del libro:");
        var userBook = keyboard.next();

        Optional<Books> foundBook = data.booksList().stream()
                .filter(b -> b.title().toUpperCase().contains(userBook.toUpperCase()))
                .findFirst();

        if (foundBook.isPresent()){
            System.out.println("Tu libro es:\n" + foundBook);
        } else {
            System.out.println("No encontramos el libro.");
        }

        // Estadística
        DoubleSummaryStatistics est = data.booksList().stream()
                .filter(b -> b.downloadCount() > 0.0)
                .collect(Collectors.summarizingDouble(Books::downloadCount));
        System.out.println("Promedio de descargas: " + est.getAverage());
    }


}
