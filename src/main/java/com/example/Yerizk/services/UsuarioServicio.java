package com.example.Yerizk.services;

import java.util.List;


import com.example.Yerizk.dto.UsuarioRegistroDTO;
import com.example.Yerizk.model.Usuario;
import org.springframework.security.core.userdetails.UserDetailsService;




public interface UsuarioServicio extends UserDetailsService{

    public Usuario guardar(UsuarioRegistroDTO registroDTO);

    public List<Usuario> listarUsuarios();

}
