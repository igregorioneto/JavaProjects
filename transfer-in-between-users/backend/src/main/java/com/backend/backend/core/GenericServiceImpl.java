package com.backend.backend.core;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public abstract class GenericServiceImpl<T, ID, R extends JpaRepository<T, ID>> implements GenericService<T, ID> {
    protected final R repository;

    public GenericServiceImpl(R repository) {
        this.repository = repository;
    }

    @Override
    public List<T> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<T> getById(ID id) {
        return repository.findById(id);
    }

    @Override
    public T save(T t) {
        return repository.save(t);
    }

    @Override
    public void deleteById(ID id) {
        repository.deleteById(id);
    }
}
