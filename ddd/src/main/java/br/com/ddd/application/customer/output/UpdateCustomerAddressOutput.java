package br.com.ddd.application.customer.output;

import br.com.ddd.application.shared.output.IOutput;


public record UpdateCustomerAddressOutput(String street, String city, String state, String zipCode) implements IOutput {

}

