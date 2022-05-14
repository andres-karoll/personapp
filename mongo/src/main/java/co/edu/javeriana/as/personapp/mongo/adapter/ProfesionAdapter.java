package co.edu.javeriana.as.personapp.mongo.adapter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.edu.javeriana.as.personapp.core.domain.Profesion;
import co.edu.javeriana.as.personapp.core.port.out.mongo.ProfesionMongoDBPort;
import co.edu.javeriana.as.personapp.mongo.document.ProfesionDocument;
import co.edu.javeriana.as.personapp.mongo.mapper.ProfesionMapper;
import co.edu.javeriana.as.personapp.mongo.repository.ProfesionRepository;
@Component
public class ProfesionAdapter implements ProfesionMongoDBPort{

    @Autowired
    ProfesionRepository profesionRepository;

    @Autowired
    ProfesionMapper profesionMapper;




    @Override
    public Profesion save(Profesion profesion) {
       // TODO Auto-generated method stub
		ProfesionDocument aux = profesionMapper.toPersonaDocu(profesion);
		profesionRepository.save(aux);
		return profesion;
    }

    @Override
    public Boolean delete(Integer id) {
    
		profesionRepository.deleteById(id);
		return true;
    }

    @Override
    public List<Profesion> findAll() {
        List<ProfesionDocument> PER = profesionRepository.findAll();
		List<Profesion> aux = new ArrayList<Profesion>();
		for (ProfesionDocument not : PER) {
			aux.add(profesionMapper.toPersonaDocu(not));
		}

		return aux;
    }

    @Override
    public Profesion findById(Integer id) {
        
        ProfesionDocument n1= profesionRepository.findItemByid(id);
        return profesionMapper.toPersonaDocu(n1);
    
    }

    @Override
    public Integer count() {
        long x;
		x = profesionRepository.count();
		int retorno = (int) x;
		return retorno;
    }
    
}
