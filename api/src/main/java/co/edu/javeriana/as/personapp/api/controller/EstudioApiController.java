package co.edu.javeriana.as.personapp.api.controller;

import co.edu.javeriana.as.personapp.api.adapter.EstudioApiAdapter;
import co.edu.javeriana.as.personapp.api.mapper.EstudioApiMapper;
import co.edu.javeriana.as.personapp.api.model.request.EstudioApiRequest;
import co.edu.javeriana.as.personapp.api.model.response.EstudioApiResponse;
import co.edu.javeriana.as.personapp.api.model.response.ApiResponse;
import co.edu.javeriana.as.personapp.core.domain.Estudio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController("/estudio")
public class EstudioApiController {
    @Autowired
    private EstudioApiAdapter estudioApiAdapter;
    @Autowired
    private EstudioApiMapper estudioApiMapper;

    @GetMapping(value = "", produces = { "application/json" })
    public List<EstudioApiResponse> get(){
        List<EstudioApiResponse> response = new ArrayList<>();
        for (Estudio estudio : estudioApiAdapter.buscarTodo()) {
            response.add(estudioApiMapper.deEstudioAEstudioResponse(estudio));
        }
        return response;
    }

    @GetMapping(value = "buscarPorId", produces = { "application/json" })
    public EstudioApiResponse buscarPorId(@RequestParam("idProfesion") int idP, @RequestParam("ccPersona") int ccP){
        EstudioApiResponse response = estudioApiMapper.deEstudioAEstudioResponse(estudioApiAdapter.buscarPorId(idP, ccP));
        return response;
    }

    @GetMapping(value = "contar", produces = { "application/json" })
    public ApiResponse contar(){
        ApiResponse apiResponse = new ApiResponse("OK", "Cantidad de estudios: " + estudioApiAdapter.contar(), LocalDateTime.now()) ;
        return apiResponse;
    }

    @GetMapping(value = "crear", produces = { "application/json" })
    public EstudioApiResponse crear(@RequestParam("idProfesion") int idP, @RequestParam("ccPersona") int ccP, @RequestParam("fecha") String fecha, @RequestParam("universidad") String universidad){
        EstudioApiRequest request = new EstudioApiRequest(idP, ccP, fecha, universidad);
        EstudioApiResponse response = estudioApiMapper.deEstudioAEstudioResponse(estudioApiAdapter.crear(estudioApiMapper.deEstudioRequestAEstudio(request)));
        return response;
    }

    @GetMapping(value = "eliminar", produces = { "application/json" })
    public ApiResponse deleteById(@RequestParam("idProfesion") int idP, @RequestParam("ccPersona") int ccP){
        if(estudioApiAdapter.eliminar(idP, ccP)){
            return new ApiResponse("OK", "Estudio eliminado", LocalDateTime.now());
        } else {
            return new ApiResponse("ERROR", "Estudio no eliminado", LocalDateTime.now());
        }
    }
}
