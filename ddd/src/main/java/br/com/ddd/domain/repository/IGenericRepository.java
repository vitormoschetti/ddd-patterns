package br.com.ddd.domain.repository;

import br.com.ddd.core.domain.entity.IAggregateRoot;
import br.com.ddd.core.domain.repository.IRepository;

import java.util.List;

public interface IGenericRepository<T extends IAggregateRoot> extends IRepository<T> {

    void create(final T entity);

    void update(final T entity);

    T findById(final String id);

    List<T> findAll();

}
