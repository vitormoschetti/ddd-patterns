package br.com.ddd.application.customer.usecase.factory;

import br.com.ddd.application.customer.output.CreateCustomerAddressOutput;
import br.com.ddd.application.customer.output.CreateCustomerOutput;
import br.com.ddd.application.shared.usecase.factory.IFactoryToOutput;
import br.com.ddd.domain.customer.entity.Customer;

public class CreateCustomerFactory implements IFactoryToOutput<Customer, CreateCustomerOutput> {

    @Override
    public CreateCustomerOutput convert(final Customer input) {
        return new CreateCustomerOutput(input.getId(), input.getName(), new CreateCustomerAddressOutput(input.getAddress().street(), input.getAddress().city(),
                input.getAddress().state(), input.getAddress().zipCode()));
    }
}
