package com.victorjesus.projeto_desafio_musicas.repository;

import com.victorjesus.projeto_desafio_musicas.domain.Music;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MusicRepository extends JpaRepository<Music, Long> {
    Optional<Music> findMusicByNameContainingIgnoreCase(String name);
}
