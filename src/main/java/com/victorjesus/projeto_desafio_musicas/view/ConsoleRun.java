package com.victorjesus.projeto_desafio_musicas.view;

import com.victorjesus.projeto_desafio_musicas.controller.ArtistController;
import com.victorjesus.projeto_desafio_musicas.controller.MusicController;
import com.victorjesus.projeto_desafio_musicas.domain.Artist;
import com.victorjesus.projeto_desafio_musicas.domain.ArtistType;
import com.victorjesus.projeto_desafio_musicas.domain.Genre;
import com.victorjesus.projeto_desafio_musicas.domain.Music;
import com.victorjesus.projeto_desafio_musicas.repository.ArtistRepository;
import com.victorjesus.projeto_desafio_musicas.repository.MusicRepository;

import java.util.List;
import java.util.Scanner;

public class ConsoleRun {
    private MusicController musicController;
    private ArtistController artistController;
    private final Scanner scanner = new Scanner(System.in);

    public ConsoleRun(MusicRepository musicRepository, ArtistRepository artistRepository) {
        this.musicController = new MusicController(musicRepository, artistRepository);
        this.artistController = new ArtistController(artistRepository);
    }

    public void showConsole() {
        int option;
        do {
            String menu = """
                ---- ScreenMusics ----
                
                1 - Salvar musica
                2 - Listar musicas
                3 - Deletar musicas
                4 - Salvar artista
                5 - Listar artistas
                6 - Deletar Artista
                
                0 - Sair
                """;
            System.out.println(menu);
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1: {
                    saveMusic();
                    break;
                }
                case 2: {
                    listAllMusics().forEach(m -> System.out.println(m.getId() + " - " + m.getName() + " (" + m.getArtist().getName() + ")"));
                    break;
                }
                case 3: {
                    deleteMusicById();
                    break;
                }
                case 4: {
                    saveArtist();
                    break;
                }
                case 5: {
                    listAllArtists().forEach(a -> System.out.println(a.getId() + " - " + a.getName()));
                    break;
                }
                case 6: {
                    deleteArtistById();
                    break;
                }
                case 0: {
                    System.out.println("Saindo...");
                    break;
                }
                default:{
                    System.out.println("Comando não reconhecido...");
                }
            }
        } while (option != 0) ;
    }

    private void deleteMusicById(){
        listAllMusics().forEach(m -> System.out.println(m.getId() + " - " + m.getName() + " (" + m.getArtist().getName() + ")"));
        System.out.println("Digite o Id da música que deseja deletar: ");
        long id = scanner.nextLong();

        musicController.deleteMusicsById(List.of(id));
    }

    private void deleteArtistById(){
        listAllArtists().forEach(a -> System.out.println(a.getId() + " - " + a.getName() + " (" + a.getName() + ")"));
        System.out.println("Digite o Id do artista que deseja deletar: ");
        long id = scanner.nextLong();
        scanner.nextLine();

        artistController.deleteArtistById(List.of(id));
    }

    private List<Artist> listAllArtists() {
        return artistController.listAll();
    }

    private void saveArtist() {
        System.out.println("Digite o nome do artista: ");
        String nome = scanner.nextLine();

        ArtistType artistType = null;

        while(artistType == null){
            try{
                ArtistType.listTypes();

                System.out.print("Digite o Id do tipo: ");
                int type = scanner.nextInt();

                artistType = ArtistType.fromCode(type);

                scanner.nextLine();
            } catch(IllegalArgumentException e) {
                System.err.println(e.getMessage());
                System.out.println("Tente Novamente.\n");
            }
        }

        artistController.createArtist(nome, artistType);
    }

    private List<Music> listAllMusics() {
        return musicController.listAll();
    }

    private void saveMusic() {
            System.out.println("Digite o nome da música: ");
            String nome = scanner.nextLine();


            Genre genre = null;

            while (genre == null){
                try{
                    Genre.listGenres();

                    System.out.println("Digite o ID do gênero da música: ");
                    int type = scanner.nextInt();

                    genre = Genre.fromCode(type);

                    scanner.nextLine();
                } catch(IllegalArgumentException e){
                    System.err.println("Erro: " + e.getMessage());
                    System.out.println("Tente novamente.\n");
                }
            }

            listAllArtists().forEach(a -> System.out.println(a.getId() + " - " + a.getName()));

            System.out.println("Digite o ID do artista: ");
            long artistaId = scanner.nextInt();
            scanner.nextLine();

        try {
            musicController.createMusic(genre, nome, artistaId);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
