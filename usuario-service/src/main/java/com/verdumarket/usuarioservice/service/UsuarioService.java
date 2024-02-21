package com.verdumarket.usuarioservice.service;

import com.verdumarket.usuarioservice.model.Usuario;
import com.verdumarket.usuarioservice.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario obtenerUsuarioPorID(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }
}
