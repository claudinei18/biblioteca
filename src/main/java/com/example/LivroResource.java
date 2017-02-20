package com.example;

/**
 * Created by claudinei on 19/02/17.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;
import java.util.List;

/**
 * REST controller for managing Departamento.
 */
@RestController
@RequestMapping("/api")
public class LivroResource {

    @Autowired
    private LivroService livroService;

    @RequestMapping(value = "/all",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<List<Livro>> getAllLivros()
            throws URISyntaxException {

        List<Livro> page = livroService.findAll();
        return new ResponseEntity<>(page, HttpStatus.OK);
    }

    @RequestMapping(value = "/inserir",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<List<Livro>> inserir(@RequestParam("nome") String nome,
                                                @RequestParam("autor") String autor,
                                               @RequestParam("descricao") String descricao)
            throws URISyntaxException {

        Livro livro = new Livro(nome, autor, descricao);
        livroService.save(livro);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}