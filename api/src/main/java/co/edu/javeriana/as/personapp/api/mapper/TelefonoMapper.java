package co.edu.javeriana.as.personapp.api.mapper;

import co.edu.javeriana.as.personapp.api.adapter.PersonaAdapter;
import co.edu.javeriana.as.personapp.api.model.request.TelefonoRequest;
import co.edu.javeriana.as.personapp.api.model.response.PersonaResponse;
import co.edu.javeriana.as.personapp.api.model.response.TelefonoResponse;
import co.edu.javeriana.as.personapp.core.domain.Persona;
import co.edu.javeriana.as.personapp.core.domain.Telefono;
import org.springframework.beans.factory.annotation.Autowired;

public class TelefonoMapper {

    @Autowired
    private PersonaAdapter personaAdapter;

    public TelefonoResponse deTelefonoATelefonoResponse(Telefono request){
        return new TelefonoResponse(request.getNum(), request.getOper(), request.getDuenio().getCc(), "OK");
    }
    public Telefono deTelefonoRequestATelefono(TelefonoRequest request){
        return new Telefono(request.getNum(), request.getOper(), personaAdapter.buscarPersonaPorId(request.getCcDuenio()));
    }
}
