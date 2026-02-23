package com.john.user_authentication_api.controller;

import com.john.user_authentication_api.dto.UsuarioDTO;
import com.john.user_authentication_api.entity.UsuarioEntity;
import com.john.user_authentication_api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping
    public List<UsuarioDTO> listarTodos(){
        return service.ListarTodos();
    }

    @PostMapping
    public void inserir(@RequestBody UsuarioDTO usuario){
        service.inserir(usuario);
    }
    @PutMapping
    public UsuarioDTO alterar(@RequestBody UsuarioDTO usuario){
        return service.alterar(usuario);
    }

    //http//endereco/usuario/"{id}"
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        service.excluir(id);
        return ResponseEntity.ok().build();
    }



}
