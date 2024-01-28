package com.example.fabrikaline_backend.ABC;

import com.example.fabrikaline_backend.Models.SearchCriteria;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface  IAbstractController<T> {
    ResponseEntity<T> load(int id);
    void delete(int id);
    ResponseEntity<T> save(T entity) throws Exception;
    ResponseEntity<List<T>> saveAll(List<T> entities) throws Exception;
    ResponseEntity<List<T>> getAll() throws Exception;
    ResponseEntity<T> update(int id, T entity) throws Exception;
    ResponseEntity<List<T>> search(SearchCriteria criteria) throws Exception;
    ResponseEntity<List<T>> getAll(int page, int size) throws Exception;
    ResponseEntity<Long> count() throws Exception;
    ResponseEntity<Void> deleteAll(List<Integer> ids) throws Exception;
}
