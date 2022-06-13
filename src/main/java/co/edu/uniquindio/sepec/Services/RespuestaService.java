package co.edu.uniquindio.sepec.Services;

import co.edu.uniquindio.sepec.Entities.Respuesta;
import co.edu.uniquindio.sepec.Repositories.RespuestaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class RespuestaService {
    @Autowired
    private RespuestaRepo respuestaRepo;
    @Transactional
    public boolean createRespuesta(Respuesta respuesta) {
        if (respuestaRepo.findById(respuesta.getIdRespuesta()) != null) {
            respuestaRepo.save(respuesta);
            return true;
        }
        return false;
    }

    @Transactional
    public List<Object[]> getPReguntasTyF() {
        return respuestaRepo.getPreguntasTyF();
    }

    @Transactional
    public List<Object[]> getPromedioPreguntas() {
        return respuestaRepo.getPromedioPreguntas();
    }
}