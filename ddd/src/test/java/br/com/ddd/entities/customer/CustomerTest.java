package br.com.ddd.entities.customer;


import br.com.ddd.BaseTeste;
import br.com.ddd.domain.exception.DomainException;
import br.com.ddd.domain.entities.customer.Customer;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import java.util.UUID;

public class CustomerTest extends BaseTeste {

    @Test
    @DisplayName("should throw domain exception when id is empty")
    public void shouldThrowDomainExceptionWhenIdEmpty() {

        final var exception = Assertions.assertThrows(DomainException.class, () -> new Customer("", "Vitor", this.buildValidAddressVO()));

        Assertions.assertEquals("Id is required", exception.getMessage());

    }

    @Test
    @DisplayName("should throw domain exception when Name is empty")
    public void shouldThrowDomainExceptionWhenNameEmpty() {

        final var exception = Assertions.assertThrows(DomainException.class, () -> new Customer(UUID.randomUUID().toString(), "", this.buildValidAddressVO()));

        Assertions.assertEquals("Name is required", exception.getMessage());

    }

    @Test
    @DisplayName("should throw domain exception when Address is null")
    public void shouldThrowDomainExceptionWhenAddressNull() {

        final var exception = Assertions.assertThrows(DomainException.class, () -> new Customer(UUID.randomUUID().toString(), "vitor", null));

        Assertions.assertEquals("Address is required", exception.getMessage());

    }

    @Test
    @DisplayName("should throw domain exception when change name is null")
    public void shouldThrowDomainExceptionWhenChangeNameNull() {

        final var customer = this.buildValidCustomer();

        final var exception = Assertions.assertThrows(DomainException.class, () -> customer.changeName(null));

        Assertions.assertEquals("Name is required", exception.getMessage());

    }

    @Test
    @DisplayName("should become customer deactivate")
    public void shouldBecomeCustomerDeactivate() {

        final var customer = this.buildValidCustomer();

        customer.deactivate();

        Assertions.assertEquals(Boolean.FALSE, customer.isActive());

    }

    @Test
    @DisplayName("should become customer activate")
    public void shouldBecomeCustomerActivate() {

        final var customer = this.buildValidCustomer();

        customer.deactivate();
        customer.activate();

        Assertions.assertEquals(Boolean.TRUE, customer.isActive());

    }


}
