package br.com.ddd.infrastructure.product.repository.memory.adapter;

import br.com.ddd.infrastructure.product.repository.memory.model.ProductModel;
import br.com.ddd.infrastructure.shared.repository.IRepositoryAdapter;

import java.util.List;

public interface ProductRepositoryMemoryAdapter extends IRepositoryAdapter<ProductModel> {

    void create(final ProductModel model);

    void update(final ProductModel model);

    ProductModel findById(final String id);

    List<ProductModel> findAll();

}
