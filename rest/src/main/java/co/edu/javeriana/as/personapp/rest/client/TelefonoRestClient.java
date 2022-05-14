package co.edu.javeriana.as.personapp.rest.client;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

public class TelefonoRestClient {
    private static final String GET_ALL_TELEFONOS = "http://localhost:3000/telefono/all";
    private static final String CREATE_TELEFONO = "http://localhost:3000/telefono/createTelefono";
    private static final String FIND_BY_ID_TELEFONO = "http://localhost:3000/telefono/find/{id}";
    private static final String DELETE_TELEFONO = "http://localhost:3000/telefono/deleteTelefono/{id}";
    private static final String COUNT_TELEFONOS = "http://localhost:3000/telefono/count";

    //Create - edit telefonos
    public JSONObject create(JSONObject body) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        JSONObject telefono = null;

        headers.setAccept(Collections.singletonList(MediaType.ALL));
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Object> entity = new HttpEntity<>(body.toString(),headers);
        try{
            ResponseEntity<String> response = restTemplate.postForEntity(CREATE_TELEFONO,entity, String.class);
            telefono = new JSONObject(response.getBody());
        }catch(ResourceAccessException r){
            System.out.println("Servicio no disponible");
        }
        return telefono;
    }

    //Get All telefonos
    public JSONArray get() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        JSONArray telephones = null;

        headers.setAccept(Collections.singletonList(MediaType.ALL));
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity entity = new HttpEntity(headers);

        try {
            ResponseEntity<String> allPersonas = restTemplate.exchange(GET_ALL_TELEFONOS, HttpMethod.GET, entity, String.class);
            telephones = new JSONArray(allPersonas.getBody());
        }catch (ResourceAccessException r){
            System.out.println("Servicio no disponible");
        }
        return telephones;
    }

    //Find by ID telefono
    public JSONObject byID(Integer cc) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.ALL));
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity entity = new HttpEntity(headers);
        RestTemplate restTemplate = new RestTemplate();
        JSONObject telefono = null;

        try {
            ResponseEntity<String> response = restTemplate.exchange(FIND_BY_ID_TELEFONO, HttpMethod.GET, entity, String.class, cc);
            telefono = new JSONObject(response.getBody());
        }catch(ResourceAccessException r){
            System.out.println("Servicio no disponible");
        }catch(RuntimeException e){
            System.out.println("Telefono no encontrada");
        }
        return telefono;
    }

    //Delete telefono
    public Boolean delete(Integer id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.ALL));
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity entity = new HttpEntity(headers);
        RestTemplate restTemplate = new RestTemplate();
        Boolean accepted = null;

        try {
            ResponseEntity<Boolean> response = restTemplate.exchange(DELETE_TELEFONO, HttpMethod.DELETE, entity, Boolean.class, id);
            accepted = response.getBody();
        }catch(ResourceAccessException r){
            System.out.println("Servicio no disponible");
        }
        return accepted;
    }

    //Count telefonos
    public Integer count() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        Integer number = null;

        headers.setAccept(Collections.singletonList(MediaType.ALL));
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity entity = new HttpEntity(headers);
        try {
            ResponseEntity<String> response = restTemplate.exchange(COUNT_TELEFONOS, HttpMethod.GET, entity, String.class);
            number = Integer. parseInt(response.getBody());
        }catch(ResourceAccessException r){
            System.out.println("Servicio no disponible");
        }

        return number;
    }
}
