package com.example;

/**
 * Created by claudinei on 19/02/17.
 */

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data JPA repository for the Departamento entity.
 */
@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

    @Query("SELECT l FROM Livro l where l.nome like '%search%' or l.autor like '%search%'")
    List<Livro> search(@Param("search") String search);
}


