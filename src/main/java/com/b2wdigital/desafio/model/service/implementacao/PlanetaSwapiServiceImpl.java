package com.b2wdigital.desafio.model.service.implementacao;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.b2wdigital.desafio.controller.PlanetResponseSwapi;
import com.b2wdigital.desafio.model.Enum.SwapiEndPoint;
import com.b2wdigital.desafio.model.exception.PlanetaException;
import com.b2wdigital.desafio.model.factory.RequestHttpsFactory;
import com.b2wdigital.desafio.model.service.PlanetaSwapiService;


@Service
public class PlanetaSwapiServiceImpl implements PlanetaSwapiService {

	private String urlResourceSearch = SwapiEndPoint.URL_BASE.getValor() + SwapiEndPoint.RESOURCE.getValor() + SwapiEndPoint.REQUEST_SEARCH.getValor();

	
	public PlanetResponseSwapi findPlanetaByName(String name) throws PlanetaException {
		
		PlanetResponseSwapi planetResponseSwapi;
		
		try {
			
			RestTemplate restTemplate = new RestTemplate(RequestHttpsFactory.getRequestFactoryHttps());
			planetResponseSwapi = restTemplate.getForObject(this.urlResourceSearch + name, PlanetResponseSwapi.class);
			
		} catch (RestClientException e) {
			
			 throw new PlanetaException(
	                    HttpStatus.INTERNAL_SERVER_ERROR,
	                    "Erro interno ao consultar a API Star Wars"
	            );

		}
		return planetResponseSwapi;
	}

}
