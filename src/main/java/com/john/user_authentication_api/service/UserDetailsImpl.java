package com.john.user_authentication_api.service;

import com.john.user_authentication_api.entity.UsuarioEntity;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class UserDetailsImpl implements UserDetails {

    private Long id;
    private String name;
    private String username;
    private String email;
    private String password;


    private Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImpl(Long id, String name, String username, String email, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.authorities = authorities;
    }

    public static UserDetailsImpl build(UsuarioEntity usuario){
        return new UserDetailsImpl(usuario.getId(), usuario.getName(), usuario.getLogin(), usuario.getEmail(), new ArrayList<>());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public @Nullable String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

}
