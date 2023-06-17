package br.com.ddd;

import br.com.ddd.domain.entities.customer.AddressVO;
import br.com.ddd.domain.entities.customer.Customer;
import br.com.ddd.domain.entities.order.Order;
import br.com.ddd.domain.entities.order.OrderItem;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        final var addressVO = new AddressVO(UUID.randomUUID().toString(), UUID.randomUUID().toString(), UUID.randomUUID().toString(), UUID.randomUUID().toString());
        final var customer = new Customer(UUID.randomUUID().toString(), "Vitor", addressVO);


        final var orderItems = List.of(
                new OrderItem(UUID.randomUUID().toString(), UUID.randomUUID().toString(), BigDecimal.TEN, UUID.randomUUID().toString(), 1L),
                new OrderItem(UUID.randomUUID().toString(), UUID.randomUUID().toString(), BigDecimal.TEN, UUID.randomUUID().toString(), 1L),
                new OrderItem(UUID.randomUUID().toString(), UUID.randomUUID().toString(), BigDecimal.TEN, UUID.randomUUID().toString(), 1L),
                new OrderItem(UUID.randomUUID().toString(), UUID.randomUUID().toString(), BigDecimal.TEN, UUID.randomUUID().toString(), 1L),
                new OrderItem(UUID.randomUUID().toString(), UUID.randomUUID().toString(), BigDecimal.TEN, UUID.randomUUID().toString(), 1L));

        final var order = new Order(UUID.randomUUID().toString(), customer.getId(), orderItems);


    }
}