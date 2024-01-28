package com.example.fabrikaline_backend.ABC;

import org.springframework.http.ResponseEntity;

public interface IAbstractService<T> {
    T save(T entity) throws Exception;
    void delete(int id);
}
