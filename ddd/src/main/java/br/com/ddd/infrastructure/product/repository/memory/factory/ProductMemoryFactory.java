package br.com.ddd.infrastructure.product.repository.memory.factory;

import br.com.ddd.domain.product.entity.Product;
import br.com.ddd.infrastructure.product.repository.memory.model.ProductModel;
import br.com.ddd.infrastructure.product.repository.shared.IProductModel;
import br.com.ddd.infrastructure.shared.factory.IFactory;

public class ProductMemoryFactory implements IFactory<Product, IProductModel> {

    @Override
    public IProductModel convert(final Product input) {
        return new ProductModel(input.getId(), input.getName(), input.getPrice());
    }
}
