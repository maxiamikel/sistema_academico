package com.maxi.backacademico.entities.exceptions;

import org.springframework.stereotype.Component;

@Component
public class EntityException {

    private String messagem;

    public String getMessagem() {
        return messagem;
    }

    public void setMessagem(String messagem) {
        this.messagem = messagem;
    }
    
}
