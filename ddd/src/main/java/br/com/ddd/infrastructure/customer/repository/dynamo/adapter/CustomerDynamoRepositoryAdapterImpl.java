package br.com.ddd.infrastructure.customer.repository.dynamo.adapter;

import br.com.ddd.infrastructure.customer.repository.shared.ICustomerModel;
import br.com.ddd.infrastructure.customer.repository.dynamo.adapter.adaptersMock.CustomerMock;
import br.com.ddd.infrastructure.shared.repository.IRepositoryAdapter;

import java.util.List;

public class CustomerDynamoRepositoryAdapterImpl implements IRepositoryAdapter<ICustomerModel> {

    private CustomerMock mock;

    @Override
    public void create(final ICustomerModel model) {
        this.mock.create(model);
    }

    @Override
    public void update(final ICustomerModel model) {
        this.mock.update(model);
    }

    @Override
    public ICustomerModel findById(final String id) {
        return this.mock.findById(id);
    }

    @Override
    public List<ICustomerModel> findAll() {
        return this.mock.findAll();
    }
}
