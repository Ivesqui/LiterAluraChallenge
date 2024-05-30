package com.Ivesqui.literalura;

import com.Ivesqui.literalura.principal.Principal;
import com.Ivesqui.literalura.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

	@Autowired
	private BookService servicio;

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
			Principal miPrincipal = new Principal(servicio);
			miPrincipal.mostrarMenu();

	}
}
