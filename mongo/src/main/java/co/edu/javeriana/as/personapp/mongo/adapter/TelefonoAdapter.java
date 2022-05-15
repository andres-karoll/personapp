package co.edu.javeriana.as.personapp.mongo.adapter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import co.edu.javeriana.as.personapp.core.domain.Telefono;
import co.edu.javeriana.as.personapp.core.port.out.mongo.TelefonoMongoDBPort;
import co.edu.javeriana.as.personapp.mongo.document.TelefonoDocument;
import co.edu.javeriana.as.personapp.mongo.mapper.ProfesionMapper;
import co.edu.javeriana.as.personapp.mongo.mapper.TelefonoMapper;
import co.edu.javeriana.as.personapp.mongo.repository.ProfesionRepository;
import co.edu.javeriana.as.personapp.mongo.repository.TelefonoRepository;
@Component
public class TelefonoAdapter implements TelefonoMongoDBPort{

   @Autowired
   TelefonoRepository telefonoRepository;

   @Autowired
   TelefonoMapper telefonoMapper;




    @Override
    public Telefono save(Telefono telefono) {
        TelefonoDocument aux= telefonoMapper.toPersonaDocu(telefono);
        telefonoRepository.save(aux);
        
        return telefono;
    }

    @Override
    public Boolean delete(Integer num) {
        
		telefonoRepository.deleteById(num);
		return true;
    }

    @Override
    public List<Telefono> findAll() {
        List<TelefonoDocument> PER = telefonoRepository.findAll();
		List<Telefono> aux = new ArrayList<Telefono>();
		for (TelefonoDocument not : PER) {
			aux.add(telefonoMapper.toPersonaDocu(not));
		}

		return aux;

    @Override
    public Telefono findByNum(Integer num) {
        TelefonoDocument n1 = telefonoRepository.findItemByid(num);

		return telefonoMapper.toPersonaDocu(n1);
    }

    @Override
    public Integer count() {
       // TODO Auto-generated method stub
		long x;
		x = telefonoRepository.count();
		int retorno = (int) x;
		return retorno;
    }
    
}
