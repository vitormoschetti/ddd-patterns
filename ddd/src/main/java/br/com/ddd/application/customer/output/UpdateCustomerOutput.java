package br.com.ddd.application.customer.output;

import br.com.ddd.application.shared.output.IOutput;

public record UpdateCustomerOutput(String id, String name, UpdateCustomerAddressOutput address) implements IOutput {

}
