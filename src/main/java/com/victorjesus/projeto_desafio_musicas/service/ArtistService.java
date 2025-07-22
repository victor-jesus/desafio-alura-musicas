package com.victorjesus.projeto_desafio_musicas.service;

import com.victorjesus.projeto_desafio_musicas.domain.Artist;
import com.victorjesus.projeto_desafio_musicas.repository.ArtistRepository;

import java.util.List;
import java.util.Optional;

public class ArtistService extends BaseService<Artist, Long> {
    private final ArtistRepository artistRepository;

    public ArtistService(ArtistRepository artistRepository) {
        super(artistRepository);
        this.artistRepository = artistRepository;
    }

    @Override
    public void deleteItens(List<Long> ids) {
        for (Long id : ids) {
            Optional<Artist> optionalArtist = artistRepository.findById(id);

            if (optionalArtist.isPresent()) {
                Artist artist = optionalArtist.get();

                if (artist.getMusics() != null) {
                    artist.getMusics().clear();
                }

                artistRepository.delete(artist);

            } else {
                System.err.println("Não existe artista com Id " + id + " no banco.");
            }
        }
    }
}
