package br.com.ddd.infrastructure.product.repository.memory.adapter;

import br.com.ddd.infrastructure.product.repository.memory.ProductsMock;
import br.com.ddd.infrastructure.product.repository.memory.model.ProductModel;
import br.com.ddd.infrastructure.shared.repository.memory.BaseRepositoryMemory;

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
