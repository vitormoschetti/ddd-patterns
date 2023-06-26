package br.com.ddd.infrastructure.product.repository.memory.adapter;

import br.com.ddd.infrastructure.product.repository.memory.adapter.adaptersMock.ProductsMock;
import br.com.ddd.infrastructure.product.repository.shared.IProductModel;
import br.com.ddd.infrastructure.shared.repository.IRepositoryAdapter;

import java.util.List;

public class ProductMemoryRepositoryAdapterImpl implements IRepositoryAdapter<IProductModel> {

    private final ProductsMock mock;

    public ProductMemoryRepositoryAdapterImpl(final ProductsMock mock) {
        this.mock = mock;
    }

    @Override
    public void create(final IProductModel model) {
        this.mock.create(model);
    }

    @Override
    public void update(final IProductModel model) {
        this.mock.update(model);
    }

    @Override
    public IProductModel findById(final String id) {
        return this.mock.findById(id);
    }

    @Override
    public List<IProductModel> findAll() {
        return this.mock.findAll();
    }
}
