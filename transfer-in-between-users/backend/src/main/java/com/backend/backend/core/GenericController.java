package com.backend.backend.core;

import com.backend.backend.dto.SuccessResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface GenericController<T, ID> {
    ResponseEntity<SuccessResponseDTO<?>> getAll();
    ResponseEntity<Optional<T>> getById(ID id);
    ResponseEntity<T> create(T t);
    ResponseEntity<T> update(ID id, T t);
    ResponseEntity<Void> delete(ID id);
}
