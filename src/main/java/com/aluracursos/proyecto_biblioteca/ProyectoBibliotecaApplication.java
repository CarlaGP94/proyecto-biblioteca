package com.aluracursos.proyecto_biblioteca;

import com.aluracursos.proyecto_biblioteca.homepage.HomePage;
import com.aluracursos.proyecto_biblioteca.homepage.HomePage2;
import com.aluracursos.proyecto_biblioteca.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProyectoBibliotecaApplication implements CommandLineRunner {

	@Autowired
	private IBookRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoBibliotecaApplication.class, args);
    }

	@Override
	public void run(String... args) throws Exception {
		HomePage2 homePage2 = new HomePage2(repository);
		homePage2.showMenu();

//		HomePage homePage = new HomePage();
//		homePage.showMenu();
	}
}
