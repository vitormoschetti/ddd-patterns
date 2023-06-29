package br.com.ddd.application.customer.output;


import br.com.ddd.application.shared.output.IOutput;

public record FindCustomerOutput(String id, String name, FindCustomerAddressOutput address) implements IOutput {

}
