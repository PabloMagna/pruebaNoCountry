package com.verdumarket.usuarioservice.service;

import com.verdumarket.usuarioservice.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioService{

    Usuario obtenerUsuarioPorID(Long id);
}
