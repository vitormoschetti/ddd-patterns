package br.com.ddd.domain.entity.customer;

import br.com.ddd.core.domain.entity.IValueObject;
import br.com.ddd.domain.exception.DomainException;

import java.util.Objects;

public class AddressVO implements IValueObject {

    private final String street;
    private final String city;
    private final String state;
    private final String zipCode;


    public AddressVO(final String street, final String city, final String state, final String zipCode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.validate();
    }

    public void validate() {
        if (Objects.isNull(this.street) || this.street.isBlank())
            throw new DomainException("Street is required");
        if (Objects.isNull(this.city) || this.city.isBlank())
            throw new DomainException("City is required");
        if (Objects.isNull(this.state) || this.state.isBlank())
            throw new DomainException("State is required");
        if (Objects.isNull(this.zipCode) || this.zipCode.isBlank())
            throw new DomainException("ZipCode is required");
    }

    @Override
    public String toString() {
        return String.join(this.street, this.city, this.state, this.zipCode);
    }
}
