package br.com.ddd.domain.customer.event.handler;

import br.com.ddd.domain.shared.event.IEvent;
import br.com.ddd.domain.shared.event.IEventHandler;
import br.com.ddd.domain.customer.entity.Customer;

public class PrintLog2WhenCustomerCreatedEventHandler implements IEventHandler<Customer> {

    @Override
    public void handle(final IEvent<Customer> event) {
        System.out.println("TraceId: " + event.traceId() + ". Instant: " + event.instantCreated());
        System.out.println("Esse é o segundo log do evento: CustomerCreated. " + event.payload());
        System.out.println();
    }
}
