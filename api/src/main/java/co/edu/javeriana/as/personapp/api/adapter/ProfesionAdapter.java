package co.edu.javeriana.as.personapp.api.adapter;

import co.edu.javeriana.as.personapp.api.port.in.ProfesionPort;
import co.edu.javeriana.as.personapp.core.domain.Profesion;
import co.edu.javeriana.as.personapp.core.usecase.ProfesionUseCase;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProfesionAdapter implements ProfesionPort {

    @Autowired
    private ProfesionUseCase profesionUseCase;

    @Override
    public Profesion buscarPorId(Integer id) {
        return profesionUseCase.buscarPorId(id);
    }

    @Override
    public List<Profesion> buscarTodo() {
        return profesionUseCase.buscarTodo();
    }

    @Override
    public Integer contar() {
        return profesionUseCase.contar();
    }

    @Override
    public Profesion crear(Profesion profesion) {
        return profesionUseCase.crear(profesion);
    }

    @Override
    public Profesion editar(Integer id, Profesion profesion) {
        return profesionUseCase.editar(id, profesion);
    }

    @Override
    public Boolean eliminar(Integer is) {
        return profesionUseCase.eliminar(is);
    }
}
