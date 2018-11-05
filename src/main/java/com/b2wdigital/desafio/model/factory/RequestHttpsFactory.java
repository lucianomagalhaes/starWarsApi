package com.b2wdigital.desafio.model.factory;

import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;

public class RequestHttpsFactory {

	public static HttpComponentsClientHttpRequestFactory getRequestFactoryHttps() {

		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		requestFactory.setHttpClient(createDefault());

		return requestFactory;
	}

	private static CloseableHttpClient createDefault() {
		return HttpClients.custom().setSSLHostnameVerifier(new NoopHostnameVerifier()).build();
	}

}
