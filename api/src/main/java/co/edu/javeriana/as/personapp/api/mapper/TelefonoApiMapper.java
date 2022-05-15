package co.edu.javeriana.as.personapp.api.mapper;

import co.edu.javeriana.as.personapp.api.adapter.PersonaApiAdapter;
import co.edu.javeriana.as.personapp.api.model.request.TelefonoApiRequest;
import co.edu.javeriana.as.personapp.api.model.response.TelefonoApiResponse;
import co.edu.javeriana.as.personapp.core.domain.Telefono;
import org.springframework.beans.factory.annotation.Autowired;

public class TelefonoApiMapper {

    @Autowired
    private PersonaApiAdapter personaApiAdapter;

    public TelefonoApiResponse deTelefonoATelefonoResponse(Telefono request){
        return new TelefonoApiResponse(request.getNum(), request.getOper(), request.getDuenio().getCc(), "OK");
    }
    public Telefono deTelefonoRequestATelefono(TelefonoApiRequest request){
        return new Telefono(request.getNum(), request.getOper(), personaApiAdapter.buscarPersonaPorId(request.getCcDuenio()));
    }
}
