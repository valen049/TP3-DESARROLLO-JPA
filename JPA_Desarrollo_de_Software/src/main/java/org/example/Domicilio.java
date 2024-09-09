package org.example;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name="domicilio")

public class Domicilio {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nombre_calle")
    private String nombreCalle;

    @Column(name = "numero")
    private int numero;

    @OneToOne(mappedBy = "domicilio")
    private Cliente cliente;

    @Builder

    public Domicilio(String nombreCalle, int numero){
        this.nombreCalle=nombreCalle;
        this.numero=numero;
    }

    public Domicilio(String nombreCalle, int numero, Cliente cliente) {
        this.nombreCalle = nombreCalle;
        this.numero = numero;
        this.cliente = cliente;
    }
}
