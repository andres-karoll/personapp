package co.edu.javeriana.as.personapp.api.mapper;

import co.edu.javeriana.as.personapp.api.model.request.ProfesionRequest;
import co.edu.javeriana.as.personapp.api.model.response.ProfesionResponse;
import co.edu.javeriana.as.personapp.core.domain.Profesion;
import co.edu.javeriana.as.personapp.core.domain.Telefono;

public class ProfesionMapper {

    public ProfesionResponse deProfesionAProfesionResponse(Profesion request){
        return new ProfesionResponse(request.getId(), request.getNom(), request.getDes(), "OK");
    }
    public Profesion deProfesionRequestAProfesion(ProfesionRequest request){
        return new Telefono(request.getId(), request.getNom(), request.getDes());
    }
}
