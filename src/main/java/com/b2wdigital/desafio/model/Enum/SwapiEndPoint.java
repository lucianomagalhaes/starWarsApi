package com.b2wdigital.desafio.model.Enum;

public enum SwapiEndPoint {
	
	URL_BASE("https://swapi.co/api/"),
	RESOURCE("planets/"),
	REQUEST_SEARCH("?search=");
	
	private String valor;
	
	SwapiEndPoint (String valor){
		this.valor = valor;
	}
	
	public String getValor() {
		return valor;
	}
	
}
