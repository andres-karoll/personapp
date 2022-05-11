package co.edu.javeriana.as.personapp.core.service;

import co.edu.javeriana.as.personapp.core.domain.Estudio;
import co.edu.javeriana.as.personapp.core.port.out.mongo.EstudioMongoDBPort;
import co.edu.javeriana.as.personapp.core.port.out.mysql.EstudioMySQLPort;
import co.edu.javeriana.as.personapp.core.port.out.rest.EstudioRestPort;
import co.edu.javeriana.as.personapp.core.usecase.EstudioUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudioService implements EstudioUseCase {
    @Autowired
    EstudioMongoDBPort estudioMongoDBPort;

    @Autowired
    EstudioMySQLPort estudioMySQLPort;

    @Autowired
    EstudioRestPort estudioRestPort;

    @Override
    public Estudio buscarPorId(Integer idProfesion, Integer ccPersona) {
        return null;
    }

    @Override
    public List<Estudio> buscarTodo() {
        return null;
    }

    @Override
    public Integer contar() {
        return null;
    }

    @Override
    public Estudio crear(Estudio estudio) {
        return null;
    }

    @Override
    public Estudio editar(Integer idProfesion, Integer ccPersona, Estudio estudio) {
        return null;
    }

    @Override
    public Boolean eliminar(Integer idProfesion, Integer ccPersona) {
        return null;
    }
}
