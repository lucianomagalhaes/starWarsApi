package com.b2wdigital.desafio.model.service;

import com.b2wdigital.desafio.controller.PlanetResponseSwapi;
import com.b2wdigital.desafio.model.exception.PlanetaException;


public interface PlanetaSwapiService {
	
	PlanetResponseSwapi findPlanetaByName(String name) throws PlanetaException;

}
