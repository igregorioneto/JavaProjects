package com._aux.backend.controller;

import com._aux.backend.service.GenericService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "Generics Métodos")
public class GenericController<T, ID> {
    private final GenericService<T, ID> service;

    @Autowired
    public GenericController(GenericService<T, ID> service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get Entity By ID", notes = "This endpoint retrives un entity by its ID.")
    public T getById(@PathVariable ID id) {
        return service.getById(id);
    }

    @GetMapping
    public Iterable<T> getAll() {
        return service.getAll();
    }

    @PostMapping
    public T create(@RequestBody T entity) {
        return service.create(entity);
    }

    @PutMapping
    public T update(@RequestBody T entity) {
        return service.update(entity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable ID id) {
        service.delete(id);
    }
}
