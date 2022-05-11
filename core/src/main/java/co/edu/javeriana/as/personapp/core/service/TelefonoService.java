package co.edu.javeriana.as.personapp.core.service;

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
        return null;
    }

    @Override
    public List<Telefono> buscarTodo() {
        return null;
    }

    @Override
    public Integer contar() {
        return null;
    }

    @Override
    public Telefono crear(Telefono telefono) {
        return null;
    }

    @Override
    public Telefono editar(Integer num, Telefono telefono) {
        return null;
    }

    @Override
    public Boolean eliminar(Integer num) {
        return null;
    }
}
