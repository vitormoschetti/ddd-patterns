package br.com.ddd.application.customer.output;

import br.com.ddd.application.shared.output.IOutput;


public record ListCustomerOutput(String id, String name, ListCustomerAddressOutput address) implements IOutput {

}