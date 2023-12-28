package ensa.ssi.csrf.target.services;

import java.util.List;
import java.util.Optional;

public interface IBaseService<T, Long> {
    T saveEntity(T entity);
    Optional<T> findEntityByLong(Long key);
    List<T> getAllEntities();
    void deleteEntity(Long key);
    void deleteAllEntities(List<Long> keys);
}
