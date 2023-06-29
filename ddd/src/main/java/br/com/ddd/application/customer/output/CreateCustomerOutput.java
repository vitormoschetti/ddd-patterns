package br.com.ddd.application.customer.output;

import br.com.ddd.application.shared.output.IOutput;

public record CreateCustomerOutput(String id, String name, CreateCustomerAddressOutput address) implements IOutput {

}
