package co.edu.javeriana.as.personapp.rest.client;

import co.edu.javeriana.as.personapp.core.domain.Persona;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PersonaClient {

    private static final String GET_ALL_PERSONAS = "http://localhost:3000/personas/all";
    private static final String CREATE_PERSONA = "http://localhost:3000/personas/createPersonas";
    private static final String EDIT_PERSONA = "http://localhost:3000/personas/editPersonas";
    private static final String FIND_BY_ID_PERSONA = "http://localhost:3000/personas/find/{id}";
    private static final String DELETE_PERSONA = "http://localhost:3000/personas/deletePersonas/{id}";

    RestTemplate restTemplate = new RestTemplate();

    //Lo pido desde santiago
    //Get All personas
    public JSONArray get() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity entity = new HttpEntity("parameters", headers);
        ResponseEntity<String> allPersonas = restTemplate.exchange(GET_ALL_PERSONAS, HttpMethod.GET, entity, String.class);
        JSONArray list = new JSONArray(allPersonas);
        return list;
    }

    //Create persona
    public void create(Persona persona) {
        restTemplate.postForObject(CREATE_PERSONA, persona, Persona.class);
    }

    //Edit persona
    public JSONObject edit() {
        return null;
    }

    //Find by ID persona
    public JSONObject byID(Integer cc) {
        Map<String, Integer> param = new HashMap<>();
        param.put("cc", cc);
        JSONObject personita = restTemplate.getForObject(FIND_BY_ID_PERSONA, JSONObject.class, param);
        return personita;
    }

    //Delete persona
    public void delete(Integer cc) {
        Map<String, Integer> param = new HashMap<>();
        param.put("cc", cc);
        restTemplate.delete(DELETE_PERSONA, param);
    }

    //Count persona
    public void count() {

    }
}
