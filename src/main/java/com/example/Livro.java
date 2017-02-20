package com.example;

import org.hibernate.type.CustomType;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by claudinei on 19/02/17.
 */

@Entity
@Table(name = "livro")
public class Livro implements Serializable {

    private static final long serialVersionUID = 1L;

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column()
    private Long id;

    @NotNull
    @Size(max = 100)
    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @NotNull
    @Size(max = 100)
    @Column(name = "autor", length = 100, nullable = false)
    private String autor;

    @NotNull
    @Size(max = 100)
    @Column(name = "descricao", length = 200, nullable = false)
    private String descricao;

    @NotNull
    @Column(name = "releasedate", nullable = false)
    private Date releasedate;

    @NotNull
    @Size(max = 100)
    @Column(name = "photourl", length = 200, nullable = false)
    private String photourl;

    @NotNull
    @Size(max = 100)
    @Column(name = "isbn", length = 200, nullable = false)
    private String isbn;

    @NotNull
    @Column(name = "year", length = 200, nullable = false)
    private String year;

    public Livro(String nome, String autor, String descricao, Date releasedate, String photourl, String isbn, String year) {
        this.nome = nome;
        this.autor = autor;
        this.descricao = descricao;
        this.releasedate = releasedate;
        this.photourl = photourl;
        this.isbn = isbn;
        this.year = year;
    }

    public Livro(Object custom){
        //constructor Code

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getReleasedate() {
        return releasedate;
    }

    public void setReleasedate(Date releasedate) {
        this.releasedate = releasedate;
    }

    public String getPhotourl() {
        return photourl;
    }

    public void setPhotourl(String photourl) {
        this.photourl = photourl;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
