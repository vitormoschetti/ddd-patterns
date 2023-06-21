package br.com.ddd.domain.events.product.handler;

import br.com.ddd.core.domain.events.IEvent;
import br.com.ddd.core.domain.events.shared.IEventHandler;
import br.com.ddd.domain.entity.product.Product;

public class SendEmailWhenProductCreatedEventHandler implements IEventHandler<Product> {

    @Override
    public void handle(final IEvent<Product> event) {
        System.out.println("TraceId: " + event.traceId() + "\nSending email to " + event.payload() + " at " + event.instantCreated());
        System.out.println();
    }
}
