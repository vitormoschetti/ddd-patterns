package br.com.ddd.domain.customer.entity;


import br.com.ddd.BaseTeste;
import br.com.ddd.domain.shared.entity.exception.DomainException;
import br.com.ddd.domain.shared.notification.DomainNotificationError;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CustomerTest extends BaseTeste {

    @Test
    @DisplayName("should throw domain exception when id is empty")
    public void shouldThrowDomainExceptionWhenIdEmpty() {

        final var customer = new Customer("", "", "street", "city", "state", "zipcode");

        assertTrue(customer.hasErrors());
        assertEquals(2, customer.getMessages().size());
        assertEquals(Set.of(
                new DomainNotificationError("Id is required", Customer.class.getSimpleName()),
                new DomainNotificationError("Name is required", Customer.class.getSimpleName())
        ), customer.getMessages());

    }

    @Test
    @DisplayName("should throw domain exception when change name is null")
    public void shouldThrowDomainExceptionWhenChangeNameNull() {

        final var customer = this.buildValidCustomer();

        customer.changeName(null);

        assertTrue(customer.hasErrors());
        assertEquals(1, customer.getMessages().size());
        assertEquals(Set.of(
                new DomainNotificationError("Name is required", Customer.class.getSimpleName())
        ), customer.getMessages());

    }

    @Test
    @DisplayName("should become customer deactivate")
    public void shouldBecomeCustomerDeactivate() {

        final var customer = this.buildValidCustomer();

        customer.deactivate();

        assertEquals(Boolean.FALSE, customer.isActive());

    }

    @Test
    @DisplayName("should become customer activate")
    public void shouldBecomeCustomerActivate() {

        final var customer = this.buildValidCustomer();

        customer.deactivate();
        customer.activate();

        assertEquals(Boolean.TRUE, customer.isActive());

    }

    @Test
    @DisplayName("should add reward points")
    public void shouldAddRewardPoints() {

        final var customer = this.buildValidCustomer();

        assertEquals(0L, customer.getRewardPoints());

        customer.addRewardPoints(10L);

        assertEquals(10L, customer.getRewardPoints());

        customer.addRewardPoints(10L);

        assertEquals(20L, customer.getRewardPoints());

    }

    @Test
    @DisplayName("should throw domain exception when reward points is less than 0")
    public void shouldThrowDomainExceptionWhenRewardPointsIsLessThanZero() {

        final var customer = this.buildValidCustomer();

        final var exception = Assertions.assertThrows(DomainException.class, () -> customer.addRewardPoints(-10L));

        assertEquals("Reward Points must be greater equal zero", exception.getMessage());

    }

}
