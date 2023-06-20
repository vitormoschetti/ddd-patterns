package br.com.ddd.domain.events.product;

import br.com.ddd.core.domain.events.IEvent;
import br.com.ddd.domain.entity.product.Product;

import java.time.Instant;
import java.time.ZoneOffset;

public class ProductCreatedEvent implements IEvent<Product> {

    private final Product data;
    private final Instant date;

    @Override
    public Instant dateTimeOccured() {
        return this.date;
    }

    @Override
    public Product eventData() {
        return this.data;
    }

    public ProductCreatedEvent(final Product data) {
        this.data = data;
        this.date = Instant.now().atOffset(ZoneOffset.UTC).toInstant();
    }


}
