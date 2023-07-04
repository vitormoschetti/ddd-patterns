package br.com.ddd.application.customer.usecase.factory;

import br.com.ddd.application.customer.output.ListCustomerAddressOutput;
import br.com.ddd.application.customer.output.ListCustomerOutput;
import br.com.ddd.application.shared.usecase.factory.IFactoryToOutput;
import br.com.ddd.domain.customer.entity.Customer;

import java.util.List;

public class ListCustomerFactoryToOutput implements IFactoryToOutput<List<Customer>, List<ListCustomerOutput>> {

    @Override
    public List<ListCustomerOutput> convert(final List<Customer> input) {
        return input.stream().map(this::convert).toList();
    }

    public ListCustomerOutput convert(final Customer input) {

        return new ListCustomerOutput(input.getId(), input.getName(), new ListCustomerAddressOutput(input.getAddress().getStreet(),
                input.getAddress().getCity(), input.getAddress().getState(), input.getAddress().getZipCode()));
    }
}
