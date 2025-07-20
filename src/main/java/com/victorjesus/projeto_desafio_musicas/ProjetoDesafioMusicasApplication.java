package com.victorjesus.projeto_desafio_musicas;

import com.victorjesus.projeto_desafio_musicas.controller.ArtistController;
import com.victorjesus.projeto_desafio_musicas.repository.ArtistRepository;
import com.victorjesus.projeto_desafio_musicas.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjetoDesafioMusicasApplication implements CommandLineRunner {
	@Autowired
	ArtistRepository artistRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProjetoDesafioMusicasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ArtistController artistController = new ArtistController(artistRepository);
		artistController.createArtist("Victor", 20);
	}
}
