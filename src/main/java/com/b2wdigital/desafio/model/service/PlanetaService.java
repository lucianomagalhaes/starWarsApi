package com.b2wdigital.desafio.model.service;

import java.util.Optional;

import com.b2wdigital.desafio.model.Planeta;
import com.b2wdigital.desafio.model.exception.PlanetaException;

public interface PlanetaService {

	Planeta create(Planeta planeta) throws PlanetaException;
	boolean isNamePresent(String planetaNome);
	void deleteById(String planetaId) throws PlanetaException;
	Iterable<Planeta> findAll() throws PlanetaException;
	Optional<Planeta> findById(String id);
	Optional<Planeta> findByNome(String nome);
	
}
