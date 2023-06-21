package br.com.ddd.domain.events.customer;

import br.com.ddd.core.domain.events.IEvent;
import br.com.ddd.domain.entity.customer.Customer;

import java.time.Instant;
import java.time.ZoneOffset;
import java.util.UUID;

public class CustomerChangedAddressEvent implements IEvent<Customer> {

    private final String traceId;
    private final Customer payload;
    private final Instant instantCreated;

    public CustomerChangedAddressEvent(final Customer payload) {
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
