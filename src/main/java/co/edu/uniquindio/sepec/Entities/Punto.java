package co.edu.uniquindio.sepec.Entities;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "Punto")
@Getter
@Setter
public class Punto {
    @Id
    @Column(name = "id_Punto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPunto;
    @Column(name = "x", columnDefinition = "int default 0")
    private int x;
    @Column(name = "y", columnDefinition = "int default 0")
    private int y;

    @OneToMany(mappedBy = "puntoInicial")
    private List<Pregunta> ListaPreguntas;

    @OneToMany(mappedBy = "puntoFinal")
    private List<Pregunta> ListaPreguntas2;

}