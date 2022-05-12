package co.edu.javeriana.as.personapp.api.controller;


import co.edu.javeriana.as.personapp.api.adapter.PersonaAdapter;
import co.edu.javeriana.as.personapp.api.mapper.PersonaMapper;
import co.edu.javeriana.as.personapp.api.model.request.PersonaRequest;
import co.edu.javeriana.as.personapp.api.model.response.PersonaResponse;
import co.edu.javeriana.as.personapp.api.model.response.Response;
import co.edu.javeriana.as.personapp.core.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController("/persona")
public class PersonaController {
    @Autowired
    private PersonaAdapter personaAdapter;
    @Autowired
    private PersonaMapper personaMapper;

    @GetMapping(value = "", produces = { "application/json" })
    public List<PersonaResponse> get(){
        List<PersonaResponse> response = new ArrayList<>();
        for (Persona persona : personaAdapter.buscarPersonas()) {
            response.add(personaMapper.dePersonaAPersonaResponse(persona));
        }
        return response;
    }

    @GetMapping(value = "getById", produces = { "application/json" })
    public PersonaResponse getById(@RequestParam("id") int cc){
        PersonaResponse response = personaMapper.dePersonaAPersonaResponse(personaAdapter.buscarPersonaPorId(cc));
        return response;
    }

    @GetMapping(value = "count", produces = { "application/json" })
    public Response count(){
        Response response = new Response("OK", "Cantidad de personas: " + personaAdapter.contarPersonas(), LocalDateTime.now()) ;
        return response;
    }
    @GetMapping(value = "create", produces = { "application/json" })
    public PersonaResponse create(@RequestParam("dni") String dni, @RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("age") String age, @RequestParam("sex") String sex){
        PersonaRequest request = new PersonaRequest(dni, firstName, lastName, age, sex);
        PersonaResponse response = personaAdapter.crearPersona(request);
        return response;
    }

    @GetMapping(value = "deleteById", produces = { "application/json" })
    public Response deleteById(@RequestParam("id") int idPersona) {
        if(personaAdapter.eliminarPersona(idPersona)){
            return new Response("OK", "Persona eliminada", LocalDateTime.now());
        } else {
            return new Response("ERROR", "Persona no eliminada", LocalDateTime.now());
        }
    }
}
