package br.com.ddd.application.customer.usecase;

import br.com.ddd.application.customer.input.CreateCustomerInput;
import br.com.ddd.application.customer.output.CreateCustomerOutput;
import br.com.ddd.application.shared.usecase.IUseCase;
import br.com.ddd.application.shared.usecase.factory.IFactoryToOutput;
import br.com.ddd.domain.customer.entity.Customer;
import br.com.ddd.domain.customer.service.CustomerService;

public class CreateCustomerUsecase implements IUseCase<CreateCustomerInput, CreateCustomerOutput> {


    private final CustomerService customerService;
    private final IFactoryToOutput<Customer, CreateCustomerOutput> factory;

    public CreateCustomerUsecase(
            final CustomerService customerService,
            final IFactoryToOutput<Customer, CreateCustomerOutput> factory) {
        this.customerService = customerService;
        this.factory = factory;
    }


    @Override
    public CreateCustomerOutput execute(final CreateCustomerInput input) {

        final var customer = this.customerService.notifyCreated(input.name(), input.address().street(), input.address().city(), input.address().state(), input.address().zipCode());

        return this.factory.convert(customer);

    }
}
