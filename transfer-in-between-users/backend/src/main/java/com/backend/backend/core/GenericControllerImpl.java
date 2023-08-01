package com.backend.backend.core;

import com.backend.backend.dto.SuccessResponseDTO;
import com.backend.backend.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public abstract class GenericControllerImpl<T, ID, S extends GenericService<T, ID>> implements GenericController<T, ID> {

    protected final S service;

    @Autowired
    private ResponseMessage<T> mensage;

    public GenericControllerImpl(S service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<SuccessResponseDTO<?>> getAll() {
        List<T> entities = service.getAll();
        return ResponseEntity.ok(
                mensage.MessageReturn("Success", HttpStatus.OK.value(), (T) entities)
        );
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

    @PutMapping("/{id}")
    public ResponseEntity<T> update(@PathVariable ID id, @RequestBody T entity) {
        T updatedEntity = service.update(id, entity);
        return ResponseEntity.ok(updatedEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable ID id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
