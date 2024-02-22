package com.example.fabrikaline_backend.ABC;

import com.example.fabrikaline_backend.Models.SearchCriteria;

import javax.validation.ValidationException;
import java.util.List;
public interface IAbstractService<T> {
    T save(T entity) throws Exception;
    void delete(Long id);

    List<T> getAll();

    List<T> saveAll(List<T> entities) throws Exception;

    List<T> search(SearchCriteria criteria);

    long count();

    void validate(T entity) throws ValidationException;

    T getById(Long id);



}
