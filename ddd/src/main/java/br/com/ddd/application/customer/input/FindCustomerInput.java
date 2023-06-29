package br.com.ddd.application.customer.input;

import br.com.ddd.application.shared.input.IInput;

import java.util.Objects;

public record FindCustomerInput(String id) implements IInput {

    @Override
    public Boolean isValid() {
        return Objects.nonNull(this.id) && !this.id.isBlank();
    }
}
