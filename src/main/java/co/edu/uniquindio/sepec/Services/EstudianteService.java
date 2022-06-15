package co.edu.uniquindio.sepec.Services;

import co.edu.uniquindio.sepec.Entities.Estudiante;
import co.edu.uniquindio.sepec.Repositories.EstudianteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class EstudianteService {
    @Autowired
    private EstudianteRepo estudianteRepo;
    @Transactional
    public boolean createEstudiante(Estudiante estudiante) {
        if(estudianteRepo.existsById(estudiante.getCodigo())) {
            return false;
        }
        estudianteRepo.save(estudiante);
        return true;
    }

    @Transactional
    public List <Object[]> getAllEstudiantesPuntaje() {
        return estudianteRepo.getEstudiantesPuntaje();
    }

    @Transactional
    public List <Object[]> getResultadosTest(Integer codigo) {
        return estudianteRepo.getResultadosTest(codigo);
    }
}
