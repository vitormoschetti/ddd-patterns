package br.com.ddd.domain.events.customer.handler;

import br.com.ddd.core.domain.events.IEvent;
import br.com.ddd.core.domain.events.shared.IEventHandler;
import br.com.ddd.domain.entity.customer.Customer;

public class PrintLogWhenCustomerCreatedEventHandler implements IEventHandler<Customer> {

    @Override
    public void handle(final IEvent<Customer> event) {
        System.out.println("TraceId: " + event.traceId() + ". Instant: " + event.instantCreated());
        System.out.println("Esse é o primeiro log do evento: CustomerCreated. " + event.payload());
        System.out.println();
    }
}
