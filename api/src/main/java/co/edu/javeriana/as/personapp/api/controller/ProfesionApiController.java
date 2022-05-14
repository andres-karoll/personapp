package co.edu.javeriana.as.personapp.api.controller;

import co.edu.javeriana.as.personapp.api.adapter.ProfesionApiAdapter;
import co.edu.javeriana.as.personapp.api.mapper.ProfesionApiMapper;
import co.edu.javeriana.as.personapp.api.model.request.ProfesionApiRequest;
import co.edu.javeriana.as.personapp.api.model.response.ProfesionApiResponse;
import co.edu.javeriana.as.personapp.api.model.response.ApiResponse;
import co.edu.javeriana.as.personapp.core.domain.Profesion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController("/profesion")
public class ProfesionApiController {
    @Autowired
    private ProfesionApiAdapter profesionApiAdapter;
    @Autowired
    private ProfesionApiMapper profesionApiMapper;

    @GetMapping(value = "", produces = { "application/json" })
    public List<ProfesionApiResponse> get(){
        List<ProfesionApiResponse> response = new ArrayList<>();
        for (Profesion profesion : profesionApiAdapter.buscarTodo()) {
            response.add(profesionApiMapper.deProfesionAProfesionResponse(profesion));
        }
        return response;
    }

    @GetMapping(value = "buscarPorId", produces = { "application/json" })
    public ProfesionApiResponse buscarPorId(@RequestParam("num") int num){
        ProfesionApiResponse response = profesionApiMapper.deProfesionAProfesionResponse(profesionApiAdapter.buscarPorId(num));
        return response;
    }

    @GetMapping(value = "contar", produces = { "application/json" })
    public ApiResponse contar(){
        ApiResponse apiResponse = new ApiResponse("OK", "Cantidad de profesiones: " + profesionApiAdapter.contar(), LocalDateTime.now()) ;
        return apiResponse;
    }
    @GetMapping(value = "crear", produces = { "application/json" })
    public ProfesionApiResponse crear(@RequestParam("id") int id, @RequestParam("nombre") String nombre, @RequestParam("descripcion") String descripcion){
        ProfesionApiRequest request = new ProfesionApiRequest(id, nombre, descripcion);
        ProfesionApiResponse response = profesionApiMapper.deProfesionAProfesionResponse(profesionApiAdapter.crear(profesionApiMapper.deProfesionRequestAProfesion(request)));
        return response;
    }

    @GetMapping(value = "eliminar", produces = { "application/json" })
    public ApiResponse deleteById(@RequestParam("num") int num) {
        if(profesionApiAdapter.eliminar(num)){
            return new ApiResponse("OK", "Telefono eliminada", LocalDateTime.now());
        } else {
            return new ApiResponse("ERROR", "Telefono no eliminada", LocalDateTime.now());
        }
    }
}
