package co.edu.uniquindio.sepec.Services;

import co.edu.uniquindio.sepec.Entities.Opinion;
import co.edu.uniquindio.sepec.Repositories.OpinionRepo;
import org.apache.catalina.LifecycleState;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class OpinionService {

    @Autowired
    private OpinionRepo opinionRepo;

    @Transactional
    public boolean createOpinion(Opinion opinion) {

        try {
            opinionRepo.save(opinion);
            return true;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    @Transactional
    public List<Object[]> getPromedioOpinion() {
        return opinionRepo.getPromedioOpinion();
    }
}

