package br.com.ddd.domain.customer.entity;

import br.com.ddd.domain.customer.valueobject.AddressVO;
import br.com.ddd.domain.shared.entity.IAggregateRoot;
import br.com.ddd.domain.shared.entity.exception.DomainException;

import java.util.Objects;

public class Customer implements IAggregateRoot {

    private final String id;
    private String name;
    private AddressVO address;
    private Boolean active;
    private Long rewardPoints;

    public Customer(final String id, final String name, final AddressVO address) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.rewardPoints = 0L;
        this.validate();
        this.activate();
    }

    public Customer(final String id, final String name, final AddressVO address, final Boolean active, final Long rewardPoints) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.active = active;
        this.rewardPoints = rewardPoints;
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

    public void addRewardPoints(final Long points) {
        if (points < 0)
            throw new DomainException("Reward Points must be greater equal zero");

        this.rewardPoints += points;
    }

    public Boolean isActive() {
        return this.active;
    }

    public String getId() {
        return this.id;
    }


    public Long getRewardPoints() {
        return rewardPoints;
    }

    public String getName() {
        return this.name;
    }

    public AddressVO getAddress() {
        return this.address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", active=" + active +
                ", rewardPoints=" + rewardPoints +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof final Customer customer)) return false;
        return getId().equals(customer.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    public void changeAddress(final AddressVO address) {
        this.address = address;
        this.validate();
    }
}
