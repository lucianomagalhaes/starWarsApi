package com.b2wdigital.desafio.model.repository;


import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.b2wdigital.desafio.model.Planeta;

@Repository
public interface PlanetaRepository extends CrudRepository<Planeta, String> {

	Optional<Planeta> findByNome(String nome);

}
