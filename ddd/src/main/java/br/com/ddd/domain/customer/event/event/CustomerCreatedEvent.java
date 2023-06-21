package br.com.ddd.domain.customer.event.event;

import br.com.ddd.domain.customer.entity.Customer;
import br.com.ddd.domain.shared.event.IEvent;

import java.time.Instant;
import java.time.ZoneOffset;
import java.util.UUID;

public class CustomerCreatedEvent implements IEvent<Customer> {

    private final String traceId;
    private final Customer payload;
    private final Instant instantCreated;

    public CustomerCreatedEvent(final Customer payload) {
        this.traceId = UUID.randomUUID().toString();
        this.instantCreated = Instant.now().atOffset(ZoneOffset.UTC).toInstant();
        this.payload = payload;
    }

    @Override
    public String traceId() {
        return this.traceId;
    }

    @Override
    public Instant instantCreated() {
        return this.instantCreated;
    }

    @Override
    public Customer payload() {
        return this.payload;
    }
}
