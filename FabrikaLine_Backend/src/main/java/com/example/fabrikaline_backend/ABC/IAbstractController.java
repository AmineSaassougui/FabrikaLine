package com.example.fabrikaline_backend.ABC;

import com.example.fabrikaline_backend.Models.SearchCriteria;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface  IAbstractController<T> {
    ResponseEntity<T> load(Long id);
    void delete(Long id);
    ResponseEntity<T> save(T entity) throws Exception;
    ResponseEntity<List<T>> saveAll(List<T> entities) throws Exception;
    ResponseEntity<List<T>> getAll() throws Exception;


  // Tby medSa (to delete)
   // ResponseEntity<List<T>> search(SearchCriteria criteria) throws Exception;
   // ResponseEntity<List<T>> getAll(Long page, Long size) throws Exception;
   // ResponseEntity<Long> count() throws Exception;
   // ResponseEntity<Void> deleteAll(List<Integer> ids) throws Exception;
}
