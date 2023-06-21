package br.com.ddd.domain.entities.customer;

import br.com.ddd.domain.shared.entity.exception.DomainException;
import br.com.ddd.domain.customer.valueobject.AddressVO;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

public class AddressTest {

    @Test
    @DisplayName("should throw domain exception when street is empty")
    public void shouldThrowDomainExceptionWhenStreetEmpty() {

        final var exception = Assertions.assertThrows(DomainException.class, () -> new AddressVO("", "city", "state", "zipCode"));

        Assertions.assertEquals("Street is required", exception.getMessage());

    }

    @Test
    @DisplayName("should throw domain exception when city is empty")
    public void shouldThrowDomainExceptionWhenCityEmpty() {

        final var exception = Assertions.assertThrows(DomainException.class, () -> new AddressVO("street", "", "state", "zipCode"));

        Assertions.assertEquals("City is required", exception.getMessage());

    }

    @Test
    @DisplayName("should throw domain exception when state is empty")
    public void shouldThrowDomainExceptionWhenStateEmpty() {

        final var exception = Assertions.assertThrows(DomainException.class, () -> new AddressVO("street", "city", "", "zipCode"));

        Assertions.assertEquals("State is required", exception.getMessage());

    }

    @Test
    @DisplayName("should throw domain exception when zipCode is empty")
    public void shouldThrowDomainExceptionWhenZipCodeEmpty() {

        final var exception = Assertions.assertThrows(DomainException.class, () -> new AddressVO("street", "city", "state", ""));

        Assertions.assertEquals("ZipCode is required", exception.getMessage());

    }

}
