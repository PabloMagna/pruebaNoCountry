package com.verdumarket.productoservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity @Builder
public class ProductoVendedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProductoVendedor;

    @Column(nullable = false)
    private Long idVendedor;

    @ManyToOne
    @JoinColumn(name = "id_producto_generico", nullable = false)
    private ProductoGenerico productoGenerico;

    @Column(nullable = false)
    private int stock;

    private BigDecimal precioUnidad;

    @Enumerated(EnumType.STRING)
    private EstadoProductoVendedor estadoProductoVendedor;
}
