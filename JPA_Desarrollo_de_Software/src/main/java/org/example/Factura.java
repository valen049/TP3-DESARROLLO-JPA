package org.example;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name="factura")

public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="fecha")
    private String fecha;

    @Column(name="numero")
    private int numero;

    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="fk_cliente")
    private Cliente cliente;

    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleFactura> detallesFactura = new ArrayList<DetalleFactura>();

    @Builder

    public Factura(String fecha, int numero, int total){
        this.fecha=fecha;
        this.numero=numero;
        this.total=total;
    }

    @Column(name="total")
    private int total;
    }
