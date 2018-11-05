package com.b2wdigital.desafio.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Planeta")
public class Planeta {

    @Id
    private String id;

    @Indexed(unique = true)
    @NotEmpty(message = "O campo nome deve ser informado")
    private String nome;

    @NotEmpty(message = "O campo clima deve ser informado")
    private String clima;

    @NotEmpty(message = "O campo terreno deve ser informado")
    private String terreno;

    private Integer filmesTotal;

    
    public Planeta() {
		super();
	}
    
	public Planeta(String id) {
		super();
		this.id = id;
	}


	public Planeta(String id, @NotEmpty(message = "O campo nome deve ser informado") String nome,
			@NotEmpty(message = "O campo clima deve ser informado") String clima,
			@NotEmpty(message = "O campo terreno deve ser informado") String terreno) {
		super();
		this.id = id;
		this.nome = nome;
		this.clima = clima;
		this.terreno = terreno;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

    public String getTerreno() {
        return terreno;
    }

    public void setTerreno(String terreno) {
        this.terreno = terreno;
    }

    public Integer getFilmesTotal() {
        return filmesTotal;
    }

    public void setFilmesTotal(Integer filmesTotal) {
        this.filmesTotal = filmesTotal;
    }
    
}
