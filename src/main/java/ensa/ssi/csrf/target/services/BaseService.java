package ensa.ssi.csrf.target.services;

import ensa.ssi.csrf.target.entities.Client;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor @Transactional @Slf4j
public class BaseService<T, Long> implements IBaseService<T, Long>{
    protected final JpaRepository<T, Long> repository;

    @Override
    public T saveEntity(T entity) {
        log.info("Saving new entity of type " + entity.getClass().toString());
        return  repository.save(entity);
    }

    @Override
    public Optional<T> findEntityByLong(Long key) {
        return repository.findById(key);
    }


    @Override
    public List<T> getAllEntities() {
        log.info("Fetching all entity ");
        return repository.findAll();
    }

    @Override
    public void deleteEntity(Long key) {
        log.info("Deleting entity");
        repository.delete((T) repository.findById(key));
    }

    @Override
    public void deleteAllEntities(List<Long> keys) {
        log.info("Deleting all entities");
        repository.deleteAll(repository.findAllById(keys));
    }
}
