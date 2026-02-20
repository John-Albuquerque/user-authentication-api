package com.john.user_authentication_api.entity;

import com.john.user_authentication_api.dto.UsuarioDTO;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class UsuarioEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String senha;
    @Column(nullable = false, unique = true)
    private String login;


    public UsuarioEntity(Long id, String name, String senha, String login) {
        this.id = id;
        this.name = name;
        this.senha = senha;
        this.login = login;
    }
    public UsuarioEntity(UsuarioDTO usuarioDto) {
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


        this.senha = this.senha;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioEntity that = (UsuarioEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
