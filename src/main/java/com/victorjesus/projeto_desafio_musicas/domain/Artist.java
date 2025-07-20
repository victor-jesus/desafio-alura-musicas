package com.victorjesus.projeto_desafio_musicas.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "artist")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int idade;
    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Music> musics;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public List<Music> getMusics() {
        return musics;
    }

    public void setMusics(List<Music> musics) {
        this.musics.forEach(m -> m.setArtist(this));
        this.musics = musics;
    }
}
