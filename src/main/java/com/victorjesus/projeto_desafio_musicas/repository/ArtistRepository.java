package com.victorjesus.projeto_desafio_musicas.repository;

import com.victorjesus.projeto_desafio_musicas.domain.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
}
