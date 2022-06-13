package co.edu.uniquindio.sepec.Entities;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "item")
@Getter
@Setter
public class Item {

    @Id
    @Column(name = "id_item")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idItem;

    @Column (name = "enunciado", nullable = false, length = 250)
    private String enunciado;

}