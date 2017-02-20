package com.example;

/**
 * Created by claudinei on 19/02/17.
 */


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

/**
 * Service Implementation for managing livro.
 */
@Service
@Transactional
public class LivroServiceImpl implements LivroService {


    @Autowired
    private LivroRepository livroRepository;

    /**
     * Save a livro.
     *
     * @param livro the entity to save
     * @return the persisted entity
     */
    public Livro save(Livro livro) {

        Livro result = livroRepository.save(livro);
        return result;
    }

    /**
     * Get one livro by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public Livro findOne(Long id) {

        Livro livro = livroRepository.findOne(id);
        return livro;
    }

    /**
     * Delete the  livro by id.
     *
     * @param id the id of the entity
     */
    public void delete(Long id) {

        Livro livro = livroRepository.findOne(id);
        livroRepository.save(livro);
    }

    /**
     * Get all the livros.
     *
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public List<Livro> findAll() {

        List<Livro> result = livroRepository.findAll();
        return result;
    }

    public List<Livro> search(String search){
        return livroRepository.search(search);
    }

}


