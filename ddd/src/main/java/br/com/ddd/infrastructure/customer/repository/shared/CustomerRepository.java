package br.com.ddd.infrastructure.customer.repository.shared;

import br.com.ddd.domain.customer.entity.Customer;
import br.com.ddd.domain.customer.repository.ICustomerRepository;
import br.com.ddd.infrastructure.shared.factory.IFactory;
import br.com.ddd.infrastructure.shared.repository.IRepositoryAdapter;

import java.util.List;

public class CustomerRepository implements ICustomerRepository {

    private final IRepositoryAdapter<ICustomerModel> adapter;
    private final IFactory<Customer, ICustomerModel> factory;

    public CustomerRepository(final IRepositoryAdapter<ICustomerModel> adapter,
                              final IFactory<Customer, ICustomerModel> factory) {
        this.adapter = adapter;
        this.factory = factory;
    }

    @Override
    public void create(final Customer entity) {
        this.adapter.create(this.factory.convert(entity));
    }

    @Override
    public void update(final Customer entity) {
        this.adapter.update(this.factory.convert(entity));
    }

    @Override
    public Customer findById(final String id) {
        final var customerModel = this.adapter.findById(id);
        return new Customer(customerModel.getId(), customerModel.getName(),
                customerModel.getStreet(),
                customerModel.getCity(), customerModel.getState(), customerModel.getZipCode(),
                customerModel.getActive(), customerModel.getRewardPoints());
    }

    @Override
    public List<Customer> findAll() {
        return this.adapter.findAll().stream().map(customerModel ->
                new Customer(customerModel.getId(), customerModel.getName(),
                        customerModel.getStreet(),
                        customerModel.getCity(), customerModel.getState(), customerModel.getZipCode(),
                        customerModel.getActive(), customerModel.getRewardPoints())).toList();
    }
}
