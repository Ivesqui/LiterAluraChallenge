package com.Ivesqui.literalura.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.Ivesqui.literalura.models.Author;


public interface AuthorRepository extends JpaRepository<Author, Long> {


    @Query("SELECT a from Author a WHERE a.name LIKE :nombre% AND a.yearBirth = :fechaNacimiento AND a.yearDeath = :fechaMuerte")
    Author buscarAutor(String nombre, int fechaNacimiento, int fechaMuerte);

}
