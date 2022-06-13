package co.edu.uniquindio.sepec.Entities;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table (name = "Pregunta")
@Getter
@Setter
public class Pregunta {
    @Id
    @Column (name = "id_Pregunta")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idPregunta;

    @Column (name = "enunciado", nullable = false, length = 25)
    private String enunciado;
    @ManyToOne
    private Punto puntoInicial;

    @ManyToOne
    private Punto puntoFinal;
}