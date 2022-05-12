package co.edu.javeriana.as.personapp.api.port.in;

import co.edu.javeriana.as.personapp.core.domain.Profesion;

import java.util.List;

public interface ProfesionPort {
    public Profesion buscarPorId(Integer id);

    public List<Profesion> buscarTodo();

    public Integer contar();

    public Profesion crear(Profesion profesion);

    public Profesion editar(Integer id, Profesion profesion);

    public Boolean eliminar(Integer is);
}
