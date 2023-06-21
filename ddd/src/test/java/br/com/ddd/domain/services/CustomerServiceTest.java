package br.com.ddd.domain.services;

import br.com.ddd.BaseTeste;
import br.com.ddd.domain.events.customer.CustomerChangedAddressEvent;
import br.com.ddd.domain.events.customer.CustomerCreatedEvent;
import br.com.ddd.domain.events.customer.handler.PrintLog2WhenCustomerCreatedEventHandler;
import br.com.ddd.domain.events.customer.handler.PrintLogWhenCustomerCreatedEventHandler;
import br.com.ddd.domain.events.customer.handler.SendMessageWhenCustomerChangedAddressEventHandler;
import br.com.ddd.domain.events.shared.CustomerEventDispatcher;
import br.com.ddd.domain.service.CustomerService;
import br.com.ddd.infrastructure.repository.CustomerRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import java.util.UUID;

import static org.mockito.Mockito.*;

public class CustomerServiceTest extends BaseTeste {

    @Test
    @DisplayName("should notify handlers after created customer")
    public void shouldNotifyHandlersAfterCreatedCustomer() {

        final var dispatcher = new CustomerEventDispatcher();
        final var repository = new CustomerRepository();

        final var printHandler = spy(new PrintLogWhenCustomerCreatedEventHandler());

        final var print2Handler = spy(new PrintLog2WhenCustomerCreatedEventHandler());

        dispatcher.register("CustomerCreatedEvent", printHandler);
        dispatcher.register("CustomerCreatedEvent", print2Handler);

        final var customerService = new CustomerService(dispatcher, repository);

        final var customer = customerService.notifyCreated("1", "handlers-test", this.buildValidAddressVO());

        Assertions.assertEquals("1", customer.getId());
        Assertions.assertEquals("handlers-test", customer.getName());
        Assertions.assertEquals(this.buildValidAddressVO(), customer.getAddress());
        Assertions.assertEquals(0L, customer.getRewardPoints());
        Assertions.assertEquals(Boolean.TRUE, customer.isActive());

        verify(printHandler, times(1)).handle(any(CustomerCreatedEvent.class));
        verify(print2Handler, times(1)).handle(any(CustomerCreatedEvent.class));


    }

    @Test
    @DisplayName("should notify handlers after changed address")
    public void shouldNotifyHandlersAfterChangedAddress() {

        final var dispatcher = new CustomerEventDispatcher();
        final var repository = new CustomerRepository();

        final var handler = spy(new SendMessageWhenCustomerChangedAddressEventHandler());

        dispatcher.register("CustomerChangedAddressEvent", handler);

        final var customerService = new CustomerService(dispatcher, repository);

        final var customer = this.buildValidCustomer();

        final var result = customerService.notifyChangeAddress(
                customer,
                this.buildAddressVOWith(
                        UUID.randomUUID().toString(),
                        UUID.randomUUID().toString(),
                        UUID.randomUUID().toString(),
                        UUID.randomUUID().toString()));

        Assertions.assertEquals(customer.getId(), result.getId());
        Assertions.assertEquals(customer.getName(), result.getName());
        Assertions.assertEquals(customer.getAddress(), result.getAddress());
        Assertions.assertEquals(customer.getRewardPoints(), result.getRewardPoints());
        Assertions.assertEquals(customer.isActive(), result.isActive());

        verify(handler, times(1)).handle(any(CustomerChangedAddressEvent.class));

    }

}
