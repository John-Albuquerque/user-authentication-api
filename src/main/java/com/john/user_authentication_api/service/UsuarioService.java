package com.john.user_authentication_api.service;

import com.john.user_authentication_api.dto.UsuarioDTO;
import com.john.user_authentication_api.entity.UsuarioEntity;
import com.john.user_authentication_api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioDTO> ListarTodos (){
        List<UsuarioEntity> usuarios = usuarioRepository.findAll();
        return usuarios.stream().map(UsuarioDTO::new).toList();
    }

    public void insert(UsuarioDTO usuarioDto){
        UsuarioEntity usuarioEntity = new UsuarioEntity(usuarioDto);

    }

}
