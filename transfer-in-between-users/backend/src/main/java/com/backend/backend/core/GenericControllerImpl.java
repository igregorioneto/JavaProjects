package com.backend.backend.core;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public abstract class GenericControllerImpl<T, ID, S extends GenericService<T, ID>> implements GenericController<T, ID> {

    protected final S service;

    public GenericControllerImpl(S service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<T>> getAll() {
        List<T> entities = service.getAll();
        return ResponseEntity.ok(entities);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<T>> getById(@PathVariable ID id) {
        return (ResponseEntity<Optional<T>>) service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<T> create(@RequestBody T entity) {
        T newEntity = service.save(entity);
        return ResponseEntity.ok(newEntity);
    }

    /*@PutMapping("/{id}")
    public ResponseEntity<T> update(@PathVariable ID id, @RequestBody T entity) {
        T updatedEntity = (T) service.getById(id).orElse(null);
        return null;
    }*/

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable ID id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
