package br.com.ddd.infrastructure.shared.repository;

import br.com.ddd.infrastructure.shared.model.IModel;

import java.util.List;

public interface IRepositoryAdapter<T extends IModel> {

    void create(final T model);

    void update(final T model);

    T findById(final String id);

    List<T> findAll();

}
