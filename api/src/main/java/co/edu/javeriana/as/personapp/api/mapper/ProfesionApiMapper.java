package co.edu.javeriana.as.personapp.api.mapper;

import co.edu.javeriana.as.personapp.api.model.request.ProfesionApiRequest;
import co.edu.javeriana.as.personapp.api.model.response.ProfesionApiResponse;
import co.edu.javeriana.as.personapp.core.domain.Profesion;

public class ProfesionApiMapper {

    public ProfesionApiResponse deProfesionAProfesionResponse(Profesion request){
        return new ProfesionApiResponse(request.getId(), request.getNom(), request.getDes(), "OK");
    }
    public Profesion deProfesionRequestAProfesion(ProfesionApiRequest request){
        return new Profesion(request.getId(), request.getNom(), request.getDes());
    }
}
