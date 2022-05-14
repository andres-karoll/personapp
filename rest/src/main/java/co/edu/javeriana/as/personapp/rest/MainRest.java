package co.edu.javeriana.as.personapp.rest;

import co.edu.javeriana.as.personapp.core.domain.Genero;
import co.edu.javeriana.as.personapp.core.domain.Persona;
import co.edu.javeriana.as.personapp.rest.client.PersonaRestClient;
import co.edu.javeriana.as.personapp.rest.mapper.PersonaRestMapper;

import java.time.LocalDate;

public class MainRest {
    public static void main(String[] args) {
        PersonaRestClient personaclient = new PersonaRestClient();
        PersonaRestMapper personaRestMapper = new PersonaRestMapper();
        Persona persona = new Persona(123,"nombre", "apellido", Genero.valueOf("FEMENINO"), 3);
        //JSONObject obj = personaMapper.dePersonaAJSONObject(persona);
        //JSONObject ob = personaclient.create(obj);
        //Persona per = personaMapper.deJSONObjectAPersona(ob);
        //System.out.println(per);
        //System.out.println("Get all");
        //System.out.println(personaMapper.deJSONArrayAListPersona(personaclient.get()));
        //System.out.println("Get id");
        //System.out.println(personaMapper.deJSONObjectAPersona(personaclient.byID(123)));
        //System.out.println(personaMapper.deJSONObjectAPersona(personaclient.byID(1)));
        System.out.println(LocalDate.now());
        //System.out.println(personaclient.count());
        //System.out.println("Delete");
        //System.out.println(personaclient.delete(66));
    }

}
