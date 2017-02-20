package com.example;

/**
 * Created by claudinei on 19/02/17.
 */


import java.util.List;

/**
 * Service Interface for managing livro.
 */
public interface LivroService {

    /**
     * Save a livro.
     *
     * @param livro the entity to save
     * @return the persisted entity
     */
    Livro save(Livro livro);


    List<Livro> findAll();

    /**
     *  Get the "id" livro.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    Livro findOne(Long id);

    /**
     *  Delete the "id" livro.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);

    List<Livro> search(String search);

}
