package com.b2wdigital.desafio.model.service.implementacao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.b2wdigital.desafio.controller.PlanetResponseSwapi;
import com.b2wdigital.desafio.model.Planeta;
import com.b2wdigital.desafio.model.exception.PlanetaException;
import com.b2wdigital.desafio.model.repository.PlanetaRepository;
import com.b2wdigital.desafio.model.service.PlanetaService;
import com.b2wdigital.desafio.model.service.PlanetaSwapiService;
import static java.util.Objects.isNull;

@Service
public class PlanetaServiceImpl implements PlanetaService {

	@Autowired
	private PlanetaRepository planetaRepository;

	@Autowired
	private PlanetaSwapiService planetaSwapiService;
	

	public Planeta create(Planeta planeta) throws PlanetaException {

		if(!isNull(planeta)) {
		
			if (!isNamePresent(planeta.getNome())) {
	
				Planeta planetadb = new Planeta();
				planetadb.setNome(planeta.getNome());
				planetadb.setClima(planeta.getClima());
				planetadb.setTerreno(planeta.getTerreno());
				planetadb.setFilmesTotal(getTotalFilmes(planeta.getNome()));
	
				return planetaRepository.save(planetadb);
			} else {
	
				throw new PlanetaException(HttpStatus.CONFLICT, "Planeta já existente.");
			}
		}
		else {
			
			throw new PlanetaException(HttpStatus.BAD_REQUEST, "Não é possível gravar um planeta nulo");
		}
	}

	public boolean isNamePresent(String planetaNome) {
		Optional<Planeta> planetaOptional = this.findByNome(planetaNome);

		if (planetaOptional.isPresent()) {
			return true;
		} else {
			return false;
		}
	}

	public void deleteById(String planetaId) throws PlanetaException {

		Optional<Planeta> planetaOptional = this.findById(planetaId);

		if (planetaOptional.isPresent()) {

			planetaRepository.delete(planetaOptional.get());

		} else {

			throw new PlanetaException(HttpStatus.NOT_FOUND, "Nenhuma ocorrência de planeta encontrada");
		}
	}

	public Integer getTotalFilmes(String nome) throws PlanetaException {

		PlanetResponseSwapi  planetResponseSwapi = planetaSwapiService.findPlanetaByName(nome);
		return planetResponseSwapi.getResults().stream().mapToInt(planeta -> planeta.getFilms().size()).sum();
	}

	public Iterable<Planeta> findAll() throws PlanetaException {

		Iterable<Planeta> planetas = planetaRepository.findAll();

		if (planetas.iterator().hasNext()) {

			return planetas;

		} else {

			throw new PlanetaException(HttpStatus.NOT_FOUND, "Nenhuma ocorrência de planeta encontrada.");

		}
	}

	public Optional<Planeta> findById(String planetaId) {
		return planetaRepository.findById(planetaId);
	}

	public Optional<Planeta> findByNome(String nome) {
		return planetaRepository.findByNome(nome);
	}

}
