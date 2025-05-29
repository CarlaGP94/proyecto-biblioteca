package com.aluracursos.proyecto_biblioteca.homepage;

import com.aluracursos.proyecto_biblioteca.model.Books;
import com.aluracursos.proyecto_biblioteca.service.APIConsumption;
import com.aluracursos.proyecto_biblioteca.service.ConvertsData;

import java.util.Scanner;

public class HomePage {
    private Scanner keyboard = new Scanner(System.in);
    private APIConsumption consumingTheAPI = new APIConsumption();
    private ConvertsData converter = new ConvertsData();
    private final String URL_BASE= "https://gutendex.com/books/?";

    public void showMenu(){
        // JSON tal cual lo devuelve la API.
        var json = consumingTheAPI.getData(URL_BASE);
        System.out.println(json);

        // Datos pasados de Json a Java.
        var data = converter.getData(json, Books.class);
        System.out.println(data);
    }


}
