package com.gregaux.backend.service;

import org.springframework.data.jpa.repository.JpaRepository;

public abstract class GenericService<T, ID> {
    private final JpaRepository<T, ID> repository;

    public GenericService(JpaRepository<T, ID> repository) {
        this.repository = repository;
    }

    public T getById(ID id) {
        return repository.findById(id).orElse(null);
    }

    public Iterable<T> getAll() {
        return repository.findAll();
    }

    public T create(T entity) {
        return repository.save(entity);
    }

    public T update(T entity) {
        return repository.save(entity);
    }

    public void delete(ID id) {
        repository.deleteById(id);
    }
}
