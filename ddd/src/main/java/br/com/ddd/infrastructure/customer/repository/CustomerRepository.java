package br.com.ddd.infrastructure.customer.repository;

import br.com.ddd.domain.customer.entity.Customer;
import br.com.ddd.domain.customer.repository.ICustomerRepository;

import java.util.List;

public class CustomerRepository implements ICustomerRepository {

    @Override
    public void create(final Customer entity) {

    }

    @Override
    public void update(final Customer entity) {

    }

    @Override
    public Customer findById(final String id) {
        return null;
    }

    @Override
    public List<Customer> findAll() {
        return null;
    }
}
