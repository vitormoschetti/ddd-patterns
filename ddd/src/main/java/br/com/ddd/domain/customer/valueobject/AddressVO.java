package br.com.ddd.domain.customer.valueobject;

import br.com.ddd.domain.shared.entity.IValueObject;
import br.com.ddd.domain.shared.entity.exception.DomainException;

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
        return "AddressVO{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof final AddressVO addressVO)) return false;
        return street.equals(addressVO.street) && city.equals(addressVO.city) && state.equals(addressVO.state) && zipCode.equals(addressVO.zipCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, city, state, zipCode);
    }
}
