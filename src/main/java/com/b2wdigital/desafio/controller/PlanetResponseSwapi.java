package com.b2wdigital.desafio.controller;

import java.util.List;

import com.b2wdigital.desafio.model.PlanetaSwapi;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlanetResponseSwapi {

    private Integer count;
    private Object next;
    private Object previous;
    private List<PlanetaSwapi> results;

    public PlanetResponseSwapi() {
    }

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Object getNext() {
		return next;
	}

	public void setNext(Object next) {
		this.next = next;
	}

	public Object getPrevious() {
		return previous;
	}

	public void setPrevious(Object previous) {
		this.previous = previous;
	}

	public List<PlanetaSwapi> getResults() {
		return results;
	}

	public void setResults(List<PlanetaSwapi> results) {
		this.results = results;
	}

	
}
