package co.edu.javeriana.as.personapp.api.controller;

import co.edu.javeriana.as.personapp.api.adapter.TelefonoApiAdapter;
import co.edu.javeriana.as.personapp.api.mapper.TelefonoApiMapper;
import co.edu.javeriana.as.personapp.api.model.request.TelefonoApiRequest;
import co.edu.javeriana.as.personapp.api.model.response.ApiResponse;
import co.edu.javeriana.as.personapp.api.model.response.TelefonoApiResponse;
import co.edu.javeriana.as.personapp.core.domain.Telefono;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController("/telefono")
public class TelefonoApiController {
    @Autowired
    private TelefonoApiAdapter telefonoApiAdapter;
    @Autowired
    private TelefonoApiMapper telefonoApiMapper;


    @GetMapping(value = "", produces = { "application/json" })
    public List<TelefonoApiResponse> get(){
        List<TelefonoApiResponse> response = new ArrayList<>();
        for (Telefono telefono : telefonoApiAdapter.buscarTodo()) {
            response.add(telefonoApiMapper.deTelefonoATelefonoResponse(telefono));
        }
        return response;
    }

    @GetMapping(value = "buscarPorId", produces = { "application/json" })
    public TelefonoApiResponse buscarPorId(@RequestParam("num") int num){
        TelefonoApiResponse response = telefonoApiMapper.deTelefonoATelefonoResponse(telefonoApiAdapter.buscarPorId(num));
        return response;
    }

    @GetMapping(value = "contar", produces = { "application/json" })
    public ApiResponse contar(){
        ApiResponse apiResponse = new ApiResponse("OK", "Cantidad de telefonos: " + telefonoApiAdapter.contar(), LocalDateTime.now()) ;
        return apiResponse;
    }
    @GetMapping(value = "crear", produces = { "application/json" })
    public TelefonoApiResponse crear(@RequestParam("numero") String numero, @RequestParam("tipo") String tipo, @RequestParam("idPersona") int idPersona){
        TelefonoApiRequest request = new TelefonoApiRequest(numero, tipo, idPersona);
        TelefonoApiResponse response = telefonoApiMapper.deTelefonoATelefonoResponse(telefonoApiAdapter.crear(telefonoApiMapper.deTelefonoRequestATelefono(request)));
        return response;
    }

    @GetMapping(value = "eliminar", produces = { "application/json" })
    public ApiResponse deleteById(@RequestParam("num") int num) {
        if(telefonoApiAdapter.eliminar(num)){
            return new ApiResponse("OK", "Telefono eliminada", LocalDateTime.now());
        } else {
            return new ApiResponse("ERROR", "Telefono no eliminada", LocalDateTime.now());
        }
    }
}
