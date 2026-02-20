package com.john.user_authentication_api.repository;

import com.john.user_authentication_api.entity.UsuarioEntity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UsuarioRepository extends JpaRepository<UsuarioEntity, String> {

    Optional<UsuarioEntity> findByLogin(String login);
}

