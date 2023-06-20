package br.com.ddd.infrastructure.repository.memory.adapter;

import br.com.ddd.core.infra.repository.IRepositoryAdapter;
import br.com.ddd.infrastructure.db.memory.model.ProductModel;

import java.util.List;

public interface ProductRepositoryMemoryAdapter extends IRepositoryAdapter<ProductModel> {

    void create(final ProductModel model);

    void update(final ProductModel model);

    ProductModel findById(final String id);

    List<ProductModel> findAll();

}
