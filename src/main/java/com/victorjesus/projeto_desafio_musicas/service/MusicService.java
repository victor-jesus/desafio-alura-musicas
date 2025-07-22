package com.victorjesus.projeto_desafio_musicas.service;

import com.victorjesus.projeto_desafio_musicas.domain.Artist;
import com.victorjesus.projeto_desafio_musicas.domain.Music;
import com.victorjesus.projeto_desafio_musicas.repository.ArtistRepository;
import com.victorjesus.projeto_desafio_musicas.repository.MusicRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MusicService extends BaseService<Music, Long> {
    private final MusicRepository musicRepository;
    private final ArtistRepository artistRepository;

    public MusicService(MusicRepository musicRepository, ArtistRepository artistRepository) {
        super(musicRepository);
        this.musicRepository = musicRepository;
        this.artistRepository = artistRepository;
    }

     /**
      * Salva Música
      *
      * @param music Música a ser salva
      * @return
      * @throws IllegalArgumentException caso o artista seja nulo ou o artista não tenha sido encontrado no banco.
      */

    @Override
    public Music save(Music music) throws IllegalArgumentException {
        Long artistId = music.getArtist().getId();

        if(artistId == null) {
            throw new IllegalArgumentException("Artista precisa estar definido para salvar.");
        }

        Artist artist = artistRepository.findById(artistId)
                .orElseThrow(() -> new IllegalArgumentException("Artista não encontrado"));

        music.setArtist(artist);

        return musicRepository.save(music);
    }

    public Optional<Music> findMusicByName(String name){
        return musicRepository.findMusicByNameContainingIgnoreCase(name);
    }

    @Override
    public void deleteItens(List<Long> ids) {
        List<Long> musicForDelete = new ArrayList<>();

        for (Long id : ids) {
            Optional<Music> optionalMusic = musicRepository.findById(id);

            if (optionalMusic.isPresent()) {
                musicForDelete.add(optionalMusic.get().getId());
            } else {
                System.err.println("Não existe música com Id " + id + " no banco.");
            }
        }
        musicRepository.deleteAllByIdInBatch(musicForDelete);
    }


}
