package com.victorjesus.projeto_desafio_musicas.controller;

import com.victorjesus.projeto_desafio_musicas.domain.Artist;
import com.victorjesus.projeto_desafio_musicas.repository.ArtistRepository;
import com.victorjesus.projeto_desafio_musicas.service.ArtistService;

import java.util.List;

public class ArtistController {
    private final ArtistService artistService;

    public ArtistController(ArtistRepository artistRepository){
        this.artistService = new ArtistService(artistRepository);
    }

    public void listAll() {
        System.out.println("--- Listando Artistas ---");
        var artists = artistService.listAll();

        artists.forEach(a -> System.out.println(a.getId() + " - " + a.getName()));
    }

    public void createArtist(String name, int age) {
        System.out.println("--- Criando Artista ---");
        Artist artist = new Artist(name, age);
        artistService.save(artist);
        System.out.println("--- Artist " + artist.getName() + " salvo com sucesso ---");
    }
}
