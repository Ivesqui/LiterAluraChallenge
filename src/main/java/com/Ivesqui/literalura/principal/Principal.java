package com.Ivesqui.literalura.principal;

import java.util.List;
import java.util.Scanner;

import com.Ivesqui.literalura.dto.DataBook;
import com.Ivesqui.literalura.dto.DataResults;
import com.Ivesqui.literalura.services.BookService;
import com.Ivesqui.literalura.services.ConexionAPI;
import com.Ivesqui.literalura.services.ConvierteDatos;

public class Principal {

    private ConexionAPI connection = new ConexionAPI();
    private ConvierteDatos convertidor = new ConvierteDatos();
    private Scanner teclado = new Scanner(System.in);
    private BookService servicio;

    public Principal(BookService servicio) {
        this.servicio = servicio;
    }

    public void mostrarMenu() {
        String menu = """
                ╔══════════════════════════════════════════════════════════════════╗
                ║                         MENÚ PRINCIPAL                           ║
                ╠══════════════════════════════════════════════════════════════════╣
                ║  1 - Buscar libro por título                                     ║
                ║  2 - Listar libros registrados                                   ║
                ║  3 - Listar autores registrados                                  ║
                ║  4 - Listar autores vivos en un determinado año                  ║
                ║  5 - Listar libros por idioma                                    ║
                ║  6 - Visualizar datos estadísticos                               ║
                ║  7 - Mostrar top 10 libros descargados                           ║
                ║  8 - Buscar autor por nombre                                     ║
                ║  9 - Listar autores que nacieron o murieron en un determinado    ║
                ║      periodo (años)                                              ║
                ║  10 - Finalizar aplicación                                       ║
                ╠══════════════════════════════════════════════════════════════════╣
                ║  Por favor escriba un número según el literal y presione enter.  ║
                ╚══════════════════════════════════════════════════════════════════╝
                Seleccion: """;
        System.out.println(menu);
        int opcion = Integer.parseInt(teclado.nextLine());
        while (opcion != 10) {
            switch (opcion) {
                case 1:
                    buscarLibro();
                    break;
                case 2:
                    listarLibros();
                    break;
                case 3:
                    listarAutores();
                    break;
                case 4:
                    listarAutoresVivos();
                    break;
                case 5:
                    listarLibroIdioma();
                    break;
                case 6:
                    mostrarDatosEstadisticos();
                    break;
                case 7:
                    listarTop10Libros();
                    break;
                case 8:
                    buscarAutorPorNombre();
                    break;
                case 9:
                    listarAutoresVivosDentroDeRango();
                    break;
                case 10:
                    break;
                default:
                System.out.println("Opción invalida, vuelva a ingresar otra valida ");
                    break;
            }
            System.out.println(menu);
            opcion = Integer.parseInt(teclado.nextLine());
        }
        System.out.println("Saliendo...");
    };

    private void listarAutoresVivosDentroDeRango() {
        System.out.println("Ingresa el año desde el que deseas buscar los autores vivos");
        int anioDesde = Integer.parseInt(teclado.nextLine());
        System.out.println("Ingresa el año hasta el que deseas buscar los autores vivos ");
        int anioHasta = Integer.parseInt(teclado.nextLine());
        servicio.getAuthorsAliveRange(anioDesde, anioHasta);
    }

    private void buscarAutorPorNombre() {
        System.out.println("Ingresa el nombre del autor que deseas buscar");
        String nombre = teclado.nextLine();
        servicio.getAutor(nombre);
    }

    private void listarTop10Libros() {
        servicio.getTopBooks();
    }

    private void mostrarDatosEstadisticos() {
        servicio.getStadisticData();
    }

    private void listarLibroIdioma() {
        // servicio.listAvailableLanguages();
        System.out.println("Ingresa el idioma de los libros que deseas visualizar");
        System.out.println("es - español\nen - inglés\nfr - francés\npt - portugués");
        String lenguaje = teclado.nextLine();
        servicio.listBooksByLanguage(lenguaje);
    }

    private void listarAutoresVivos() {
        System.out.println("Ingresa el año desde el que deseas ver vivo a los autores");
        int anio = Integer.parseInt(teclado.nextLine());
        servicio.listAuthorsAlive(anio);
    }

    private void listarAutores() {
        servicio.listAuthors();
    }

    private void listarLibros() {
        servicio.listBooks();
    }

    public void buscarLibro() {
        System.out.println("Ingrese el nombre del libro que desea buscar");
        String titulo = teclado.nextLine();
        String json = connection.obtenerDatos(titulo);
        DataResults datos = convertidor.convertidora(json, DataResults.class);
        List<DataBook> resultados = datos.results();// tengo los resultados
        if (resultados.isEmpty()) {
            System.out.println("Libro no encontrado");
        } else {
            servicio.saveBook(resultados.get(0));
        }

    }

}
