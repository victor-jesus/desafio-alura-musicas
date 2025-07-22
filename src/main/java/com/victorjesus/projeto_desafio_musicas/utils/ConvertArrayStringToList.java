package com.victorjesus.projeto_desafio_musicas.utils;

import java.util.ArrayList;
import java.util.List;

public class ConvertArrayStringToList {
    public static List<Long> convert(String[] arr){
        List<Long> listT = new ArrayList<>();

        for(String item: arr){
            try{
                listT.add(Long.parseLong(item.trim()));
            } catch (NumberFormatException e) {
                System.err.println("Não é um número: " + item);
            }
        }
        return listT;
    }
}
