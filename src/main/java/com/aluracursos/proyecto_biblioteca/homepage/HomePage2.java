package com.aluracursos.proyecto_biblioteca.homepage;

import com.aluracursos.proyecto_biblioteca.model.Book;
import com.aluracursos.proyecto_biblioteca.model.BooksData;
import com.aluracursos.proyecto_biblioteca.model.GeneralData;
import com.aluracursos.proyecto_biblioteca.repository.IBookRepository;
import com.aluracursos.proyecto_biblioteca.service.APIConsumption;
import com.aluracursos.proyecto_biblioteca.service.ConvertsData;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class HomePage2 {
    private Scanner keyboard = new Scanner(System.in);
    private APIConsumption consumingAPI = new APIConsumption();
    private ConvertsData converter = new ConvertsData();
    private final String URL_BASE= "https://gutendex.com/books/?";
    private IBookRepository repository;
    private Optional<Book> foundBook;

    public HomePage2(IBookRepository repository) {
        this.repository = repository;
    }

    public void showMenu(){

        var exit = -1;
        while(exit != 0) {
            System.out.println("""
                    \n¡Bienvenido a tu biblioteca virtual!\nIngresa una opción:\n
                    [1] Buscar libro por título.
                    [2] Listar libros registrados.
                    [3] Listar autores registrados.
                    [4] Ver autores vivos dentro de un determinado año.
                    [5] Listar libros por idioma.\n
                    [0] Salir
                    """);

            exit = keyboard.nextInt();
            keyboard.nextLine();

            switch (exit){
                case 1 -> findBookByName();
                case 2 -> registeredBook();
                case 3 -> registeredAuthors();
                case 4 -> authorsLiveIn();
                case 5 -> registeredBookByLenguage();
                case 0 -> System.out.println("¡Gracias por usar nuestra aplicación!\n¡Hasta luego!\n");
                default -> System.out.println("Opción inválida.");
            }
        }
    }

    // Consumo de API.
    private GeneralData getGeneralData(){
        var json = consumingAPI.getData(URL_BASE);
        var data = converter.getData(json, GeneralData.class);

        return data; // va a devolver List<BooksData> booksList
    }

    // Guarda los datos de la API en nuestra base de datos.
    private void saveTheBook (){
        GeneralData book = getGeneralData();

        for(BooksData theBook : book.booksList()){
            Book oneBook = new Book(theBook);
            repository.save(oneBook);
        }
    }

    private void findBookByName() {
        System.out.println("Ingrese el nombre del libro:");
        var userBook = keyboard.nextLine();

        foundBook = repository.findByTitleContainsIgnoreCase(userBook);

        if (foundBook.isPresent()){
            System.out.println("Tu libro es:\n" + foundBook.get());
        } else {
            System.out.println("No encontramos el libro.");
        }
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
