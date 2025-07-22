package com.victorjesus.projeto_desafio_musicas;

import com.victorjesus.projeto_desafio_musicas.controller.ArtistController;
import com.victorjesus.projeto_desafio_musicas.repository.ArtistRepository;
import com.victorjesus.projeto_desafio_musicas.repository.MusicRepository;
import com.victorjesus.projeto_desafio_musicas.service.ArtistService;
import com.victorjesus.projeto_desafio_musicas.view.ConsoleRun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjetoDesafioMusicasApplication implements CommandLineRunner {
	@Autowired
	ArtistRepository artistRepository;
	@Autowired
	MusicRepository musicRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProjetoDesafioMusicasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ConsoleRun consoleRun = new ConsoleRun(musicRepository, artistRepository);
		consoleRun.showConsole();
	}
}
