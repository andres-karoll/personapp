package co.edu.javeriana.as.personapp.core.usecase;

import co.edu.javeriana.as.personapp.core.domain.Persona;

import java.util.List;

public interface PersonaUseCase {
    public Persona buscarPorId(Integer cc);

    public List<Persona> buscarTodo();

    public Integer contar();

    public Persona crear(Persona persona);

    public Persona editar(Integer cc, Persona persona);

    public Boolean eliminar(Integer cc);
}
