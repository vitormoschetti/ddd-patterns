package br.com.ddd.application.customer.usecase;

import br.com.ddd.application.customer.input.UpdateCustomerInput;
import br.com.ddd.application.customer.output.UpdateCustomerOutput;
import br.com.ddd.application.shared.usecase.IUseCase;
import br.com.ddd.application.shared.usecase.factory.IFactoryToOutput;
import br.com.ddd.domain.customer.entity.Customer;
import br.com.ddd.domain.customer.service.CustomerService;

public class UpdateCustomerUsecase implements IUseCase<UpdateCustomerInput, UpdateCustomerOutput> {


    private final CustomerService customerService;
    private final IFactoryToOutput<Customer, UpdateCustomerOutput> factory;

    public UpdateCustomerUsecase(
            final CustomerService customerService,
            final IFactoryToOutput<Customer, UpdateCustomerOutput> factory) {
        this.customerService = customerService;
        this.factory = factory;
    }


    @Override
    public UpdateCustomerOutput execute(final UpdateCustomerInput input) {

        final var customer = this.customerService.notifyUpdate(input.id(),
                input.name(), input.address().street(),
                input.address().state(), input.address().city(),
                input.address().zipCode());

        return this.factory.convert(customer);

    }
}
