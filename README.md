<h1>Bienvendos a Mi proyecto LiterAlura 🚀</h1>
<img src="[src/main/java/com/Ivesqui/literalura/literAlura.jpg](https://ibb.co/gd96TwM)" width="600">

## 📖 Introducción
Este proyecto, desarrollado como parte de mi formación en Alura Latam, es una inmersión fascinante en el mundo de la persistencia de datos. 
Integra una variedad de funcionalidades que permiten al usuario interactuar con una interfaz de consola intuitiva, diseñada para realizar consultas detalladas sobre libros y sus autores. 
Los datos, previamente almacenados en una base de datos local, se despliegan de manera eficiente, ofreciendo información exhaustiva tanto del libro como de su creador. Este proyecto es una oportunidad magnífica para explorar 
y poner a prueba las capacidades de persistencia de datos a nivel local, utilizando SpringBoot para extraer datos dinámicos de una API.


## 🔧 Funciones
- Buscar libro por autor: La aplicación realiza una petición a la API de libros (en este proyecto, Gutendex) mediante 
HttpRequest y recibe la respuesta con HttpResponse. Luego, utiliza la herramienta Gson para deserializar la respuesta, 
empleando un DTO (Data Transfer Object) en forma de registro del libro y autor, para finalmente guardar la información en la base de datos.


- **Listar libros registrados:** Un método de la aplicación realiza una consulta a la base de datos utilizando Derived Query, 
imprimiendo en consola todos los libros almacenados.


- **Listar autores registrados:** Similar al método anterior, pero esta vez se realiza una consulta mediante JOIN para 
extraer y mostrar todos los autores almacenados en la base de datos.


- **Listar autores vivos en un determinado año:** El usuario ingresa un año específico que sirve como parámetro para una 
consulta. Se imprimen en consola todos los autores vivos desde el año ingresado en adelante.


- **Listar libros por idioma:** El usuario elige uno de los cuatro idiomas disponibles que se muestran en consola, 
y se realiza una consulta a la base de datos para extraer todos los libros en el idioma seleccionado.


- **Mostrar datos estadísticos:** Al elegir esta opción, se presentan datos estadísticos generales sobre los libros, 
como el número promedio de descargas, el número máximo de descargas, el valor mínimo de descargas, entre otros.


- **Mostrar top 10 libros descargados:** Se despliegan en pantalla los 10 libros más descargados 
que están almacenados en la base de datos.

- **Buscar autor por nombre:** El usuario ingresa un nombre que se utiliza como parámetro en una consulta a la base de datos.
La aplicación realiza un JOIN para traer los datos del autor con el nombre ingresado.


## 📝 Tutorial de Uso
>**Nota:** 
>Esta aplicación puede ser utilizada por cualquier persona con fines educativos.
>La aplicación requiere primero ejecutar el Script MYSQL llamado "bd" que está incluido en la capeta "Databases"
>una vez ejecutada la base de datos, por favor revisar el archivo application.properties ubicado en la carpeta resources
>que contiene todos los datos para realizar la conexión a la base de datos.
### Ejemplo de búsqueda del libros registrados (opción 2)
Esta será la salida por consola del menú con sus diferentes opciones:
```
  ╔══════════════════════════════════════════════════════════════════╗
  ║                         MENÚ PRINCIPAL                           ║
  ╠══════════════════════════════════════════════════════════════════╣
  ║  1 - Buscar libro por título                                     ║
  ║  2 - Listar libros registrados                                   ║
  ║  3 - Listar autores registrados                                  ║
  ║  4 - Listar autores vivos en un determinado año                  ║
  ║  5 - Listar libros por idioma                                    ║
  ║  6 - Mostar datos estadísticos                                   ║
  ║  7 - Mostrar top 10 libros descargados                           ║
  ║  8 - Buscar autor por nombre                                     ║
  ║  9 - Listar autores que nacieron o murieron en un determinado    ║
  ║      periodo (años)                                              ║
  ║  0 - Salir de la aplicación                                      ║
  ╠══════════════════════════════════════════════════════════════════╣
  ║  Por favor escriba un número según el literal y presione enter.  ║
  ╚══════════════════════════════════════════════════════════════════╝
```
1. Se selecciona la opción que necesitesr *(en este caso la 2)* 
```
Seleccion:
2
```
2. Por defecto en el programa ya viene almacenado el libro Moby Dick, puedes probar a buscar otro libro
utilizando la opción 1.
3. Luego Imprimirá en la consola automáticamente los datos del libro o los libros que han sido buscados.
```
.•°*”˜˜”*°•. DATOS  LIBRO .•°*”˜˜”*°•. 
 Titulo: Moby Dick; Or, The Whale 
 Autor(es): Melville, Herman 
 Idioma: en 
 Nº descargas: 58237 
             ˜”*°• •°*”˜ 
```

>**Nota Adicional:** Es un tutorial pequeño, pero importante que pruebes todas las funcionalidades, 
> hay muchas interesantes animate a probarlas todas! 😏

## 💻 Tecnologias Implementadas
Las tecnologías que utilicé durante este proyecto fueron las siguientes:


![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
 ![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white)
  ![MySQL](https://img.shields.io/badge/mysql-4479A1.svg?style=for-the-badge&logo=mysql&logoColor=white)
  ![Postman](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white)
  ![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
  ![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)
  ![Notion](https://img.shields.io/badge/Notion-%23000000.svg?style=for-the-badge&logo=notion&logoColor=white)
 ![Trello](https://img.shields.io/badge/Trello-%23026AA7.svg?style=for-the-badge&logo=Trello&logoColor=white)

## 👤 Acerca De
Soy Christian Estupiñan Quintero, estudiante de Ingeniería de Sistemas Inteligentes, comprometido con el aprendizaje 
continuo y con la meta de convertirme en desarrollador full-stack.




