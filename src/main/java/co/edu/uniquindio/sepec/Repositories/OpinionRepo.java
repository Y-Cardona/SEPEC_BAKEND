package co.edu.uniquindio.sepec.Repositories;

import co.edu.uniquindio.sepec.Entities.Opinion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OpinionRepo extends JpaRepository<Opinion, Integer> {

    @Query(value = "select i.enunciado, avg(valoracion) Promedio_Global " +
            "from opinion o join item i " +
            "on i.id_item = o.id_item " +
            "group by i.enunciado " +
            "order by 1 ", nativeQuery = true)
    List<Object[]> getPromedioOpinion();

}
