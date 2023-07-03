package br.com.ddd;

import br.com.ddd.application.customer.input.CreateCustomerAddressInput;
import br.com.ddd.application.customer.input.CreateCustomerInput;
import br.com.ddd.application.customer.input.UpdateCustomerAddressInput;
import br.com.ddd.application.customer.input.UpdateCustomerInput;
import br.com.ddd.domain.checkout.entity.Order;
import br.com.ddd.domain.checkout.entity.OrderItem;
import br.com.ddd.domain.customer.entity.Customer;
import br.com.ddd.domain.customer.valueobject.AddressVO;
import br.com.ddd.domain.product.entity.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BaseTeste {

    protected AddressVO buildAddressVOWith(final String street, final String city, final String state, final String zipCode) {
        return new AddressVO(street, city, state, zipCode);
    }

    protected Customer buildValidCustomer() {
        return new Customer(UUID.randomUUID().toString(), "name", "street", "city", "state", "zipcode");
    }

    protected List<OrderItem> buildListOrderItem(final Long quantity) {

        final var orderItems = new ArrayList<OrderItem>();

        for (long i = 0; i < quantity; i++) {
            orderItems.add(this.buildOrderItemWith("product " + i, i + 1));
        }

        return orderItems;

    }

    private OrderItem buildOrderItemWith(final String name, final Long quantity) {
        return new OrderItem(UUID.randomUUID().toString(), name, BigDecimal.ONE, UUID.randomUUID().toString(), quantity);
    }

    protected OrderItem buildOrderItemWith(final String name, final Long quantity, final BigDecimal price) {
        return new OrderItem(UUID.randomUUID().toString(), name, price, UUID.randomUUID().toString(), quantity);
    }

    protected Order buildOrderWithOrderItems(final Long quantity) {

        return new Order(UUID.randomUUID().toString(), UUID.randomUUID().toString(), this.buildListOrderItem(quantity));

    }

    protected Product buildValidProduct() {
        return new Product(UUID.randomUUID().toString(), "product", BigDecimal.ONE);
    }

    protected Product buildProductWith(final String name, final BigDecimal price) {
        return new Product(UUID.randomUUID().toString(), name, price);
    }

    protected CreateCustomerInput buildCreateCustomerInput() {
        return new CreateCustomerInput(
                "name",
                new CreateCustomerAddressInput(
                        "street", "state", "city", "zipcode"
                )
        );
    }

    protected UpdateCustomerInput buildUpdateCustomerInput() {
        return new UpdateCustomerInput(
                "1",
                "name",
                new UpdateCustomerAddressInput(
                        "street", "state", "city", "zipcode"
                )
        );
    }


}
