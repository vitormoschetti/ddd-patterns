package br.com.ddd.infrastructure.repository.memory.adapter.impl;

import br.com.ddd.infrastructure.db.memory.model.ProductModel;
import br.com.ddd.infrastructure.repository.memory.adapter.ProductRepositoryMemoryAdapter;
import br.com.ddd.infrastructure.repository.memory.mock.ProductsMock;

import java.util.List;

public class ProductRepositoryMemoryAdapterImpl extends BaseRepositoryMemory<ProductsMock> implements ProductRepositoryMemoryAdapter {

    public ProductRepositoryMemoryAdapterImpl(final ProductsMock mock) {
        super(mock);
    }

    @Override
    public void create(final ProductModel model) {
        this.mock.create(model);
    }

    @Override
    public void update(final ProductModel model) {
        this.mock.update(model);
    }

    @Override
    public ProductModel findById(final String id) {
        return this.mock.findById(id);
    }

    @Override
    public List<ProductModel> findAll() {
        return this.mock.findAll();
    }
}
