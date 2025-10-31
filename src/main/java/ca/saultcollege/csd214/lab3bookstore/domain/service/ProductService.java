package ca.saultcollege.csd214.lab3bookstore.domain.service;

import java.util.List;
import java.util.Optional;

/**
 * Generic CRUD contract to enable IoC.
 * @param <T> Entity type
 */
public interface ProductService<T> {
    T create(T entity);
    T update(Long id, T entity);
    void delete(Long id);
    Optional<T> get(Long id);
    List<T> getAll();
}