package br.com.ddd.application.customer.usecase.factory;

import br.com.ddd.application.customer.output.UpdateCustomerAddressOutput;
import br.com.ddd.application.customer.output.UpdateCustomerOutput;
import br.com.ddd.application.shared.usecase.factory.IFactoryToOutput;
import br.com.ddd.domain.customer.entity.Customer;

public class UpdateCustomerFactory implements IFactoryToOutput<Customer, UpdateCustomerOutput> {

    @Override
    public UpdateCustomerOutput convert(final Customer input) {
        return new UpdateCustomerOutput(input.getName(), new UpdateCustomerAddressOutput(input.getAddress().street(), input.getAddress().city(),
                input.getAddress().state(), input.getAddress().zipCode()));
    }
}
