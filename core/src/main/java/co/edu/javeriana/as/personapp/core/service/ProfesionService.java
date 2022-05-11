package co.edu.javeriana.as.personapp.core.service;

import co.edu.javeriana.as.personapp.core.domain.Profesion;
import co.edu.javeriana.as.personapp.core.port.out.mongo.ProfesionMongoDBPort;
import co.edu.javeriana.as.personapp.core.port.out.mysql.ProfesionMySQLPort;
import co.edu.javeriana.as.personapp.core.port.out.rest.PersonaRestPort;
import co.edu.javeriana.as.personapp.core.port.out.rest.ProfesionRestPort;
import co.edu.javeriana.as.personapp.core.usecase.ProfesionUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesionService implements ProfesionUseCase {
    @Autowired
    ProfesionMongoDBPort profesionMongoDBPort;

    @Autowired
    ProfesionMySQLPort profesionMySQLPort;

    @Autowired
    ProfesionRestPort profesionRestPort;

    @Override
    public Profesion buscarPorId(Integer id) {
        return null;
    }

    @Override
    public List<Profesion> buscarTodo() {
        return null;
    }

    @Override
    public Integer contar() {
        return null;
    }

    @Override
    public Profesion crear(Profesion profesion) {
        return null;
    }

    @Override
    public Profesion editar(Integer id, Profesion profesion) {
        return null;
    }

    @Override
    public Boolean eliminar(Integer is) {
        return null;
    }
}
