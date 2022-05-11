package co.edu.javeriana.as.personapp.core.service;

import co.edu.javeriana.as.personapp.core.port.out.mongo.TelefonoMongoDBPort;
import co.edu.javeriana.as.personapp.core.port.out.mysql.TelefonoMySQLPort;
import co.edu.javeriana.as.personapp.core.port.out.rest.TelefonoRestPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TelefonoService {
    @Autowired
    TelefonoMongoDBPort telefonoMongoDBPort;

    @Autowired
    TelefonoMySQLPort telefonoMySQLPort;

    @Autowired
    TelefonoRestPort telefonoRestPort;
}
