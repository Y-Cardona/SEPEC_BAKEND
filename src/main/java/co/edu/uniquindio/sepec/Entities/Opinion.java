package co.edu.uniquindio.sepec.Entities;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "opinion")
@Getter
@Setter
public class Opinion {

    @Id
    @Column(name = "id_opinion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOpinion;

    @Column (name = "id_item")
    private int idItem;

    @Column (name = "id_Estudiante")
    private int idEstudiante;

    @Column (name = "valoracion", nullable = false)
    private int valoracion;

    public Opinion() {
    }

    public Opinion(int idItem, int idEstudiante, int valoracion) {
        this.idItem = idItem;
        this.idEstudiante = idEstudiante;
        this.valoracion = valoracion;
    }
}