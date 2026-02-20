package com.john.user_authentication_api.service;

import com.john.user_authentication_api.dto.UsuarioDTO;
import com.john.user_authentication_api.entity.UsuarioEntity;
import com.john.user_authentication_api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioDTO> ListarTodos (){
        List<UsuarioEntity> usuarios = usuarioRepository.findAll();
        return usuarios.stream().map(UsuarioDTO::new).toList();
    }

    public void inserir(UsuarioDTO usuarioDto){
        UsuarioEntity usuarioEntity = new UsuarioEntity(usuarioDto);
        usuarioRepository.save(usuarioEntity);
    }
    public UsuarioDTO alterar (UsuarioDTO usuario){
        UsuarioEntity usuarioEntity = new UsuarioEntity(usuario);
        return new UsuarioDTO(usuarioRepository.save(usuarioEntity));
    }

    public void excluir(Long id){
        UsuarioEntity usuario = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário nâo encontrado"));
        usuarioRepository.delete(usuario);
    }
    public UsuarioDTO buscarPorID(Long id){
        return new UsuarioDTO(usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário nâo encontrado")));
    }

}
