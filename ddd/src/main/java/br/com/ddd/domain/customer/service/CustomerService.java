package br.com.ddd.domain.customer.service;

import br.com.ddd.domain.customer.entity.Customer;
import br.com.ddd.domain.customer.event.dispatcher.CustomerEventDispatcher;
import br.com.ddd.domain.customer.event.event.CustomerChangedAddressEvent;
import br.com.ddd.domain.customer.event.event.CustomerCreatedEvent;
import br.com.ddd.domain.customer.repository.ICustomerRepository;
import br.com.ddd.domain.customer.valueobject.AddressVO;
import br.com.ddd.domain.shared.service.IService;

import java.util.UUID;

public class CustomerService implements IService {

    private final CustomerEventDispatcher dispatcher;
    private final ICustomerRepository repository;

    public CustomerService(
            final CustomerEventDispatcher dispatcher,
            final ICustomerRepository repository) {
        this.dispatcher = dispatcher;
        this.repository = repository;
    }

    public Customer notifyCreated(final String name, final String street, final String city, final String state, final String zipCode) {

        final var customer = new Customer(UUID.randomUUID().toString(), name, street, city, state, zipCode);

        this.repository.create(customer);

        this.dispatcher.notify(new CustomerCreatedEvent(customer));

        return customer;
    }

    public Customer notifyChangeAddress(final Customer customer, final AddressVO address) {

        customer.changeAddress(address);

        this.repository.update(customer);

        this.dispatcher.notify(new CustomerChangedAddressEvent(customer));

        return customer;
    }

    public Customer findById(final String id) {
        return this.repository.findById(id);
    }
}
