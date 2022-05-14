package co.edu.javeriana.as.personapp.api.adapter;

import co.edu.javeriana.as.personapp.api.port.in.EstudioApiPort;
import co.edu.javeriana.as.personapp.core.domain.Estudio;
import co.edu.javeriana.as.personapp.core.usecase.EstudioUseCase;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EstudioApiAdapter implements EstudioApiPort {
    @Autowired
    private EstudioUseCase estudioUseCase;
    @Override
    public Estudio buscarPorId(Integer idProfesion, Integer ccPersona) {
        return estudioUseCase.buscarPorId(idProfesion, ccPersona);
    }

    @Override
    public List<Estudio> buscarTodo() {
        return estudioUseCase.buscarTodo();
    }

    @Override
    public Integer contar() {
        return estudioUseCase.contar();
    }

    @Override
    public Estudio crear(Estudio estudio) {
        return estudioUseCase.crear(estudio);
    }

    @Override
    public Estudio editar(Integer idProfesion, Integer ccPersona, Estudio estudio) {
        return estudioUseCase.editar(idProfesion, ccPersona, estudio);
    }

    @Override
    public Boolean eliminar(Integer idProfesion, Integer ccPersona) {
        return estudioUseCase.eliminar(idProfesion, ccPersona);
    }
}
