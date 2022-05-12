package co.edu.javeriana.as.personapp.api.mapper;

import co.edu.javeriana.as.personapp.api.adapter.ProfesionAdapter;
import co.edu.javeriana.as.personapp.api.model.request.EstudioRequest;
import co.edu.javeriana.as.personapp.api.model.response.EstudioResponse;
import co.edu.javeriana.as.personapp.core.domain.Estudio;
import co.edu.javeriana.as.personapp.core.domain.Telefono;
import org.springframework.beans.factory.annotation.Autowired;

public class EstudioMapper {

    @Autowired
    private ProfesionAdapter profesionAdapter;

    public EstudioResponse deEstudioAEstudioResponse(Estudio request){
        return new EstudioResponse(request.getIdProfesion(), request.getCcPersona(), request.getFecha().toString(), request.getUniversidad(), request.getProfesion(), "OK");
    }
    public Estudio deEstudioRequestAEstudio(EstudioRequest request){
        return new Telefono(request.getIdProfesion(), request.getCcPersona(), request.getFecha(), request.getUniversidad(), profesionAdapter.buscarPorId(request.getIdProfesion()));
    }
}
