package co.edu.javeriana.as.personapp.core.service;

import co.edu.javeriana.as.personapp.core.port.out.mongo.ProfesionMongoDBPort;
import co.edu.javeriana.as.personapp.core.port.out.mysql.ProfesionMySQLPort;
import co.edu.javeriana.as.personapp.core.port.out.rest.PersonaRestPort;
import co.edu.javeriana.as.personapp.core.port.out.rest.ProfesionRestPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfesionService {
    @Autowired
    ProfesionMongoDBPort profesionMongoDBPort;

    @Autowired
    ProfesionMySQLPort profesionMySQLPort;

    @Autowired
    ProfesionRestPort profesionRestPort;
}
