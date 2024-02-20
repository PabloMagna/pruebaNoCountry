package com.verdumarket.productoservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class ProductoGenerico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProductoGenerico;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_categoria", nullable = false)
    private Categoria categoria;

    @Enumerated(EnumType.STRING)
    private TipoUnidad tipoUnidad;

    @Column(nullable = false)
    private String descripcion;
}
