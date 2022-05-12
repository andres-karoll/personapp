package co.edu.javeriana.as.personapp.rest;

import co.edu.javeriana.as.personapp.core.domain.Genero;
import co.edu.javeriana.as.personapp.core.domain.Persona;
import co.edu.javeriana.as.personapp.rest.client.PersonaClient;
import co.edu.javeriana.as.personapp.rest.mapper.PersonaMapper;
import org.springframework.boot.SpringApplication;

public class MainRest {
    public static void main(String[] args) {
        PersonaClient personaclient = new PersonaClient();
        PersonaMapper personaMapper = new PersonaMapper();
        Persona persona = new Persona(123,"nombre", "apellido", Genero.valueOf("FEMENINO"), 3);
        personaclient.create(personaMapper.dePersonaAJSONObject(persona));
        //personaclient.create(persona);
    }

}
