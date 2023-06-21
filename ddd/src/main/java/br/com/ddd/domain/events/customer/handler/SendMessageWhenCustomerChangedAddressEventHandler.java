package br.com.ddd.domain.events.customer.handler;

import br.com.ddd.core.domain.events.IEvent;
import br.com.ddd.core.domain.events.shared.IEventHandler;
import br.com.ddd.domain.entity.customer.Customer;

public class SendMessageWhenCustomerChangedAddressEventHandler implements IEventHandler<Customer> {

    @Override
    public void handle(final IEvent<Customer> event) {
        System.out.println("TraceId: " + event.traceId() + ". Instant: " + event.instantCreated() + ".");
        System.out.println("Payload: " + event.payload());
        System.out.println();
    }
}
