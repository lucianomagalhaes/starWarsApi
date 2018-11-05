package com.b2wdigital.desafio.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.b2wdigital.desafio.model.Planeta;
import com.b2wdigital.desafio.model.exception.PlanetaException;
import com.b2wdigital.desafio.model.service.PlanetaService;


@RestController
@RequestMapping(value="/planetas")
public class PlanetaController {

    @Autowired
    private PlanetaService planetaService;

    
    @PostMapping(value="planeta")
    public HttpEntity<PlanetaResponse> create(@Valid @RequestBody PlanetaRequest planetaRequest,
                                                  BindingResult bindingResult) {

    	PlanetaResponse planetaResponse = new PlanetaResponse();
    	
        try {

            if (bindingResult.hasErrors()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resultErrorResponse(bindingResult));
            }

            Planeta planeta = planetaService.create(planetaRequest.getPlaneta());
            planetaResponse.setPlaneta(planeta);
            return ResponseEntity.status(HttpStatus.CREATED).body(planetaResponse);

        } catch (PlanetaException planetaException) {

            planetaResponse.setDescription(planetaException.getMessage());
            return ResponseEntity.status(planetaException.getHttpStatus()).body(planetaResponse);
        	
        } catch (Exception e) {

            return recoveryInternalError();
        }
    }


    
    @GetMapping
    public HttpEntity<PlanetaResponse> findAll() {

        PlanetaResponse planetaResponse = new PlanetaResponse();

        try {

            List<Planeta> planetas = new ArrayList<Planeta>();
            planetaService.findAll().iterator().forEachRemaining(planetas::add);

            planetaResponse.setPlanetas(planetas);
            return ResponseEntity.status(HttpStatus.OK).body(planetaResponse);

        } 
        catch (PlanetaException planetaException) {

            planetaResponse.setDescription(planetaException.getMessage());
            return ResponseEntity.status(planetaException.getHttpStatus()).body(planetaResponse);

        } 
        catch (Exception e) {
        	
        	return recoveryInternalError();
        }
    }

    
    @GetMapping(value="planeta/nome/{nomePlaneta}")
    public HttpEntity<PlanetaResponse> findByName(@PathVariable("nomePlaneta") String nomePlaneta) {

        PlanetaResponse planetaResponse = new PlanetaResponse();

        try {

            Optional<Planeta> planetaOptional = planetaService.findByNome(nomePlaneta);

            if (planetaOptional.isPresent()) {

                planetaResponse.setPlaneta(planetaOptional.get());
                return ResponseEntity.status(HttpStatus.OK).body(planetaResponse);

            } else {
            	
                planetaResponse.setDescription("Nenhuma ocorrência de planeta encontrada para: " + nomePlaneta);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(planetaResponse);
            }

        } catch (Exception e) {
        	
        	return recoveryInternalError();
        }
    }

    @GetMapping(value="planeta/id/{id}")
    public HttpEntity<PlanetaResponse> findById(@PathVariable("id") String id) {

        PlanetaResponse planetaResponse = new PlanetaResponse();

        try {

            Optional<Planeta> planetaOptional = planetaService.findById(id);

            if (planetaOptional.isPresent()) {

                planetaResponse.setPlaneta(planetaOptional.get());
                return ResponseEntity.status(HttpStatus.OK).body(planetaResponse);

            } else {
            	
                planetaResponse.setDescription("Nenhuma ocorrência de planeta encontrada");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(planetaResponse);
            }

        } catch (Exception e) {
            
        	return recoveryInternalError();
        }
    }

    
    @DeleteMapping(value="planeta/id/{id}")
    public HttpEntity<PlanetaResponse> deleteById(@PathVariable String id) {

        try {
        	
        	planetaService.deleteById(id);
        	return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

        }
        catch (PlanetaException planetaException) {

        	PlanetaResponse planetaResponse = new PlanetaResponse();
            planetaResponse.setDescription(planetaException.getMessage());
            return ResponseEntity.status(planetaException.getHttpStatus()).body(planetaResponse);

        } 
        catch (Exception e) {

        	return recoveryInternalError();        
        }
    }

    private HttpEntity<PlanetaResponse> recoveryInternalError() {

		String errorCode = String.valueOf(System.nanoTime());
		PlanetaResponse planetaResponse = new PlanetaResponse();
		planetaResponse.setDescription("Houve um erro interno no servidor: " + errorCode);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(planetaResponse);
	}
    
    private PlanetaResponse resultErrorResponse(BindingResult result) {

        List<String> errors = result.getFieldErrors().stream().map(error -> result.getFieldError(error.getField()).getDefaultMessage()).collect(Collectors.toList());
        PlanetaResponse planetaResponse = new PlanetaResponse();
        planetaResponse.setDescription(errors.toString());
        return planetaResponse;
    }

}
