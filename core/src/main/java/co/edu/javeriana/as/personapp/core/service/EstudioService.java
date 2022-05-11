package co.edu.javeriana.as.personapp.core.service;

import co.edu.javeriana.as.personapp.core.port.out.mongo.EstudioMongoDBPort;
import co.edu.javeriana.as.personapp.core.port.out.mysql.EstudioMySQLPort;
import co.edu.javeriana.as.personapp.core.port.out.rest.EstudioRestPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstudioService {
    @Autowired
    EstudioMongoDBPort estudioMongoDBPort;

    @Autowired
    EstudioMySQLPort estudioMySQLPort;

    @Autowired
    EstudioRestPort estudioRestPort;

}
