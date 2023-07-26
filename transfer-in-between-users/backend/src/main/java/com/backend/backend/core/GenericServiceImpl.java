package com.backend.backend.core;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Objects;
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
    public T update(ID id, T t)  {
        Optional<T> entity = repository.findById(id);

        if (entity.isPresent()) {
            T existingEntity = entity.get();

            Field[] fields = t.getClass().getDeclaredFields();
            for (Field field: fields) {
                field.setAccessible(true);
                try {
                    Object value = field.get(t);
                    if(value != null) {
                        field.set(existingEntity, value);
                    }
                } catch (IllegalAccessException e) {
                    throw new IllegalArgumentException("Error updating field: " + field.getName(), e);
                }
            }

            return repository.save(existingEntity);
        } else {
            throw new EntityNotFoundException("Entity with id " + id + " not found.");
        }
    }

    @Override
    public void deleteById(ID id) {
        repository.deleteById(id);
    }
}
