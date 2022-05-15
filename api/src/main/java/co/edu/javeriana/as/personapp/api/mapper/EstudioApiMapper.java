package co.edu.javeriana.as.personapp.api.mapper;

import co.edu.javeriana.as.personapp.api.adapter.ProfesionApiAdapter;
import co.edu.javeriana.as.personapp.api.model.request.EstudioApiRequest;
import co.edu.javeriana.as.personapp.api.model.response.EstudioApiResponse;
import co.edu.javeriana.as.personapp.core.domain.Estudio;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EstudioApiMapper {

    @Autowired
    private ProfesionApiAdapter profesionApiAdapter;

    public EstudioApiResponse deEstudioAEstudioResponse(Estudio request){
        return new EstudioApiResponse(request.getIdProfesion(), request.getCcPersona(), request.getFecha().toString(), request.getUniversidad(), "OK");
    }
    public Estudio deEstudioRequestAEstudio(EstudioApiRequest request){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        return new Estudio(request.getIdProfesion(), request.getCcPersona(), LocalDate.parse(request.getFecha(), formatter), request.getUniversidad());
    }
}
