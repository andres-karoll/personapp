package co.edu.javeriana.as.personapp.rest.client;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

public class EstudioClient {

    private static final String CREATE_ESTUDIO = "http://localhost:3000/personas/createEstudios";
    private static final String DELETE_ESTUDIO = "http://localhost:3000/personas/deleteEstudios/{id}/{cc}";
    private static final String ALL_ESTUDIOS = "http://localhost:3000/personas/all";
    private static final String FIND_ESTUDIOS_BY_ID_CC = "http://localhost:3000/personas/find/{id}/{cc}";
    private static final String COUNT_ESTUDIOS = "http://localhost:3000/personas/count";

    //Get all estudios en la base de datos
    public JSONArray getEstudios() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        JSONArray estudios = null;

        headers.setAccept(Collections.singletonList(MediaType.ALL));
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity entity = new HttpEntity(headers);

        try {
            ResponseEntity<String> allEstudios = restTemplate.exchange(ALL_ESTUDIOS, HttpMethod.GET, entity, String.class);
            estudios = new JSONArray(allEstudios.getBody());
        }catch (ResourceAccessException r){
            System.out.println("Servicio no disponible");
        }
        return estudios;
    }

    //Create edit estudio
    public JSONObject create(JSONObject body) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        JSONObject estudio = null;

        headers.setAccept(Collections.singletonList(MediaType.ALL));
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Object> entity = new HttpEntity<>(body.toString(),headers);
        try{
            ResponseEntity<String> response = restTemplate.postForEntity(CREATE_ESTUDIO,entity, String.class);
            estudio = new JSONObject(response.getBody());
        }catch(ResourceAccessException r){
            System.out.println("Servicio no disponible");
        }
        return estudio;
    }

    //Count estudios
    public Integer count() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        Integer number = null;

        headers.setAccept(Collections.singletonList(MediaType.ALL));
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity entity = new HttpEntity(headers);
        try {
            ResponseEntity<String> response = restTemplate.exchange(COUNT_ESTUDIOS, HttpMethod.GET, entity, String.class);
            number = Integer. parseInt(response.getBody());
        }catch(ResourceAccessException r){
            System.out.println("Servicio no disponible");
        }

        return number;
    }

    //Delete estudio
    public Boolean delete(Integer id, Integer cc) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.ALL));
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity entity = new HttpEntity(headers);
        RestTemplate restTemplate = new RestTemplate();
        Boolean accepted = null;

        try {
            ResponseEntity<Boolean> response = restTemplate.exchange(DELETE_ESTUDIO, HttpMethod.DELETE, entity, Boolean.class, id, cc);
            accepted = response.getBody();
        }catch(ResourceAccessException r){
            System.out.println("Servicio no disponible");
        }
        return accepted;
    }

    //Find by ID and CC
    public JSONObject byID(Integer id, Integer cc) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.ALL));
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity entity = new HttpEntity(headers);
        RestTemplate restTemplate = new RestTemplate();
        JSONObject estudio = null;

        try {
            ResponseEntity<String> response = restTemplate.exchange(FIND_ESTUDIOS_BY_ID_CC, HttpMethod.GET, entity, String.class, id, cc);
            estudio = new JSONObject(response.getBody());
        }catch(ResourceAccessException r){
            System.out.println("Servicio no disponible");
        }catch(RuntimeException e){
            System.out.println("Estudio no encontrada");
        }
        return estudio;
    }

}
