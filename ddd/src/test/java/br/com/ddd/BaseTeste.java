package br.com.ddd;

import br.com.ddd.domain.entities.customer.AddressVO;
import br.com.ddd.domain.entities.customer.Customer;
import br.com.ddd.domain.entities.order.Order;
import br.com.ddd.domain.entities.order.OrderItem;
import br.com.ddd.domain.entities.product.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BaseTeste {

    protected AddressVO buildValidAddressVO() {
        return new AddressVO("street", "city", "state", "zipcode");
    }

    protected Customer buildCustomerWith(AddressVO addressVO) {
        return new Customer(UUID.randomUUID().toString(), "vitor", addressVO);
    }

    protected Customer buildValidCustomer() {
        return this.buildCustomerWith(this.buildValidAddressVO());
    }

    protected List<OrderItem> buildListOrderItem(final Long quantity) {

        final var orderItems = new ArrayList<OrderItem>();

        for (long i = 0; i < quantity; i++) {
            orderItems.add(this.buildOrderItemWith("product " + i, i+1));
        }

        return orderItems;

    }

    private OrderItem buildOrderItemWith(final String name, final Long quantity) {
        return new OrderItem(UUID.randomUUID().toString(), name, BigDecimal.ONE, UUID.randomUUID().toString(), quantity);
    }

    protected Order buildOrderWithOrderItems(final Long quantity) {

        return new Order(UUID.randomUUID().toString(), UUID.randomUUID().toString(), this.buildListOrderItem(quantity));

    }

    protected Product buildValidProduct() {
        return new Product(UUID.randomUUID().toString(), "product", BigDecimal.ONE);
    }
}