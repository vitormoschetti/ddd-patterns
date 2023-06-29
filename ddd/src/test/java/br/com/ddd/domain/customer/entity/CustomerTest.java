package br.com.ddd.domain.customer.entity;


import br.com.ddd.BaseTeste;
import br.com.ddd.domain.shared.entity.exception.DomainException;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import java.util.UUID;

public class CustomerTest extends BaseTeste {

    @Test
    @DisplayName("should throw domain exception when id is empty")
    public void shouldThrowDomainExceptionWhenIdEmpty() {

        final var exception = Assertions.assertThrows(DomainException.class, () -> new Customer("", "Vitor", "street", "city", "state", "zipcode"));

        Assertions.assertEquals("Id is required", exception.getMessage());

    }

    @Test
    @DisplayName("should throw domain exception when Name is empty")
    public void shouldThrowDomainExceptionWhenNameEmpty() {

        final var exception = Assertions.assertThrows(DomainException.class, () -> new Customer(UUID.randomUUID().toString(), "", "street", "city", "state", "zipcode"));

        Assertions.assertEquals("Name is required", exception.getMessage());

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

    @Test
    @DisplayName("should add reward points")
    public void shouldAddRewardPoints() {

        final var customer = this.buildValidCustomer();

        Assertions.assertEquals(0L, customer.getRewardPoints());

        customer.addRewardPoints(10L);

        Assertions.assertEquals(10L, customer.getRewardPoints());

        customer.addRewardPoints(10L);

        Assertions.assertEquals(20L, customer.getRewardPoints());

    }

    @Test
    @DisplayName("should throw domain exception when reward points is less than 0")
    public void shouldThrowDomainExceptionWhenRewardPointsIsLessThanZero() {

        final var customer = this.buildValidCustomer();

        final var exception = Assertions.assertThrows(DomainException.class, () -> customer.addRewardPoints(-10L));

        Assertions.assertEquals("Reward Points must be greater equal zero", exception.getMessage());

    }


}
