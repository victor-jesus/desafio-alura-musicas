package com.victorjesus.projeto_desafio_musicas.controller;

import com.victorjesus.projeto_desafio_musicas.domain.Artist;
import com.victorjesus.projeto_desafio_musicas.domain.Genre;
import com.victorjesus.projeto_desafio_musicas.domain.Music;
import com.victorjesus.projeto_desafio_musicas.repository.ArtistRepository;
import com.victorjesus.projeto_desafio_musicas.repository.MusicRepository;
import com.victorjesus.projeto_desafio_musicas.service.MusicService;

import java.util.List;
import java.util.Optional;

public class MusicController {
    private final MusicService musicService;

    public MusicController(MusicRepository musicRepository, ArtistRepository artistRepository){
        this.musicService = new MusicService(musicRepository, artistRepository);
    }

    public List<Music> listAll() {
        System.out.println("--- Listando Músicas ---");
        return musicService.listAll();
    }

    public Optional<Music> getByName(String name) {
        System.out.println("--- Listando ---");
        return musicService.findMusicByName(name);
    }

    public void createMusic(Genre genre, String name, long artistId) throws IllegalArgumentException {
        System.out.println("--- Criando Musica ---");

        Artist artist = new Artist();

        artist.setId(artistId);

        Music music = new Music(genre, name, artist);

        musicService.save(music);
        System.out.println("--- Musica " + music.getName() + " salva com sucesso ---");
    }

    public void deleteMusicsById(List<Long> ids){
        musicService.deleteItens(ids);
        System.out.println("Músicas deletadas com sucesso.");
    }

    public Optional<Music> getById(long id){
        return musicService.getById(id);
    }

}
