package co.edu.javeriana.as.personapp.rest;

import co.edu.javeriana.as.personapp.core.domain.Genero;
import co.edu.javeriana.as.personapp.core.domain.Persona;
import co.edu.javeriana.as.personapp.rest.client.PersonaClient;
import co.edu.javeriana.as.personapp.rest.mapper.PersonaMapper;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;

public class MainRest {
    public static void main(String[] args) {
        PersonaClient personaclient = new PersonaClient();
        PersonaMapper personaMapper = new PersonaMapper();
        Persona persona = new Persona(123,"nombre", "apellido", Genero.valueOf("FEMENINO"), 3);
        //JSONObject obj = personaMapper.dePersonaAJSONObject(persona);
        //JSONObject ob = personaclient.create(obj);
        //Persona per = personaMapper.deJSONObjectAPersona(ob);
        //System.out.println(per);
        JSONObject cc = new JSONObject(123);
        JSONObject cd = new JSONObject(1);
        System.out.println("Get all");
        System.out.println(personaMapper.deJSONArrayAListPersona(personaclient.get()));
        System.out.println("Get id");
        System.out.println(personaMapper.deJSONObjectAPersona(personaclient.byID(cc)));
        System.out.println(personaMapper.deJSONObjectAPersona(personaclient.byID(cd)));
        System.out.println("Count");
        System.out.println(personaclient.count());
    }

}
