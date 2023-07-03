package br.com.ddd.infrastructure.product.repository.memory.adapter.adaptersMock;

import br.com.ddd.infrastructure.product.repository.shared.IProductModel;
import br.com.ddd.infrastructure.product.repository.memory.model.ProductModel;

import java.math.BigDecimal;
import java.util.*;

public class ProductsMock {

    private final List<IProductModel> models;

    public ProductsMock() {
        this.models = new ArrayList<>(this.buildInitProducts());
    }

    public List<IProductModel> findAll() {
        return this.models;
    }

    public IProductModel findById(final String id) {
        return this.models.stream().filter(m -> m.id().equalsIgnoreCase(id)).findFirst().orElse(null);
    }

    public void create(IProductModel model) {
        this.models.add(model);
    }

    public void update(final IProductModel model) {
        final var result = this.findById(model.id());
        if (Objects.isNull(result))
            throw new RuntimeException("Product not found");
        this.models.remove(model);
        this.create(model);

    }

    private List<IProductModel> buildInitProducts() {
        return List.of(
                new ProductModel("product-test", "product-test", BigDecimal.ONE),
                this.buildProductModel(),
                this.buildProductModel(),
                this.buildProductModel(),
                this.buildProductModel(),
                this.buildProductModel()
        );
    }

    private IProductModel buildProductModel() {
        final var id = UUID.randomUUID().toString();
        return new ProductModel(id, "product-" + id, new BigDecimal(new Random().nextInt(100) + 1));
    }


}
