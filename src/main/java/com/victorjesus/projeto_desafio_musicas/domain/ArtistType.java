package com.victorjesus.projeto_desafio_musicas.domain;

import java.util.Arrays;

public enum ArtistType {
    SOLO(1, "Solo"),
    BANDA(2, "Banda");

    final int code;
    final String description;

    ArtistType(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static void listTypes(){
        for(ArtistType type: ArtistType.values()){
            System.out.println(type.getCode() + " - " + type.getDescription());
        }
    }

    public static ArtistType fromCode(int code) throws IllegalArgumentException {
        for(ArtistType type : ArtistType.values()){
            if(type.code == code){
                return type;
            }
        }

        throw new IllegalArgumentException("Não existe artista com esse código: " + code);
    }
}
