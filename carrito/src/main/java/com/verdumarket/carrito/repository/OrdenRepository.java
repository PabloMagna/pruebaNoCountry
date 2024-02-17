package com.verdumarket.carrito.repository;

import com.verdumarket.carrito.model.Orden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdenRepository extends JpaRepository<Orden, Long> {

    @Query("SELECT o FROM Orden o WHERE o.idComprador = :idConsumidor")
    public List<Orden> listarOrdenesPorConsumidor(@Param("idConsumidor") Long idConsumidor);

    @Query("SELECT o FROM Orden o WHERE o.idVendedor = :idVendedor")
    public List<Orden> listarOrdenesPorVendedor(@Param("idVendedor") Long idVendedor);
}
