package com.victorjesus.projeto_desafio_musicas.service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public abstract class BaseService<T, ID> implements CrudService<T, ID> {
    protected JpaRepository<T, ID> repository;

    public BaseService(JpaRepository<T, ID> repository){
        this.repository = repository;
    }

    @Override
    public List<T> listAll() {
        return repository.findAll();
    }

    @Override
    public Optional<T> getById(ID id) {
        return repository.findById(id);
    }

    @Override
    public void save(T item) {
        repository.save(item);
    }

    @Override
    public void deleteById(ID id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
