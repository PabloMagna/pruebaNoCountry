package com.verdumarket.carrito.service;

import com.verdumarket.carrito.model.Carrito;
import com.verdumarket.carrito.repository.CarritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarritoService implements ICarritoService{

    @Autowired
    private CarritoRepository carritoRepository;
    @Override
    public List<Carrito> listarCarritoIdComprador(Long idComprador){
        return carritoRepository.findAllByIdComprador(idComprador);
    }
    @Override
    public Carrito buscarCarritoPorVendedor(Long idComprador, Long idVendedor){
        return carritoRepository.findByIdCompradorIdVendedor(idComprador,idVendedor);
    }

    @Override
    public Carrito findById(Long id) {
        return carritoRepository.findById(id).orElse(null);
    }

}
