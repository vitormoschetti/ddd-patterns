package br.com.ddd.infrastructure.product.repository.memory;

import br.com.ddd.infrastructure.shared.repository.memory.IMemoryMock;
import br.com.ddd.infrastructure.product.repository.memory.model.ProductModel;

import java.math.BigDecimal;
import java.util.*;

public class ProductsMock implements IMemoryMock {

    private final List<ProductModel> models;

    public ProductsMock() {
        this.models = new ArrayList<>(this.buildInitProducts());
    }

    public List<ProductModel> findAll() {
        return this.models;
    }

    public ProductModel findById(final String id) {
        return this.models.stream().filter(m -> m.id().equalsIgnoreCase(id)).findFirst().orElse(null);
    }

    public void create(ProductModel model) {
        this.models.add(model);
    }

    public void update(final ProductModel model) {
        final var result = this.findById(model.id());
        if (Objects.isNull(result))
            throw new RuntimeException("Product not found");
        this.models.remove(model);
        this.create(model);

    }

    private List<ProductModel> buildInitProducts() {
        return List.of(
                new ProductModel("product-test", "product-test", BigDecimal.ONE),
                this.buildProductModel(),
                this.buildProductModel(),
                this.buildProductModel(),
                this.buildProductModel(),
                this.buildProductModel()
        );
    }

    private ProductModel buildProductModel() {
        final var id = UUID.randomUUID().toString();
        return new ProductModel(id, "product-" + id, new BigDecimal(new Random().nextInt(100) + 1));
    }


}
