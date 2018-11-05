package com.b2wdigital.desafio.Util;


import com.b2wdigital.desafio.model.Planeta;


public class PlanetaRequestUtil {
    
    public static Planeta getPlanetaDesconhecido() {

        Planeta planeta = new Planeta();

        planeta.setNome("Desconhecido");
        planeta.setClima("diversos");
        planeta.setTerreno("rochoso");
        
        return planeta;
    }
    
    
    public static Planeta getPlanetaConhecido() {

        Planeta planeta = new Planeta();

        planeta.setNome("Naboo");
        planeta.setClima("temperate");
        planeta.setTerreno("grassy hills, swamps, forests, mountains");
        
        return planeta;
    }
    
    
    public static Planeta getPlanetaIncompleto() {

        Planeta planeta = new Planeta();

        planeta.setNome(null);
        planeta.setClima(null);
        planeta.setTerreno(null);
        
        return planeta;
    }
    
    public static String getJsonPlanetaRequest(Planeta planeta) {

        String jsonPlaneta = "{  \n" +
                "   \"planeta\":{  \n" +
                "      \"nome\":\""+ planeta.getNome() +"\",\n" +
                "      \"clima\": \""+ planeta.getClima() +"\",\n" +
                "      \"terreno\": \""+ planeta.getTerreno() +"\"\n" +
                "   }\n" +
                "}";

        return jsonPlaneta;
    }

    public static String getJsonPlanetaBadRequest(Planeta planeta) {

        String jsonPlaneta = "{  \n" +
                "   \"planeta\":{  \n" +
                "      \"nome\":\""+ planeta.getNome() +"\",\n" +
                "      \"climas\": \""+ planeta.getClima() +"\",\n" +
                "      \"terreno\": \""+ planeta.getTerreno() +"\"\n" +
                "   }\n" +
                "}";

        return jsonPlaneta;
    }
    
    public static String getJsonPlanetaNuloRequest(Planeta planeta) {

        String jsonPlaneta = "{  \n" +
                "   \"planeta\":{  \n" +
                "      \"nome\":"+ planeta.getNome() +",\n" +
                "      \"clima\": "+ planeta.getClima() +",\n" +
                "      \"terreno\": "+ planeta.getTerreno() +"\n" +
                "   }\n" +
                "}";

        return jsonPlaneta;
    }

}
