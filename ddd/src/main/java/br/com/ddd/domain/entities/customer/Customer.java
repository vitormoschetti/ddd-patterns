package br.com.ddd.domain.entities.customer;

import br.com.ddd.domain.exception.DomainException;

import java.util.Objects;

public class Customer {

    private final String id;
    private String name;
    private final AddressVO address;
    private Boolean active;

    public Customer(final String id, final String name, final AddressVO address) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.validate();
        this.activate();
    }

    private void validate() {
        if (Objects.isNull(this.id) || this.id.isEmpty())
            throw new DomainException("Id is required");
        if (Objects.isNull(this.name) || this.name.isEmpty())
            throw new DomainException("Name is required");
        if (Objects.isNull(this.address))
            throw new DomainException("Address is required");
    }

    public void changeName(final String name) {
        this.name = name;
        this.validate();
    }

    public void activate() {
        this.active = Boolean.TRUE;
    }

    public void deactivate() {
        this.active = Boolean.FALSE;
    }

    public Boolean isActive() {
        return this.active;
    }

    public String getId() {
        return this.id;
    }
}
