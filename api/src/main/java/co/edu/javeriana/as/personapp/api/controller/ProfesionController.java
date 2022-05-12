package co.edu.javeriana.as.personapp.api.controller;

import co.edu.javeriana.as.personapp.api.adapter.ProfesionAdapter;
import co.edu.javeriana.as.personapp.api.mapper.ProfesionMapper;
import co.edu.javeriana.as.personapp.api.model.request.ProfesionRequest;
import co.edu.javeriana.as.personapp.api.model.response.ProfesionResponse;
import co.edu.javeriana.as.personapp.api.model.response.Response;
import co.edu.javeriana.as.personapp.core.domain.Profesion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController("/profesion")
public class ProfesionController {
    @Autowired
    private ProfesionAdapter profesionAdapter;
    @Autowired
    private ProfesionMapper profesionMapper;

    @GetMapping(value = "", produces = { "application/json" })
    public List<ProfesionResponse> get(){
        List<ProfesionResponse> response = new ArrayList<>();
        for (Profesion profesion : profesionAdapter.buscarTodo()) {
            response.add(profesionMapper.deProfesionAProfesionResponse(profesion));
        }
        return response;
    }

    @GetMapping(value = "buscarPorId", produces = { "application/json" })
    public ProfesionResponse buscarPorId(@RequestParam("num") int num){
        ProfesionResponse response = profesionMapper.deProfesionAProfesionResponse(profesionAdapter.buscarPorId(num));
        return response;
    }

    @GetMapping(value = "contar", produces = { "application/json" })
    public Response contar(){
        Response response = new Response("OK", "Cantidad de profesiones: " + profesionAdapter.contar(), LocalDateTime.now()) ;
        return response;
    }
    @GetMapping(value = "crear", produces = { "application/json" })
    public ProfesionResponse crear(@RequestParam("id") int id, @RequestParam("nombre") String nombre, @RequestParam("descripcion") String descripcion){
        ProfesionRequest request = new ProfesionRequest(id, nombre, descripcion);
        ProfesionResponse response = profesionMapper.deProfesionAProfesionResponse(profesionAdapter.crear(profesionMapper.deProfesionRequestAProfesion(request)));
        return response;
    }

    @GetMapping(value = "eliminar", produces = { "application/json" })
    public Response deleteById(@RequestParam("num") int num) {
        if(profesionAdapter.eliminar(num)){
            return new Response("OK", "Telefono eliminada", LocalDateTime.now());
        } else {
            return new Response("ERROR", "Telefono no eliminada", LocalDateTime.now());
        }
    }
}
