package co.edu.javeriana.as.personapp.core.usecase;

import co.edu.javeriana.as.personapp.core.domain.Estudio;
import co.edu.javeriana.as.personapp.core.domain.Persona;

import java.util.List;

public interface EstudioUseCase {
    public Estudio buscarPorId(Integer idProfesion, Integer ccPersona);

    public List<Estudio> buscarTodo();

    public Integer contar();

    public Estudio crear(Estudio estudio);

    public Estudio editar(Integer idProfesion, Integer ccPersona, Estudio estudio);

    public Boolean eliminar(Integer idProfesion, Integer ccPersona);
}
