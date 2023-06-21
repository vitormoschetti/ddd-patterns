package br.com.ddd.domain.customer.service;

import br.com.ddd.domain.customer.valueobject.AddressVO;
import br.com.ddd.domain.customer.entity.Customer;
import br.com.ddd.domain.customer.event.event.CustomerChangedAddressEvent;
import br.com.ddd.domain.customer.event.event.CustomerCreatedEvent;
import br.com.ddd.domain.customer.event.dispatcher.CustomerEventDispatcher;
import br.com.ddd.domain.customer.repository.ICustomerRepository;

public class CustomerService {

    private final CustomerEventDispatcher dispatcher;
    private final ICustomerRepository repository;

    public CustomerService(
            final CustomerEventDispatcher dispatcher,
            final ICustomerRepository repository) {
        this.dispatcher = dispatcher;
        this.repository = repository;
    }

    public Customer notifyCreated(final String id, final String name, final AddressVO addressVO) {

        final var customer = new Customer(id, name, addressVO);

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

}
