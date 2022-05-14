package co.edu.javeriana.as.personapp.api.controller;


import co.edu.javeriana.as.personapp.api.adapter.PersonaApiAdapter;
import co.edu.javeriana.as.personapp.api.mapper.PersonaApiMapper;
import co.edu.javeriana.as.personapp.api.model.request.PersonaApiRequest;
import co.edu.javeriana.as.personapp.api.model.response.PersonaApiResponse;
import co.edu.javeriana.as.personapp.api.model.response.ApiResponse;
import co.edu.javeriana.as.personapp.core.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController("/persona")
public class PersonaApiController {
    @Autowired
    private PersonaApiAdapter personaApiAdapter;
    @Autowired
    private PersonaApiMapper personaApiMapper;

    @GetMapping(value = "", produces = { "application/json" })
    public List<PersonaApiResponse> get(){
        List<PersonaApiResponse> response = new ArrayList<>();
        for (Persona persona : personaApiAdapter.buscarPersonas()) {
            response.add(personaApiMapper.dePersonaAPersonaResponse(persona));
        }
        return response;
    }

    @GetMapping(value = "getById", produces = { "application/json" })
    public PersonaApiResponse getById(@RequestParam("id") int cc){
        PersonaApiResponse response = personaApiMapper.dePersonaAPersonaResponse(personaApiAdapter.buscarPersonaPorId(cc));
        return response;
    }

    @GetMapping(value = "count", produces = { "application/json" })
    public ApiResponse count(){
        ApiResponse apiResponse = new ApiResponse("OK", "Cantidad de personas: " + personaApiAdapter.contarPersonas(), LocalDateTime.now()) ;
        return apiResponse;
    }
    @GetMapping(value = "create", produces = { "application/json" })
    public PersonaApiResponse create(@RequestParam("dni") String dni, @RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("age") String age, @RequestParam("sex") String sex){
        PersonaApiRequest request = new PersonaApiRequest(dni, firstName, lastName, age, sex);
        PersonaApiResponse response = personaApiAdapter.crearPersona(request);
        return response;
    }

    @GetMapping(value = "deleteById", produces = { "application/json" })
    public ApiResponse deleteById(@RequestParam("id") int idPersona) {
        if(personaApiAdapter.eliminarPersona(idPersona)){
            return new ApiResponse("OK", "Persona eliminada", LocalDateTime.now());
        } else {
            return new ApiResponse("ERROR", "Persona no eliminada", LocalDateTime.now());
        }
    }
}
