package com.backend.backend.core;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface GenericController<T, ID> {
    ResponseEntity<List<T>> getAll();
    ResponseEntity<Optional<T>> getById(ID id);
    ResponseEntity<T> create(T t);
    //ResponseEntity<T> update(ID id, T t);
    ResponseEntity<Void> delete(ID id);
}
