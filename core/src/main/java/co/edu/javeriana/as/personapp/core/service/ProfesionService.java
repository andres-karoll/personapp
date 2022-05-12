package co.edu.javeriana.as.personapp.core.service;

import co.edu.javeriana.as.personapp.core.domain.Estudio;
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
        Profesion mongo = profesionMongoDBPort.findById(id);
        Profesion mySQL = profesionMySQLPort.findById(id);
        Profesion rest = profesionRestPort.findById(id);

        if(mongo.equals(rest) && mongo.equals(mySQL))
            return mongo;

        return null;
    }

    @Override
    public List<Profesion> buscarTodo() {
        List<Profesion> mongo = profesionMongoDBPort.findAll();
        List<Profesion> mySQL = profesionMySQLPort.findAll();
        List<Profesion> rest = profesionRestPort.findAll();

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
        Integer mongo = profesionMongoDBPort.count();
        Integer mySQL = profesionMySQLPort.count();
        Integer rest = profesionRestPort.count();

        if(mongo == mySQL && mongo == rest)
            return rest;

        return null;
    }

    @Override
    public Profesion crear(Profesion profesion) {
        Profesion mongo = profesionMongoDBPort.save(profesion);
        Profesion mySQL = profesionMySQLPort.save(profesion);
        Profesion rest = profesionRestPort.save(profesion);

        if(mongo != null && mySQL != null && rest != null)
            return mongo;

        return null;
    }

    @Override
    public Profesion editar(Integer id, Profesion profesion) {
        Profesion mongo = profesionMongoDBPort.save(profesion);
        Profesion mySQL = profesionMySQLPort.save(profesion);
        Profesion rest = profesionRestPort.save(profesion);

        if(mongo != null && mySQL != null && rest != null)
            return mongo;

        return null;
    }

    @Override
    public Boolean eliminar(Integer is) {
        Boolean mongo = profesionMongoDBPort.delete(is);
        Boolean mySQL = profesionMySQLPort.delete(is);
        Boolean rest = profesionRestPort.delete(is);

        if(mongo && mySQL && rest)
            return mongo;

        return false;
    }
}
