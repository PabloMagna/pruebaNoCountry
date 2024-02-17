package com.verdumarket.usuarioservice.controller;

import com.verdumarket.usuarioservice.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;


}
