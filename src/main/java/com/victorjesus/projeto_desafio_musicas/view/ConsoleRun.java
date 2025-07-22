package com.victorjesus.projeto_desafio_musicas.view;

import com.victorjesus.projeto_desafio_musicas.controller.ArtistController;
import com.victorjesus.projeto_desafio_musicas.controller.MusicController;
import com.victorjesus.projeto_desafio_musicas.domain.ArtistType;
import com.victorjesus.projeto_desafio_musicas.domain.Genre;
import com.victorjesus.projeto_desafio_musicas.domain.Music;
import com.victorjesus.projeto_desafio_musicas.repository.ArtistRepository;
import com.victorjesus.projeto_desafio_musicas.repository.MusicRepository;
import com.victorjesus.projeto_desafio_musicas.utils.ConvertArrayStringToList;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ConsoleRun {
    private final MusicController musicController;
    private final ArtistController artistController;
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
                2 - Procurar musicas
                3 - Deletar musicas
                4 - Salvar artista
                5 - Listar artistas
                6 - Deletar Artista
                
                7 - Listar todas as musicas
                
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
                    listMusics();
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
                    listAllArtists();
                    break;
                }
                case 6: {
                    deleteArtistById();
                    break;
                }
                case 7: {
                    listAllMusics();
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

    private void listAllMusics(){
        musicController.listAll().forEach(m -> System.out.println(m.getId() + " - " + m.getName() + " (" + m.getArtist().getName() + ")"));
    }

    private void deleteMusicById(){
        listAllMusics();

        System.out.println("Digite os Id's das músicas que deseja deletar: (Separados por virgula. Ex.: 2, 4, 1...): ");
        String id = scanner.nextLine();

        String[] arr = id.split(",");

        List<Long> ids = ConvertArrayStringToList.convert(arr);

        musicController.deleteMusicsById(ids);
    }

    private void deleteArtistById(){
        listAllArtists();

        System.out.println("Digite os Id's dos artistas que deseja deletar: (Separados por virgula. Ex.: 2, 4, 1...): ");
        String id = scanner.nextLine();

        String[] arr = id.split(",");

        var list = ConvertArrayStringToList.convert(arr);

        artistController.deleteArtistById(list);
    }

    private void listAllArtists() {
        artistController.listAll().forEach(a -> System.out.println(a.getId() + " - " + a.getName()));
    }

    private void saveArtist() {
        System.out.println("Digite o nome do artista: ");
        String nome = scanner.nextLine();

        ArtistType artistType = null;

        while(artistType == null){

            ArtistType.listTypes();

            System.out.print("Digite o Id do tipo: ");
            int type = scanner.nextInt();
            try{
                artistType = ArtistType.fromCode(type);
            } catch(IllegalArgumentException e) {
                System.err.println(e.getMessage());
                System.out.println("Tente Novamente.\n");
            }
            scanner.nextLine();
        }

        artistController.createArtist(nome, artistType);
    }

    private void listMusics() {
        int option;

        do{
            System.out.println("""
                ---- Listar Musicas ----
                
                1 - Por Id
                2 - Por nome
                
                0 - Sair
                """);
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option){
                case 1: {
                    musicController.listAll().forEach(m -> System.out.println(m.getId() + " - " + m.getName() + " (" + m.getArtist().getName() + ")"));
                    long id = scanner.nextLong();
                    scanner.nextLine();

                    Optional<Music> music = musicController.getById(id);

                    music.ifPresentOrElse(
                            m -> System.out.println(m.getId() + " - " + m.getName() + " (" + m.getArtist().getName() + ")"),
                            () -> System.err.println("Não existe musica com esse Id: " + id)
                    );

                    break;
                }
                case 2: {
                    musicController.listAll().forEach(m -> System.out.println(m.getId() + " - " + m.getName() + " (" + m.getArtist().getName() + ")"));
                    System.out.println("Digite o nome da musica ou trecho do nome: ");
                    String name = scanner.nextLine();

                    Optional<Music> optionalMusic = musicController.getByName(name);

                    optionalMusic.ifPresentOrElse(
                            m -> System.out.println(m.getId() + " - " + m.getName() + " (" + m.getArtist().getName() + ")"),
                            () -> System.err.println("❌ Não foi possível encontrar música com esse nome: " + name)
                    );

                    break;
                }
            }
        } while(option != 0);
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

            listAllArtists();

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
