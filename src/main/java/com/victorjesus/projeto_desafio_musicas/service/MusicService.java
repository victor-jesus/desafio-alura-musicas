package com.victorjesus.projeto_desafio_musicas.service;

import com.victorjesus.projeto_desafio_musicas.domain.Artist;
import com.victorjesus.projeto_desafio_musicas.domain.Music;
import com.victorjesus.projeto_desafio_musicas.repository.ArtistRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public class MusicService extends BaseService<Music, Long> {
    private final ArtistRepository artistRepository;

    public MusicService(JpaRepository<Music, Long> repository, ArtistRepository artistRepository) {
        super(repository);
        this.artistRepository = artistRepository;
    }

     /**
      * Salva Música
      *
      * @param music Música a ser salva
      * @throws IllegalArgumentException caso o artista seja nulo ou o artista não tenha sido encontrado no banco.
      */

    @Override
    public void save(Music music) throws IllegalArgumentException {
        Long artistId = music.getArtist().getId();

        if(artistId == null) {
            throw new IllegalArgumentException("Artista precisa estar definido para salvar.");
        }

        Artist artist = artistRepository.findById(artistId)
                .orElseThrow(() -> new IllegalArgumentException("Artista não encontrado"));

        music.setArtist(artist);

        repository.save(music);
    }
}
