package co.edu.javeriana.as.personapp.rest.client;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.util.*;

public class PersonaClient {

    private static final String GET_ALL_PERSONAS = "http://localhost:3000/personas/all";
    private static final String CREATE_PERSONA = "http://localhost:3000/personas/createPersonas";
    private static final String EDIT_PERSONA = "http://localhost:3000/personas/editPersonas";
    private static final String FIND_BY_ID_PERSONA = "http://localhost:3000/personas/find/{id}";
    private static final String DELETE_PERSONA = "http://localhost:3000/personas/deletePersonas/{id}";
    private static final String COUNT_PERSONAS = "http://localhost:3000/personas/count";

    //Get All personas
    public JSONArray get() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        JSONArray people = null;

        headers.setAccept(Collections.singletonList(MediaType.ALL));
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity entity = new HttpEntity(headers);

        try {
            ResponseEntity<String> allPersonas = restTemplate.exchange(GET_ALL_PERSONAS, HttpMethod.GET, entity, String.class);
            people = new JSONArray(allPersonas.getBody());
        }catch (ResourceAccessException r){
            System.out.println("Servicio no disponible");
        }
        return people;
    }

    //Create persona
    public JSONObject create(JSONObject body) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        JSONObject person = null;

        headers.setAccept(Collections.singletonList(MediaType.ALL));
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Object> entity = new HttpEntity<>(body.toString(),headers);
        try{
            ResponseEntity<String> response = restTemplate.postForEntity(CREATE_PERSONA,entity, String.class);
            person = new JSONObject(response.getBody());
        }catch(ResourceAccessException r){
            System.out.println("Servicio no disponible");
        }
        return person;
    }

    //Edit persona
    public JSONObject edit(JSONObject body) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        JSONObject person = null;

        headers.setAccept(Collections.singletonList(MediaType.ALL));
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Object> entity = new HttpEntity<>(body.toString(),headers);
        try{
            ResponseEntity<String> response = restTemplate.postForEntity(EDIT_PERSONA,entity, String.class);
            person = new JSONObject(response.getBody());
        }catch(ResourceAccessException r){
            System.out.println("Servicio no disponible");
        }
        return person;
    }

    //Find by ID persona
    public JSONObject byID(Integer cc) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.ALL));
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity entity = new HttpEntity(headers);
        RestTemplate restTemplate = new RestTemplate();
        JSONObject person = null;

        try {
            ResponseEntity<String> response = restTemplate.exchange(FIND_BY_ID_PERSONA, HttpMethod.GET, entity, String.class, cc);
            person = new JSONObject(response.getBody());
        }catch(ResourceAccessException r){
            System.out.println("Servicio no disponible");
        }catch(RuntimeException e){
            System.out.println("Persona no encontrada");
        }
        return person;
    }

    //Delete persona
    public Boolean delete(Integer cc) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.ALL));
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity entity = new HttpEntity(headers);
        RestTemplate restTemplate = new RestTemplate();
        Boolean accepted = null;

        try {
            ResponseEntity<Boolean> response = restTemplate.exchange(DELETE_PERSONA, HttpMethod.DELETE, entity, Boolean.class, cc);
            accepted = response.getBody();
        }catch(ResourceAccessException r){
            System.out.println("Servicio no disponible");
        }
        return accepted;
    }

    //Count persona
    public Integer count() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        Integer number = null;

        headers.setAccept(Collections.singletonList(MediaType.ALL));
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity entity = new HttpEntity(headers);
        try {
            ResponseEntity<String> response = restTemplate.exchange(COUNT_PERSONAS, HttpMethod.GET, entity, String.class);
            number = Integer. parseInt(response.getBody());
        }catch(ResourceAccessException r){
            System.out.println("Servicio no disponible");
        }

        return number;
    }
}
