package br.com.ddd.infrastructure.product.repository.memory.model;

import br.com.ddd.infrastructure.product.repository.shared.IProductModel;

import java.math.BigDecimal;
import java.util.Objects;

public record ProductModel(String id, String name, BigDecimal price) implements IProductModel {

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final ProductModel that = (ProductModel) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
