package br.com.ddd.domain.services;

import br.com.ddd.domain.entities.customer.Customer;
import br.com.ddd.domain.entities.order.Order;
import br.com.ddd.domain.entities.order.OrderItem;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.UUID;

public class OrderService {

    public static BigDecimal total(final List<OrderItem> items) {

        return items.stream().map(OrderItem::getTotal).reduce(BigDecimal.ZERO, BigDecimal::add);

    }

    public static Order placeOrder(final List<OrderItem> itens, final Customer customer) {

        final var order = new Order(UUID.randomUUID().toString(), customer.getId(), itens);

        final var rewardPoints = order.total().divide(new BigDecimal(2), RoundingMode.HALF_DOWN).longValue();

        customer.addRewardPoints(rewardPoints);

        return order;

    }

}
