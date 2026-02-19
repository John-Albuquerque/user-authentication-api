package com.john.user_authentication_api.security.jwt;

import com.john.user_authentication_api.service.UserDetailsImpl;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;

@Component
public class JwtUtils {

    @Value("${projeto.jwtSecret}")
    private String jwtSecret;

    @Value("${projeto.jwtExpirationMs}")
    private int jwtExpirationMs;

    public String generateToken(UserDetailsImpl userDetails){
        return Jwts.builder().setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + jwtExpirationMs))
                .signWith(getSingninKey(), SignatureAlgorithm.HS512).compact();
    }

    public Key getSingninKey(){
        SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
        return key;
    }

    public boolean validateJwtToken(String authToken){
        try{
            Jwts.parser().setSigningKey(getSingninKey()).build().parseClaimsJws(authToken);
            return true;
        }catch (MalformedJwtException e){
            System.out.println("Token inválido" + e.getMessage());
        }catch (ExpiredJwtException e){
            System.out.println("Token expirado" + e.getMessage());
        }catch (IllegalArgumentException e){
            System.out.println("Token Argumento inválido" + e.getMessage());
        }

        return false;
    }
}
