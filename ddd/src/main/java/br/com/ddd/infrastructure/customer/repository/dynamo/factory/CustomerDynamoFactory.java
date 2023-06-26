package br.com.ddd.infrastructure.customer.repository.dynamo.factory;

import br.com.ddd.domain.customer.entity.Customer;
import br.com.ddd.infrastructure.customer.repository.shared.ICustomerModel;
import br.com.ddd.infrastructure.customer.repository.dynamo.model.CustomerDynamoModel;
import br.com.ddd.infrastructure.shared.factory.IFactory;

public class CustomerDynamoFactory implements IFactory<Customer, ICustomerModel> {
    @Override
    public ICustomerModel convert(final Customer input) {
        return new CustomerDynamoModel(input.getId(), input.getName(), input.getAddress().street(),
                input.getAddress().city(), input.getAddress().state(), input.getAddress().zipCode(),
                input.getRewardPoints(), input.isActive());
    }
}
