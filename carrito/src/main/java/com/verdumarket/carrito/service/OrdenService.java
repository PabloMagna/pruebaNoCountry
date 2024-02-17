package com.verdumarket.carrito.service;

import com.verdumarket.carrito.model.Orden;
import com.verdumarket.carrito.repository.OrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdenService implements IOrdenService{
    @Autowired
    private OrdenRepository ordenRepository;

    public List<Orden> listarOrdenesPorConsumidor(Long idConsumidor){
        return ordenRepository.listarOrdenesPorConsumidor(idConsumidor);
    }

    public List<Orden> listarOrdenesPorVendedor(Long idVendedor){
        return ordenRepository.listarOrdenesPorVendedor(idVendedor);
    }
}
