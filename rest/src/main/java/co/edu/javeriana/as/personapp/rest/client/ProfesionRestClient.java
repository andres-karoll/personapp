package co.edu.javeriana.as.personapp.rest.client;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

public class ProfesionRestClient {

    private static final String GET_ALL_PROFESIONES = "http://localhost:3000/profesion/all";
    private static final String CREATE_PROFESION = "http://localhost:3000/profesion/createProfesion";
    private static final String FIND_BY_ID_PROFESION = "http://localhost:3000/profesion/find/{id}";
    private static final String DELETE_PROFESION = "http://localhost:3000/profesion/deleteProfesion/{id}";
    private static final String COUNT_PROFESION = "http://localhost:3000/profesion/count";

    //Count profesiones
    public Integer count() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        Integer number = null;

        headers.setAccept(Collections.singletonList(MediaType.ALL));
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity entity = new HttpEntity(headers);
        try {
            ResponseEntity<String> response = restTemplate.exchange(COUNT_PROFESION, HttpMethod.GET, entity, String.class);
            number = Integer. parseInt(response.getBody());
        }catch(ResourceAccessException r){
            System.out.println("Servicio no disponible");
        }

        return number;
    }

    //Delete profesion
    public Boolean delete(Integer id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.ALL));
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity entity = new HttpEntity(headers);
        RestTemplate restTemplate = new RestTemplate();
        Boolean accepted = null;

        try {
            ResponseEntity<Boolean> response = restTemplate.exchange(DELETE_PROFESION, HttpMethod.DELETE, entity, Boolean.class, id);
            accepted = response.getBody();
        }catch(ResourceAccessException r){
            System.out.println("Servicio no disponible");
        }
        return accepted;
    }

    //Find by ID profesion
    public JSONObject byID(Integer id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.ALL));
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity entity = new HttpEntity(headers);
        RestTemplate restTemplate = new RestTemplate();
        JSONObject profesion = null;

        try {
            ResponseEntity<String> response = restTemplate.exchange(FIND_BY_ID_PROFESION, HttpMethod.GET, entity, String.class, id);
            profesion = new JSONObject(response.getBody());
        }catch(ResourceAccessException r){
            System.out.println("Servicio no disponible");
        }catch(RuntimeException e){
            System.out.println("Profesion no encontrada");
        }
        return profesion;
    }

    //Get All profesion
    public JSONArray get() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        JSONArray profesions = null;

        headers.setAccept(Collections.singletonList(MediaType.ALL));
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity entity = new HttpEntity(headers);

        try {
            ResponseEntity<String> allPersonas = restTemplate.exchange(GET_ALL_PROFESIONES, HttpMethod.GET, entity, String.class);
            profesions = new JSONArray(allPersonas.getBody());
        }catch (ResourceAccessException r){
            System.out.println("Servicio no disponible");
        }
        return profesions;
    }

    //Create profesion
    public JSONObject create(JSONObject body) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        JSONObject profesion = null;

        headers.setAccept(Collections.singletonList(MediaType.ALL));
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Object> entity = new HttpEntity<>(body.toString(),headers);
        try{
            ResponseEntity<String> response = restTemplate.postForEntity(CREATE_PROFESION,entity, String.class);
            profesion = new JSONObject(response.getBody());
        }catch(ResourceAccessException r){
            System.out.println("Servicio no disponible");
        }
        return profesion;
    }
}
