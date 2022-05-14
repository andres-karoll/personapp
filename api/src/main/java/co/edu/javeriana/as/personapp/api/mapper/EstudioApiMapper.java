package co.edu.javeriana.as.personapp.api.mapper;

import co.edu.javeriana.as.personapp.api.adapter.ProfesionApiAdapter;
import co.edu.javeriana.as.personapp.api.model.request.EstudioApiRequest;
import co.edu.javeriana.as.personapp.api.model.response.EstudioApiResponse;
import co.edu.javeriana.as.personapp.core.domain.Estudio;
import co.edu.javeriana.as.personapp.core.domain.Telefono;
import org.springframework.beans.factory.annotation.Autowired;

public class EstudioApiMapper {

    @Autowired
    private ProfesionApiAdapter profesionApiAdapter;

    public EstudioApiResponse deEstudioAEstudioResponse(Estudio request){
        return new EstudioApiResponse(request.getIdProfesion(), request.getCcPersona(), request.getFecha().toString(), request.getUniversidad(), request.getProfesion(), "OK");
    }
    public Estudio deEstudioRequestAEstudio(EstudioApiRequest request){
        return new Telefono(request.getIdProfesion(), request.getCcPersona(), request.getFecha(), request.getUniversidad(), profesionApiAdapter.buscarPorId(request.getIdProfesion()));
    }
}
