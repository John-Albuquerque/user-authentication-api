package com.john.user_authentication_api.service;

import com.john.user_authentication_api.dto.AcessDTO;
import com.john.user_authentication_api.dto.AuthenticationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import security.jwt.JwtUtils;

@Service
public class AuthService {

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private AuthenticationManager authenticationManager;

    public AcessDTO login(AuthenticationDTO authDto){
        try{
        //cria um mecanismo de credencial para o spring
        UsernamePasswordAuthenticationToken userAuth =
                new UsernamePasswordAuthenticationToken(authDto.getUsername(), authDto.getPassword());

        //prepara o mecanismo para autenticação
        Authentication authentication = authenticationManager.authenticate(userAuth);

        //busca usuario logado
        UserDetailsImpl userAutheticate = (UserDetailsImpl)authentication.getPrincipal();

        String token = jwtUtils.generateToken(userAutheticate);

        AcessDTO acessDTO = new AcessDTO(token);

        return acessDTO;
        }catch (BadCredentialsException e){
            //TODO LOGIN OU SENHA INVALIDO
        }
    }
}
