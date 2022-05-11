package co.edu.javeriana.as.personapp.core.usecase;

import co.edu.javeriana.as.personapp.core.domain.Estudio;
import co.edu.javeriana.as.personapp.core.domain.Persona;
import co.edu.javeriana.as.personapp.core.domain.Profesion;

import java.util.List;

public interface ProfesionUseCase {
    public Profesion buscarPorId(Integer id);

    public List<Profesion> buscarTodo();

    public Integer contar();

    public Profesion crear(Profesion profesion);

    public Profesion editar(Integer id, Profesion profesion);

    public Boolean eliminar(Integer is);
}
