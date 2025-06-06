package com.aluracursos.proyecto_biblioteca;

import com.aluracursos.proyecto_biblioteca.homepage.HomePage;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProyectoBibliotecaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoBibliotecaApplication.class, args);
    }

	@Override
	public void run(String... args) throws Exception {

//		HomePage homePage = new HomePage();
//		homePage.showMenu();
	}
}
