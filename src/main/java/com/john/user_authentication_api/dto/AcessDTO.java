package com.john.user_authentication_api.dto;

public class AcessDTO {
    private String token;

    //TODO IMPLEMENTAR RETORNAR O USUARIO E LIBERAÇÕES (AUTHORITIES)


    public AcessDTO(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
