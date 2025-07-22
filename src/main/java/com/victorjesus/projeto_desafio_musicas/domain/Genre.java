package com.victorjesus.projeto_desafio_musicas.domain;

public enum Genre {
    HEAVY_METAL(1, "Heavy Metal"),
    ROCK(2, "Rock"),
    POP(3, "Pop"),
    MPB(4, "MPB"),
    SERTANEJO(5, "Sertanejo"),
    FUNK(6, "Funk"),
    ELETRONICA(7, "Eletrônica"),
    GOSPEL(8, "Gospel"),
    SAMBA(9, "Samba"),
    RAP(10, "Rap"),
    OUTRO(11, "Outro");

    private int code;
    private String name;

    Genre(int code, String name){
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static Genre fromCode(int code) throws IllegalArgumentException{
        for(Genre genre : Genre.values()) {
            if(genre.code == code) {
                return genre;
            }
        }
        throw new IllegalArgumentException("Não existe gênero com esse código: " + code);
    }

    public static void listGenres(){
        for(Genre genre : Genre.values()){
            System.out.println(genre.name + " - " + genre.code);
        }
    }
}

