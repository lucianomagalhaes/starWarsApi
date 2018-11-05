package com.b2wdigital.desafio.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.b2wdigital.desafio.StarWarsApplication;
import com.b2wdigital.desafio.Util.PlanetaRequestUtil;
import com.b2wdigital.desafio.model.Planeta;
import com.b2wdigital.desafio.model.repository.PlanetaRepository;
import com.b2wdigital.desafio.model.service.PlanetaService;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = StarWarsApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("teste")
public class PlanetaControllerTest {

	@Autowired
	PlanetaRepository planetaRepository;

	@Autowired
	private TestRestTemplate restTemplate;

	@Before
	public void init() {
		planetaRepository.deleteAll();
	}


	@Test
	public void createPlanetaErroBadRequest() throws URISyntaxException {

		Planeta planeta = PlanetaRequestUtil.getPlanetaConhecido();
		String jsonPlanetaRequest = PlanetaRequestUtil.getJsonPlanetaBadRequest(planeta);

		RequestEntity<String> requestEntity = RequestEntity.post(new URI("/planetas/planeta"))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).body(jsonPlanetaRequest);

		ResponseEntity<PlanetaResponse> responseEntity = restTemplate.exchange(requestEntity, PlanetaResponse.class);

		Assert.assertNotNull(responseEntity);
		Assert.assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
	}

	@Test
	public void createPlanetaErroBindingRequest() throws URISyntaxException {

		Planeta planeta = PlanetaRequestUtil.getPlanetaIncompleto();
		String jsonPlanetaRequest = PlanetaRequestUtil.getJsonPlanetaNuloRequest(planeta);

		RequestEntity<String> requestEntity = RequestEntity.post(new URI("/planetas/planeta"))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).body(jsonPlanetaRequest);

		ResponseEntity<PlanetaResponse> responseEntity = restTemplate.exchange(requestEntity, PlanetaResponse.class);

		Assert.assertNotNull(responseEntity);
		Assert.assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
	}

	@Test
	public void createSuccessfulPlanetaNomeInexistenteBase() throws URISyntaxException {

		Planeta planeta = PlanetaRequestUtil.getPlanetaDesconhecido();
		String jsonPlanetaRequest = PlanetaRequestUtil.getJsonPlanetaRequest(planeta);

		RequestEntity<String> requestEntity = RequestEntity.post(new URI("/planetas/planeta"))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).body(jsonPlanetaRequest);

		ResponseEntity<PlanetaResponse> responseEntity = restTemplate.exchange(requestEntity, PlanetaResponse.class);

		Assert.assertNotNull(responseEntity);
		Assert.assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
	}

	@Test
	public void createSuccessfulPlanetaNomeExistenteBase() throws URISyntaxException {

		Planeta planeta = PlanetaRequestUtil.getPlanetaConhecido();
		String jsonPlanetaRequest = PlanetaRequestUtil.getJsonPlanetaRequest(planeta);

		RequestEntity<String> requestEntity = RequestEntity.post(new URI("/planetas/planeta"))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).body(jsonPlanetaRequest);

		ResponseEntity<PlanetaResponse> responseEntity = restTemplate.exchange(requestEntity, PlanetaResponse.class);

		Assert.assertNotNull(responseEntity);
		Assert.assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
	}

	@Test
	public void findAllPlanetaNotFound() throws URISyntaxException {

		RequestEntity<Void> requestEntity = RequestEntity.get(new URI("/planetas")).accept(MediaType.APPLICATION_JSON)
				.build();

		ResponseEntity<PlanetaResponse> responseEntity = restTemplate.exchange(requestEntity, PlanetaResponse.class);

		Assert.assertNotNull(responseEntity);
		Assert.assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
		Assert.assertEquals("Nenhuma ocorrência de planeta encontrada.", responseEntity.getBody().getDescription());
	}

	@Test
	public void findByNamePlanetaNotFound() throws URISyntaxException {

		RequestEntity<Void> requestEntity = RequestEntity.get(new URI("/planetas/planeta/nome/PlanetaInexistente"))
				.accept(MediaType.APPLICATION_JSON).build();

		ResponseEntity<PlanetaResponse> responseEntity = restTemplate.exchange(requestEntity, PlanetaResponse.class);

		Assert.assertNotNull(responseEntity);
		Assert.assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
		Assert.assertEquals("Nenhuma ocorrência de planeta encontrada para: PlanetaInexistente",
				responseEntity.getBody().getDescription());
	}

	@Test
	public void findByIdPlanetaNotFound() throws URISyntaxException {

		RequestEntity<Void> requestEntity = RequestEntity.get(new URI("/planetas/planeta/id/xyz001"))
				.accept(MediaType.APPLICATION_JSON).build();

		ResponseEntity<PlanetaResponse> responseEntity = restTemplate.exchange(requestEntity, PlanetaResponse.class);

		Assert.assertNotNull(responseEntity);
		Assert.assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
		Assert.assertEquals("Nenhuma ocorrência de planeta encontrada", responseEntity.getBody().getDescription());
	}

	@Test
	public void deleteByIdPlanetaNotFound() throws URISyntaxException {

		RequestEntity<Void> requestEntity = RequestEntity.delete(new URI("/planetas/planeta/id/xyz001"))
				.accept(MediaType.APPLICATION_JSON).build();

		ResponseEntity<PlanetaResponse> responseEntity = restTemplate.exchange(requestEntity, PlanetaResponse.class);

		Assert.assertNotNull(responseEntity);
		Assert.assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
		Assert.assertEquals("Nenhuma ocorrência de planeta encontrada", responseEntity.getBody().getDescription());
	}
}
