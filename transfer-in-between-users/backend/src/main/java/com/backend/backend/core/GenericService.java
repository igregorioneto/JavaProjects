package com.backend.backend.core;

import java.util.List;
import java.util.Optional;

public interface GenericService<T, ID> {
    List<T> getAll();
    Optional<T> getById(ID id);
    T save(T entity);
    void deleteById(ID id);
}
