package br.com.ddd.application.customer.usecase;

import br.com.ddd.application.customer.output.ListCustomerOutput;
import br.com.ddd.application.shared.usecase.IUseCaseWithoutParam;
import br.com.ddd.application.shared.usecase.factory.IFactoryToOutput;
import br.com.ddd.domain.customer.entity.Customer;
import br.com.ddd.domain.customer.service.CustomerService;

import java.util.List;

public class ListCustomerUsecase implements IUseCaseWithoutParam<List<ListCustomerOutput>> {

    private final CustomerService customerService;
    private final IFactoryToOutput<List<Customer>, List<ListCustomerOutput>> factory;

    public ListCustomerUsecase(
            final CustomerService customerService,
            final IFactoryToOutput<List<Customer>,
                    List<ListCustomerOutput>> factory) {
        this.customerService = customerService;
        this.factory = factory;
    }

    @Override
    public List<ListCustomerOutput> execute() {

        final var customers = this.customerService.findAll();

        return this.factory.convert(customers);
    }
}
