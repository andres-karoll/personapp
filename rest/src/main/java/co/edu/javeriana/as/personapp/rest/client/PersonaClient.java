package co.edu.javeriana.as.personapp.rest.client;

import co.edu.javeriana.as.personapp.core.domain.Persona;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONString;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.util.*;

public class PersonaClient {

    private static final String GET_ALL_PERSONAS = "http://localhost:3000/personas/all";
    private static final String CREATE_PERSONA = "http://localhost:3000/personas/createPersonas";
    private static final String EDIT_PERSONA = "http://localhost:3000/personas/editPersonas";
    private static final String FIND_BY_ID_PERSONA = "http://localhost:3000/personas/find/{id}";
    private static final String DELETE_PERSONA = "http://localhost:3000/personas/deletePersonas/{id}";
    
    //Get All personas
    public JSONArray get() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity entity = new HttpEntity("parameters", headers);
        //ResponseEntity<String> allPersonas = restTemplate.exchange(GET_ALL_PERSONAS, HttpMethod.GET, entity, String.class);
        JSONArray list = new JSONArray(/*allPersonas*/);
        return list;
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
    public JSONObject edit(Persona persona) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity entity = new HttpEntity("parameters", headers);
        //ResponseEntity<String> personita = restTemplate.exchange(EDIT_PERSONA, HttpMethod.PUT, entity, String.class, persona);
        JSONObject person = new JSONObject(/*personita*/);
        return person;
    }

    //Find by ID persona
    public JSONObject byID(Integer cc) {
        Map<String, Integer> param = new HashMap<>();
        param.put("cc", cc);
        //JSONObject personita = restTemplate.getForObject(FIND_BY_ID_PERSONA, JSONObject.class, param);
        return null;
    }

    //Delete persona
    public void delete(Integer cc) {
        Map<String, Integer> param = new HashMap<>();
        param.put("cc", cc);
        //restTemplate.delete(DELETE_PERSONA, param);
    }

    //Count persona
    public JSONObject count() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity entity = new HttpEntity("parameters", headers);
       // ResponseEntity<String> personita = restTemplate.exchange(EDIT_PERSONA, HttpMethod.PUT, entity, String.class);
        JSONObject number = new JSONObject(/*personita*/);
        return number;
    }
}
