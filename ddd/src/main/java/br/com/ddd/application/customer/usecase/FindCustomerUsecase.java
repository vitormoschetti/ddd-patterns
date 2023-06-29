package br.com.ddd.application.customer.usecase;

import br.com.ddd.application.customer.input.FindCustomerInput;
import br.com.ddd.application.customer.output.FindCustomerOutput;
import br.com.ddd.application.shared.usecase.IUseCase;
import br.com.ddd.application.shared.usecase.factory.IFactoryToOutput;
import br.com.ddd.domain.customer.entity.Customer;
import br.com.ddd.domain.customer.service.CustomerService;

public class FindCustomerUsecase implements IUseCase<FindCustomerInput, FindCustomerOutput> {

    private final CustomerService customerService;
    private final IFactoryToOutput<Customer, FindCustomerOutput> factory;

    public FindCustomerUsecase(final CustomerService customerService,
                               final IFactoryToOutput<Customer, FindCustomerOutput> factory) {
        this.customerService = customerService;
        this.factory = factory;
    }

    @Override
    public FindCustomerOutput execute(final FindCustomerInput input) {

        final var customer = this.customerService.findById(input.id());

        return this.factory.convert(customer);

    }
}
