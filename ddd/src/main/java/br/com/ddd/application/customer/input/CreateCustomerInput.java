package br.com.ddd.application.customer.input;

import br.com.ddd.application.shared.input.IInput;

public record CreateCustomerInput(String name, CreateCustomerAddressInput address) implements IInput {

    @Override
    public Boolean isValid() {
        return Boolean.TRUE;
    }
}
