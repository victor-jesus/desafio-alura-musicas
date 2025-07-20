package com.victorjesus.projeto_desafio_musicas.service;

import java.util.List;
import java.util.Optional;

public interface CrudService<T, ID> {
    List<T> listAll();
    Optional<T> getById(ID id);
    void save(T item);
    void deleteAll();
    void deleteById(ID id);
}
