package br.com.ddd.domain.customer.event.handler;

import br.com.ddd.domain.shared.event.IEvent;
import br.com.ddd.domain.shared.event.IEventHandler;
import br.com.ddd.domain.customer.entity.Customer;

public class SendMessageWhenCustomerChangedAddressEventHandler implements IEventHandler<Customer> {

    @Override
    public void handle(final IEvent<Customer> event) {
        System.out.println("TraceId: " + event.traceId() + ". Instant: " + event.instantCreated() + ".");
        System.out.println("Payload: " + event.payload());
        System.out.println();
    }
}
