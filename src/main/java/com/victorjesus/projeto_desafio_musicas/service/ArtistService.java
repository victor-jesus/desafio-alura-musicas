package com.victorjesus.projeto_desafio_musicas.service;

import com.victorjesus.projeto_desafio_musicas.domain.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public class ArtistService extends BaseService<Artist, Long> {
    public ArtistService(JpaRepository<Artist, Long> repository) {
        super(repository);
    }

}
