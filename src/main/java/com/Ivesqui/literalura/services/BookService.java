package com.Ivesqui.literalura.services;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.Ivesqui.literalura.models.Author;
import com.Ivesqui.literalura.repositories.AuthorRepository;
import com.Ivesqui.literalura.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ivesqui.literalura.dto.DataAuthor;
import com.Ivesqui.literalura.dto.DataBook;
import com.Ivesqui.literalura.models.Book;

@Service
public class BookService {

    @Autowired
    private AuthorRepository repoAuthor;
    @Autowired
    private BookRepository repoBook;

    public void saveBook(DataBook d) {
        Optional<Book> libroBuscado = repoBook.findById(d.id());
        if (!libroBuscado.isPresent()) {
            List<Author> autores = verifyAuthors(d.authors());
            Book nuevoLibro = new Book(d.id(), d.title(), d.languages(), d.totalDownloads());// creo el nuevo libro
            for (Author author : autores) {
                if (author.getId() == null) {
                    nuevoLibro.addAuthor(author);
                } else {
                    nuevoLibro.addAuthor(author);
                }
            }
            repoBook.save(nuevoLibro);
            System.out.println(nuevoLibro.toString());
        } else {
            System.out.println("No puedes registrar el mismo libro más de una vez!");
        }
    }

    public List<Author> verifyAuthors(List<DataAuthor> authors) {
        List<Author> autores = new ArrayList<>();
        for (DataAuthor a : authors) {
            Author autor = repoAuthor.buscarAutor(a.name(), a.birthYear(), a.deathYear());
            if (autor == null) {
                autores.add(new Author(a.name(), a.birthYear(), a.deathYear()));
            } else {
                autores.add(autor);
            }
        }
        return autores;
    }

    public void listBooks() {
        List<Book> libros = repoBook.findAll();
        libros.stream().forEach(System.out::println);
    }

    public void listAuthors() {
        List<Author> authors = repoBook.buscarAutores();
        authors.forEach(a -> System.out.println(a.toString()));
    }

	public void listAuthorsAlive(int anio) {
        List<Author> authors = repoBook.buscarAutoresVivos(anio);
        authors.stream().forEach(System.out::println);
	}

    public void listAvailableLanguages() {
         List<String> languages =  new ArrayList<>(repoBook.buscarIdiomas());
         languages.stream().forEach(System.out::println);
    }

    public void listBooksByLanguage(String lenguaje) {
         List<Book> libros = repoBook.encontrarLibroXIdioma(lenguaje);
         libros.stream().forEach(System.out::println);
    }

    public void getStadisticData() {
        List<Book> books = repoBook.findAll();
        ArrayList<Book> libros = new ArrayList<Book>(books);
        DoubleSummaryStatistics data = libros.stream().collect(Collectors.summarizingDouble(Book::getTotalDownloads));
        System.out.println(
        "\".•°*”˜˜”*°•. DATOS  LIBRO .•°*”˜˜”*°•. "+
        "\nMedia de descargas: "+ String.format("%1.2f", data.getAverage())+
        "\nMayor descargada: "+data.getMax()+
        "\nMenor descargada "+data.getMin()+
        "\nNº de libros almacenados: "+data.getCount()+
        "\n        ˜”*°• •°*”˜");

    }

    public void getTopBooks() {
        List<Book> libros = repoBook.mostrarTop10Libros();
        libros.forEach(System.out::println);
    }

    public void getAutor(String nombre) {
        Author author = repoBook.mostrarAutor(nombre);
        System.out.println(author.toString());
    }

	public void getAuthorsAliveRange(int anioDesde, int anioHasta) {
		List<Author> autores = repoBook.mostarAutoresVivosRango(anioDesde, anioHasta);
        autores.forEach(System.out::println);
	}




}
