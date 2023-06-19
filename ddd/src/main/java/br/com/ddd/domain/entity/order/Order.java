package br.com.ddd.domain.entity.order;

import br.com.ddd.domain.exception.DomainException;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class Order {

    private final String id;
    private final String customerId;
    private final List<OrderItem> items;

    public Order(final String id, final String customerId, final List<OrderItem> items) {
        this.id = id;
        this.customerId = customerId;
        this.items = items;
        this.validate();
    }

    private void validate() {
        if (Objects.isNull(this.id) || this.id.isEmpty())
            throw new DomainException("Id is required");
        if (Objects.isNull(this.customerId) || this.customerId.isEmpty())
            throw new DomainException("CustomerId is required");
        if (Objects.isNull(this.items) || this.items.isEmpty())
            throw new DomainException("Order must have at least one item");
    }

    public BigDecimal total() {

        return this.items.stream().map(OrderItem::getTotal).reduce(BigDecimal.ZERO, BigDecimal::add);

    }
}
