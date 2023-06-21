package br.com.ddd.infrastructure.product.repository;

import br.com.ddd.domain.product.entity.Product;
import br.com.ddd.domain.product.repository.IProductRepository;
import br.com.ddd.infrastructure.product.repository.memory.model.ProductModel;
import br.com.ddd.infrastructure.product.repository.memory.adapter.ProductRepositoryMemoryAdapter;

import java.util.List;

public class ProductRepository implements IProductRepository {

    private final ProductRepositoryMemoryAdapter to;

    public ProductRepository(final ProductRepositoryMemoryAdapter to) {
        this.to = to;
    }

    @Override
    public void create(final Product entity) {
        this.to.create(new ProductModel(entity.getId(), entity.getName(), entity.getPrice()));
    }

    @Override
    public void update(final Product entity) {
        this.to.update(new ProductModel(entity.getId(), entity.getName(), entity.getPrice()));
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
