package br.gov.pb.codata.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public abstract class AbstractService<T, ID, R extends JpaRepository<T, ID>> {

    @Autowired
    protected R repository;

    public Optional<T> findById(ID id) {
        return repository.findById(id);
    }

    public List<T> findAllById(Iterable<ID> ids) {
        return repository.findAllById(ids);
    }

    public List<T> findAll() {
        return repository.findAll();
    }

    public boolean existsById(ID id) {
        return repository.existsById(id);
    }

    public T save(T entity) {
        return repository.save(entity);
    }

    public Collection<T> saveAll(Iterable<T> entities) {
        return repository.saveAll(entities);
    }

    public void delete(T entity) {
        repository.delete(entity);
    }

    public void deleteById(ID id) {
        repository.deleteById(id);
    }

    public void deleteAll(Iterable<T> entities) {
        repository.deleteAll(entities);
    }
}
