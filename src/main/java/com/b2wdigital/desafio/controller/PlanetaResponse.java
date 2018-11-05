package com.b2wdigital.desafio.controller;

import java.util.List;

import com.b2wdigital.desafio.model.Planeta;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@JsonInclude(Include.NON_NULL)
public class PlanetaResponse {

    private String description;

    private List<Planeta> planetas;

    private Planeta planeta;

    public PlanetaResponse() {}

    public PlanetaResponse(List<Planeta> planetas) {
        this.planetas = planetas;
    }

    public PlanetaResponse(Planeta planeta) {
        this.planeta = planeta;
    }

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Planeta> getPlanetas() {
		return planetas;
	}

	public void setPlanetas(List<Planeta> planetas) {
		this.planetas = planetas;
	}

	public Planeta getPlaneta() {
		return planeta;
	}

	public void setPlaneta(Planeta planeta) {
		this.planeta = planeta;
	}
    
    
}
