package co.edu.javeriana.as.personapp.api.port.in;

import co.edu.javeriana.as.personapp.core.domain.Estudio;

import java.util.List;

public interface EstudioPort {
    public Estudio buscarPorId(Integer idProfesion, Integer ccPersona);

    public List<Estudio> buscarTodo();

    public Integer contar();

    public Estudio crear(Estudio estudio);

    public Estudio editar(Integer idProfesion, Integer ccPersona, Estudio estudio);

    public Boolean eliminar(Integer idProfesion, Integer ccPersona);
}
