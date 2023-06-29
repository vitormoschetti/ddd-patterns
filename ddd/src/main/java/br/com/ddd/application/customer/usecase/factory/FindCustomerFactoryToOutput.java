package br.com.ddd.application.customer.usecase.factory;

import br.com.ddd.application.customer.output.FindCustomerAddressOutput;
import br.com.ddd.application.customer.output.FindCustomerOutput;
import br.com.ddd.application.shared.usecase.factory.IFactoryToOutput;
import br.com.ddd.domain.customer.entity.Customer;

public class FindCustomerFactoryToOutput implements IFactoryToOutput<Customer, FindCustomerOutput> {

    @Override
    public FindCustomerOutput convert(final Customer input) {

        return new FindCustomerOutput(input.getId(), input.getName(), new FindCustomerAddressOutput(input.getAddress().street(),
                input.getAddress().city(), input.getAddress().state(), input.getAddress().zipCode()));
    }
}
