package co.edu.uniquindio.sepec.Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Entity
@Table (name = "Respuesta")
@Getter
@Setter
public class Respuesta {

    @Id
    @Column (name = "id_Respuesta")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idRespuesta;

    @Column (name = "id_Pregunta")
    private int idPregunta;


    @Column (name = "id_Estudiante")
    private int idEstudiante;

    @Column (name = "valoracion", nullable = false)
    private int valoracion;
    public Respuesta() {
    }

    public Respuesta(int idPregunta, int idEstudiante, int valoracion) {
        this.idPregunta = idPregunta;
        this.idEstudiante = idEstudiante;
        this.valoracion = valoracion;
    }
}
