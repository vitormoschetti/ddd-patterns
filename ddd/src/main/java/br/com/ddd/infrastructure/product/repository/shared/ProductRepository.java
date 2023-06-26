package br.com.ddd.infrastructure.product.repository.shared;

import br.com.ddd.domain.product.entity.Product;
import br.com.ddd.domain.product.repository.IProductRepository;
import br.com.ddd.infrastructure.shared.factory.IFactory;
import br.com.ddd.infrastructure.shared.repository.IRepositoryAdapter;

import java.util.List;

public class ProductRepository implements IProductRepository {

    private final IRepositoryAdapter<IProductModel> to;
    private final IFactory<Product, IProductModel> factory;

    public ProductRepository(final IRepositoryAdapter<IProductModel> to, final IFactory<Product, IProductModel> factory) {
        this.to = to;
        this.factory = factory;
    }

    @Override
    public void create(final Product entity) {
        this.to.create(this.factory.convert(entity));
    }

    @Override
    public void update(final Product entity) {
        this.to.update(this.factory.convert(entity));
    }

    @Override
    public Product findById(final String id) {
        final var model = this.to.findById(id);
        return new Product(model.id(), model.name(), model.price());
    }

    @Override
    public List<Product> findAll() {
        return this.to.findAll().stream().map(m -> new Product(m.id(), m.name(), m.price())).toList();

    }
}
