package com.example;

/**
 * Created by claudinei on 19/02/17.
 */

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.Date;
import java.util.List;

import static org.springframework.data.repository.init.ResourceReader.Type.JSON;

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

    public ResponseEntity<List<Livro>> inserir(@RequestBody Object livro)
            throws URISyntaxException, JSONException {

        String s = livro.toString();
        System.out.println(s);

        JSONObject jsonLivro = new JSONObject(s);
        jsonLivro = jsonLivro.getJSONObject("livro");

        System.out.println("Livro: " + jsonLivro);

        Livro livro2 = new Livro(jsonLivro.get("nome").toString(), jsonLivro.get("autor").toString(), jsonLivro.get("descricao").toString(),
                                new Date(), "photourl", jsonLivro.get("isbn").toString(),
                                jsonLivro.get("year").toString());
        livroService.save(livro2);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}