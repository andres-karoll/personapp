package co.edu.javeriana.as.personapp.api.controller;

import co.edu.javeriana.as.personapp.api.adapter.TelefonoAdapter;
import co.edu.javeriana.as.personapp.api.mapper.TelefonoMapper;
import co.edu.javeriana.as.personapp.api.model.request.PersonaRequest;
import co.edu.javeriana.as.personapp.api.model.request.TelefonoRequest;
import co.edu.javeriana.as.personapp.api.model.response.PersonaResponse;
import co.edu.javeriana.as.personapp.api.model.response.Response;
import co.edu.javeriana.as.personapp.api.model.response.TelefonoResponse;
import co.edu.javeriana.as.personapp.core.domain.Persona;
import co.edu.javeriana.as.personapp.core.domain.Telefono;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController("/telefono")
public class TelefonoController {
    @Autowired
    private TelefonoAdapter telefonoAdapter;
    @Autowired
    private TelefonoMapper telefonoMapper;


    @GetMapping(value = "", produces = { "application/json" })
    public List<TelefonoResponse> get(){
        List<TelefonoResponse> response = new ArrayList<>();
        for (Telefono telefono : telefonoAdapter.buscarTodo()) {
            response.add(telefonoMapper.deTelefonoATelefonoResponse(telefono));
        }
        return response;
    }

    @GetMapping(value = "buscarPorId", produces = { "application/json" })
    public TelefonoResponse buscarPorId(@RequestParam("num") int num){
        TelefonoResponse response = telefonoMapper.deTelefonoATelefonoResponse(telefonoAdapter.buscarPorId(num));
        return response;
    }

    @GetMapping(value = "contar", produces = { "application/json" })
    public Response contar(){
        Response response = new Response("OK", "Cantidad de telefonos: " + telefonoAdapter.contar(), LocalDateTime.now()) ;
        return response;
    }
    @GetMapping(value = "crear", produces = { "application/json" })
    public TelefonoResponse crear(@RequestParam("numero") String numero, @RequestParam("tipo") String tipo, @RequestParam("idPersona") int idPersona){
        TelefonoRequest request = new TelefonoRequest(numero, tipo, idPersona);
        TelefonoResponse response = telefonoMapper.deTelefonoATelefonoResponse(telefonoAdapter.crear(telefonoMapper.deTelefonoRequestATelefono(request)));
        return response;
    }

    @GetMapping(value = "eliminar", produces = { "application/json" })
    public Response deleteById(@RequestParam("num") int num) {
        if(telefonoAdapter.eliminar(num)){
            return new Response("OK", "Telefono eliminada", LocalDateTime.now());
        } else {
            return new Response("ERROR", "Telefono no eliminada", LocalDateTime.now());
        }
    }
}
