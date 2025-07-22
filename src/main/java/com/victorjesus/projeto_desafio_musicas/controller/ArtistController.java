package com.victorjesus.projeto_desafio_musicas.controller;

import com.victorjesus.projeto_desafio_musicas.domain.Artist;
import com.victorjesus.projeto_desafio_musicas.domain.ArtistType;
import com.victorjesus.projeto_desafio_musicas.repository.ArtistRepository;
import com.victorjesus.projeto_desafio_musicas.service.ArtistService;

import java.util.List;
import java.util.Optional;

public class ArtistController {
    private final ArtistService artistService;

    public ArtistController(ArtistRepository artistRepository){
        this.artistService = new ArtistService(artistRepository);
    }

    public List<Artist> listAll() {
        System.out.println("--- Listando Artistas ---");
        return artistService.listAll();
    }

    public Optional<Artist> getById(Long id) {
        return artistService.getById(id);
    }

    public void createArtist(String name, ArtistType artistType) {
        System.out.println("--- Criando Artista ---");

        Artist artist = new Artist(name, artistType);

        artistService.save(artist);
        System.out.println("--- Artist " + artist.getName() + " salvo com sucesso ---");
    }

    public void deleteArtistById(List<Long> ids){
        artistService.deleteItens(ids);
    }
}
