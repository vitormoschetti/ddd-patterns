package br.com.ddd.domain.entity.product;

import br.com.ddd.domain.exception.DomainException;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {

    private final String id;
    private String name;
    private BigDecimal price;

    public Product(final String id, final String name, final BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.validate();
    }

    private void validate() {
        if (Objects.isNull(this.id) || this.id.isBlank())
            throw new DomainException("Id is required");
        if (Objects.isNull(this.name) || this.name.isBlank())
            throw new DomainException("Name is required");
        if (Objects.isNull(this.price) || this.price.compareTo(BigDecimal.ZERO) <= 0)
            throw new DomainException("Price is required");
    }

    public void changeName(final String name) {
        this.name = name;
        this.validate();
    }

    public void changePrice(final BigDecimal price) {
        this.price = price;
        this.validate();
    }

    public BigDecimal getPrice() {
        return price;
    }
}
