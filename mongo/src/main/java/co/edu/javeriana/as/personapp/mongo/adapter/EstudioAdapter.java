package co.edu.javeriana.as.personapp.mongo.adapter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.edu.javeriana.as.personapp.core.domain.Estudio;
import co.edu.javeriana.as.personapp.core.port.out.mongo.EstudioMongoDBPort;
import co.edu.javeriana.as.personapp.mongo.document.EstudioDocument;
import co.edu.javeriana.as.personapp.mongo.document.PersonaDocument;
import co.edu.javeriana.as.personapp.mongo.mapper.EstudioMapper;
import co.edu.javeriana.as.personapp.mongo.repository.EstudioRepository;
import co.edu.javeriana.as.personapp.mongo.repository.PersonaRepository;

@Component
public class EstudioAdapter implements EstudioMongoDBPort{

   @Autowired
   EstudioRepository estudioRepository;
    @Autowired
    EstudioMapper estudioMapper;

    @Override
    public Estudio save(Estudio estudio) {
        EstudioDocument aux= estudioMapper.toPersonaDocu(estudio);
        estudioRepository.save(aux);
        return estudio;

        
    }

    @Override
    public Boolean delete(Integer idProfesion, Integer ccPersona) {
        List<Integer> aux = new ArrayList<Integer>();
        aux.add(idProfesion);
        aux.add(ccPersona);
       
        estudioRepository.deleteAllById(aux);
        return true;
    }

    @Override
    public List<Estudio> findAll() {
        List<EstudioDocument> PER = estudioRepository.findAll();
		List<Estudio> aux = new ArrayList<Estudio>();
		for (EstudioDocument not : PER) {
			aux.add(estudioMapper.toPersonaDocu(not));
		}

		return aux;
    }

    @Override
    public Estudio findByIdProfCcPer(Integer idProfesion, Integer ccPersona) {
        EstudioDocument n1 = estudioRepository.findItemByid(idProfesion);

		return estudioMapper.toPersonaDocu(n1);
    }

    @Override
    public Integer count() {
        long x;
		x = estudioRepository.count();
		int retorno = (int) x;
		return retorno;
    }
    
}
