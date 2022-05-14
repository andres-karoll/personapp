package co.edu.javeriana.as.personapp.core.usecase;

import co.edu.javeriana.as.personapp.core.domain.Telefono;

import java.util.List;

public interface TelefonoUseCase {
    public Telefono buscarPorId(Integer num);

    public List<Telefono> buscarTodo();

    public Integer contar();

    public Telefono crear(Telefono telefono);

    public Telefono editar(Integer num, Telefono telefono);

    public Boolean eliminar(Integer num);
}
