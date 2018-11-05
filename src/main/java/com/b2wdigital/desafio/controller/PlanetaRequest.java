package com.b2wdigital.desafio.controller;

import javax.validation.Valid;

import com.b2wdigital.desafio.model.Planeta;

public class PlanetaRequest {

    @Valid
    private Planeta planeta;

	public Planeta getPlaneta() {
		return planeta;
	}

	public void setPlaneta(Planeta planeta) {
		this.planeta = planeta;
	}
    
    
}
