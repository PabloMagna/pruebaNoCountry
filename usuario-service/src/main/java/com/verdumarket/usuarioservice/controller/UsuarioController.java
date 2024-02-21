package com.verdumarket.usuarioservice.controller;

import com.verdumarket.usuarioservice.model.Usuario;
import com.verdumarket.usuarioservice.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;
    @GetMapping("obtenerusuarioporid/{id}")
    public ResponseEntity<Usuario> obtenerUsuarioPorId(@PathVariable Long id){
        Usuario usuario = usuarioService.obtenerUsuarioPorID(id);
        return ResponseEntity.ok(usuario);
    }
}
