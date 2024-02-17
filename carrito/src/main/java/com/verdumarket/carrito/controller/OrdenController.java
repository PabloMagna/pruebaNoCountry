package com.verdumarket.carrito.controller;

import com.verdumarket.carrito.model.Orden;
import com.verdumarket.carrito.service.IOrdenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrdenController {
    @Autowired
    private IOrdenService ordenService;

    @GetMapping("/")
    public ResponseEntity listarOrdenesPorConsumidor()
}
