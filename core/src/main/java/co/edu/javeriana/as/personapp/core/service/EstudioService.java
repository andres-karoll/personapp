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
        Estudio mongo = estudioMongoDBPort.findByIdProfCcPer(idProfesion, ccPersona);
        Estudio mySQL = estudioMySQLPort.findByIdProfCcPer(idProfesion, ccPersona);
        Estudio rest = estudioRestPort.findByIdProfCcPer(idProfesion, ccPersona);

        if(mongo.equals(rest) && mongo.equals(mySQL))
            return mongo;

        return null;
    }

    @Override
    public List<Estudio> buscarTodo() {
        List<Estudio> mongo = estudioMongoDBPort.findAll();
        List<Estudio> mySQL = estudioMySQLPort.findAll();
        List<Estudio> rest = estudioRestPort.findAll();

        if(
                (mongo.size() == mySQL.size() && rest.size() == mySQL.size())
                && (mongo.equals(mySQL) && mongo.equals(rest))
        ) {
            return mongo;
        }

        return null;
    }

    @Override
    public Integer contar() {
        Integer mongo = estudioMongoDBPort.count();
        Integer mySQL = estudioMySQLPort.count();
        Integer rest = estudioRestPort.count();

        if(mongo == mySQL && mongo == rest)
            return rest;

        return null;
    }

    @Override
    public Estudio crear(Estudio estudio) {
        Estudio mongo = estudioMongoDBPort.save(estudio);
        Estudio mySQL = estudioMySQLPort.save(estudio);
        Estudio rest = estudioRestPort.save(estudio);

        if(mongo != null && mySQL != null && rest != null)
            return mongo;

        return null;
    }

    @Override
    public Estudio editar(Integer idProfesion, Integer ccPersona, Estudio estudio) {
        Estudio mongo = estudioMongoDBPort.save(estudio);
        Estudio mySQL = estudioMySQLPort.save(estudio);
        Estudio rest = estudioRestPort.save(estudio);

        if(mongo != null && mySQL != null && rest != null)
            return mongo;

        return null;
    }

    @Override
    public Boolean eliminar(Integer idProfesion, Integer ccPersona) {
        Boolean mongo = estudioMongoDBPort.delete(idProfesion, ccPersona);
        Boolean mySQL = estudioMySQLPort.delete(idProfesion, ccPersona);
        Boolean rest = estudioRestPort.delete(idProfesion, ccPersona);

        if(mongo && mySQL && rest)
            return mongo;

        return false;
    }
}
