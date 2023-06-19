package br.com.ddd.domain.entity.order;

import br.com.ddd.domain.exception.DomainException;

import java.math.BigDecimal;
import java.util.Objects;

public class OrderItem {

    private final String id;
    private final String name;
    private final BigDecimal price;
    private final String productId;
    private final Long quantity;

    public OrderItem(final String id, final String name, final BigDecimal price, final String productId, final Long quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.productId = productId;
        this.quantity = quantity;
        this.validate();
    }

    private void validate() {
        if (Objects.isNull(this.id) || this.id.isBlank())
            throw new DomainException("Id is required");
        if (Objects.isNull(this.name) || this.name.isBlank())
            throw new DomainException("Name is required");
        if (Objects.isNull(this.price) || this.price.compareTo(BigDecimal.ZERO) <= 0)
            throw new DomainException("Price is required");
        if (Objects.isNull(this.productId) || this.productId.isBlank())
            throw new DomainException("ProductId is required");
        if (Objects.isNull(this.quantity) || this.quantity.compareTo(0L) <= 0)
            throw new DomainException("Quantity is required");
    }

    public BigDecimal getTotal() {
        return this.price.multiply(new BigDecimal(this.quantity));
    }

}
