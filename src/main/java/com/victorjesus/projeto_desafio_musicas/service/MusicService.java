package com.victorjesus.projeto_desafio_musicas.service;

import com.victorjesus.projeto_desafio_musicas.domain.Music;
import org.springframework.data.jpa.repository.JpaRepository;

public class MusicService extends BaseService<Music, Long> {
    public MusicService(JpaRepository<Music, Long> repository) {
        super(repository);
    }
}
