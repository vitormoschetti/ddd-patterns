package br.com.ddd.application.customer.input;

import br.com.ddd.application.shared.input.IInput;

public record UpdateCustomerInput(String id, String name, UpdateCustomerAddressInput address) implements IInput {

    @Override
    public Boolean isValid() {
        return Boolean.TRUE;
    }
}
