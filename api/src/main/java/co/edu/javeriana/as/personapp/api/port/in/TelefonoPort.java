package co.edu.javeriana.as.personapp.api.port.in;

import co.edu.javeriana.as.personapp.core.domain.Telefono;

import java.util.List;

public interface TelefonoPort {
    public Telefono buscarPorId(Integer num);

    public List<Telefono> buscarTodo();

    public Integer contar();

    public Telefono crear(Telefono telefono);

    public Telefono editar(Integer num, Telefono telefono);

    public Boolean eliminar(Integer num);
}
