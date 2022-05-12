package co.edu.javeriana.as.personapp.core.service;

import co.edu.javeriana.as.personapp.core.domain.Persona;
import co.edu.javeriana.as.personapp.core.domain.Telefono;
import co.edu.javeriana.as.personapp.core.port.out.mongo.TelefonoMongoDBPort;
import co.edu.javeriana.as.personapp.core.port.out.mysql.TelefonoMySQLPort;
import co.edu.javeriana.as.personapp.core.port.out.rest.TelefonoRestPort;
import co.edu.javeriana.as.personapp.core.usecase.TelefonoUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelefonoService implements TelefonoUseCase {
    @Autowired
    TelefonoMongoDBPort telefonoMongoDBPort;

    @Autowired
    TelefonoMySQLPort telefonoMySQLPort;

    @Autowired
    TelefonoRestPort telefonoRestPort;

    @Override
    public Telefono buscarPorId(Integer num) {
        Telefono mongo = telefonoMongoDBPort.findByNum(num);
        Telefono mySQL = telefonoMySQLPort.findByNum(num);
        Telefono rest = telefonoRestPort.findByNum(num);

        if(mongo.equals(rest) && mongo.equals(mySQL))
            return mongo;

        return null;
    }

    @Override
    public List<Telefono> buscarTodo() {
        List<Telefono> mongo = telefonoMongoDBPort.findAll();
        List<Telefono> mySQL = telefonoMySQLPort.findAll();
        List<Telefono> rest = telefonoRestPort.findAll();

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
        Integer mongo = telefonoMongoDBPort.count();
        Integer mySQL = telefonoMySQLPort.count();
        Integer rest = telefonoRestPort.count();

        if(mongo == mySQL && mongo == rest)
            return rest;

        return null;
    }

    @Override
    public Telefono crear(Telefono telefono) {
        Telefono mongo = telefonoMongoDBPort.save(telefono);
        Telefono mySQL = telefonoMySQLPort.save(telefono);
        Telefono rest = telefonoRestPort.save(telefono);

        if(mongo != null && mySQL != null && rest != null)
            return mongo;

        return null;
    }

    @Override
    public Telefono editar(Integer num, Telefono telefono) {
        Telefono mongo = telefonoMongoDBPort.save(telefono);
        Telefono mySQL = telefonoMySQLPort.save(telefono);
        Telefono rest = telefonoRestPort.save(telefono);

        if(mongo != null && mySQL != null && rest != null)
            return mongo;

        return null;
    }

    @Override
    public Boolean eliminar(Integer num) {
        Boolean mongo = telefonoMongoDBPort.delete(num);
        Boolean mySQL = telefonoMySQLPort.delete(num);
        Boolean rest = telefonoRestPort.delete(num);

        if(mongo && mySQL && rest)
            return mongo;

        return false;
    }
}
