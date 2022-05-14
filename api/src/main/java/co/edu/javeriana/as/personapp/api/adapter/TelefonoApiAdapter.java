package co.edu.javeriana.as.personapp.api.adapter;

import co.edu.javeriana.as.personapp.api.port.in.TelefonoApiPort;
import co.edu.javeriana.as.personapp.core.domain.Telefono;
import co.edu.javeriana.as.personapp.core.usecase.TelefonoUseCase;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TelefonoApiAdapter implements TelefonoApiPort {
    @Autowired
    TelefonoUseCase telefonoUseCase;

    @Override
    public Telefono buscarPorId(Integer num) {
        return telefonoUseCase.buscarPorId(num);
    }

    @Override
    public List<Telefono> buscarTodo() {
        return telefonoUseCase.buscarTodo();
    }

    @Override
    public Integer contar() {
        return telefonoUseCase.contar();
    }

    @Override
    public Telefono crear(Telefono telefono) {
        return telefonoUseCase.crear(telefono);
    }

    @Override
    public Telefono editar(Integer num, Telefono telefono) {
        return telefonoUseCase.editar(num, telefono);
    }

    @Override
    public Boolean eliminar(Integer num) {
        return telefonoUseCase.eliminar(num);
    }
}
