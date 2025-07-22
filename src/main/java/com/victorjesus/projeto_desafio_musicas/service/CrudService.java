package com.victorjesus.projeto_desafio_musicas.service;

import java.util.List;
import java.util.Optional;

public interface CrudService<T, ID> {
    Optional<T> getById(ID id);
    List<T> listAll();
    T save(T item);
    void deleteAll();
    void deleteItens(List<ID> ids);

}
