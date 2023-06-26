package br.com.ddd.infrastructure.customer.repository.dynamo.model;

import br.com.ddd.infrastructure.customer.repository.shared.ICustomerModel;

public class CustomerDynamoModel implements ICustomerModel {


    private final String id;
    private final String name;
    private final String street;
    private final String city;
    private final String state;
    private final String zipCode;
    private final Long rewardPoints;
    private final Boolean active;

    public CustomerDynamoModel(final String id,
                               final String name,
                               final String street,
                               final String city,
                               final String state,
                               final String zipCode,
                               final Long rewardPoints,
                               final Boolean active) {
        this.id = id;
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.rewardPoints = rewardPoints;
        this.active = active;
        this.zipCode = zipCode;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getStreet() {
        return this.street;
    }

    @Override
    public String getCity() {
        return this.city;
    }

    @Override
    public String getState() {
        return this.state;
    }

    @Override
    public String getZipCode() {
        return this.zipCode;
    }

    @Override
    public Boolean getActive() {
        return this.active;
    }

    @Override
    public Long getRewardPoints() {
        return this.rewardPoints;
    }
}
