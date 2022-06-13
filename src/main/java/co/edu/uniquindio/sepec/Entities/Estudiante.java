package co.edu.uniquindio.sepec.Entities;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
@Entity
@Table (name = "Estudiante")
@Getter
@Setter
public class Estudiante {
    @Id
    @Column(name = "codigo")
    private Integer codigo;
    @Column(name = "nombre", nullable = false, length = 150)
    private String nombre;
    @Column(name = "email", nullable = false, length = 100, unique = true)
    private String email;

    public Estudiante() {
    }

    public Estudiante(Integer codigo, String nombre, String email) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.email = email;
    }
}