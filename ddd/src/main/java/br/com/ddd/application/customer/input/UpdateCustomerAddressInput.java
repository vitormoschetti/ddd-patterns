package br.com.ddd.application.customer.input;

import br.com.ddd.application.shared.input.IInput;


public record UpdateCustomerAddressInput(String street, String state, String city, String zipCode) implements IInput {

    @Override
    public Boolean isValid() {
        return Boolean.TRUE;
    }
}

