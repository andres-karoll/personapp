package co.edu.javeriana.as.personapp.api.controller;

import co.edu.javeriana.as.personapp.api.adapter.EstudioAdapter;
import co.edu.javeriana.as.personapp.api.mapper.EstudioMapper;
import co.edu.javeriana.as.personapp.api.model.request.EstudioRequest;
import co.edu.javeriana.as.personapp.api.model.response.EstudioResponse;
import co.edu.javeriana.as.personapp.api.model.response.Response;
import co.edu.javeriana.as.personapp.core.domain.Estudio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController("/estudio")
public class EstudioController {
    @Autowired
    private EstudioAdapter estudioAdapter;
    @Autowired
    private EstudioMapper estudioMapper;

    @GetMapping(value = "", produces = { "application/json" })
    public List<EstudioResponse> get(){
        List<EstudioResponse> response = new ArrayList<>();
        for (Estudio estudio : estudioAdapter.buscarTodo()) {
            response.add(estudioMapper.deEstudioAEstudioResponse(estudio));
        }
        return response;
    }

    @GetMapping(value = "buscarPorId", produces = { "application/json" })
    public EstudioResponse buscarPorId(@RequestParam("idProfesion") int idP, @RequestParam("ccPersona") int ccP){
        EstudioResponse response = estudioMapper.deEstudioAEstudioResponse(estudioAdapter.buscarPorId(idP, ccP));
        return response;
    }

    @GetMapping(value = "contar", produces = { "application/json" })
    public Response contar(){
        Response response = new Response("OK", "Cantidad de estudios: " + estudioAdapter.contar(), LocalDateTime.now()) ;
        return response;
    }

    @GetMapping(value = "crear", produces = { "application/json" })
    public EstudioResponse crear(@RequestParam("idProfesion") int idP, @RequestParam("ccPersona") int ccP, @RequestParam("fecha") String fecha, @RequestParam("universidad") String universidad, @RequestParam("profesion") String profesion){
        EstudioRequest request = new EstudioRequest(idP, ccP, fecha, universidad, profesion);
        EstudioResponse response = estudioMapper.deEstudioAEstudioResponse(estudioAdapter.crear(estudioMapper.deEstudioRequestAEstudio(request)));
        return response;
    }

    @GetMapping(value = "eliminar", produces = { "application/json" })
    public Response deleteById(@RequestParam("idProfesion") int idP, @RequestParam("ccPersona") int ccP){
        if(estudioAdapter.eliminar(idP, ccP)){
            return new Response("OK", "Estudio eliminado", LocalDateTime.now());
        } else {
            return new Response("ERROR", "Estudio no eliminado", LocalDateTime.now());
        }
    }
}
