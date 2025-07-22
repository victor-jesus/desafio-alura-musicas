package com.victorjesus.projeto_desafio_musicas.service;

import com.victorjesus.projeto_desafio_musicas.domain.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public class ArtistService extends BaseService<Artist, Long> {
    public ArtistService(JpaRepository<Artist, Long> repository) {
        super(repository);
    }

    @Override
    public void deleteItens(List<Long> ids) {
        for(long id : ids){
            Artist artist = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Não foi possível encontrar o artista do ID: " + id));

            artist.getMusics().clear();

            repository.delete(artist);
        }
    }
}
