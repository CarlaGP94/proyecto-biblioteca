package com.aluracursos.proyecto_biblioteca.homepage;

import com.aluracursos.proyecto_biblioteca.service.APIConsumption;
import com.aluracursos.proyecto_biblioteca.service.ConvertsData;

import java.util.Scanner;

public class HomePage2 {
    private Scanner keyboard = new Scanner(System.in);
    private APIConsumption consumingAPI = new APIConsumption();
    private ConvertsData converter = new ConvertsData();
    private final String URL_BASE= "https://gutendex.com/books/?";

    public void showMenu(){

        var exit = -1;
        while(exit != 0) {
            System.out.println("¡Bienvenido a tu biblioteca virtual!\nIngresa una opción:\n" +
                    "[1] Buscar libro por título." +
                    "[2] Listar libros registrados." +
                    "[3] Listar autores registrados." +
                    "[4] Ver autores vivos dentro de un determinado año." +
                    "[5] Listar libros por idioma.\n" +
                    "[0] Salir");

            exit = keyboard.nextInt();
            keyboard.nextLine();

            switch (exit){
                case 1 -> findBookByName();
                case 2 -> registeredBook();
                case 3 -> registeredAuthors();
                case 4 -> authorsLiveIn();
                case 5 -> registeredBookByLenguage();
                case 0 -> System.out.println("¡Gracias por usar nuestra aplicación!\n¡Hasta luego!");
                default -> System.out.println("Opción inválida");
            }
        }
    }

    private void findBookByName() {
    }

    private void registeredBook() {
    }

    private void registeredAuthors() {
    }

    private void authorsLiveIn() {
    }

    private void registeredBookByLenguage() {
    }
}
