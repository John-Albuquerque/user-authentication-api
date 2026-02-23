package com.john.user_authentication_api.dto;

import com.john.user_authentication_api.entity.UsuarioEntity;
import org.springframework.beans.BeanUtils;

public class UsuarioDTO {

        private Long id;
        private String name;
        private String login;
        private String senha;
        private String email;

    public UsuarioDTO(UsuarioEntity usuario) {
        BeanUtils.copyProperties(usuario, this);
    }

    public UsuarioDTO() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }
}
