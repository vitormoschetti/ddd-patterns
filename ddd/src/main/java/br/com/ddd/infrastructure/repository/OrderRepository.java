package br.com.ddd.infrastructure.repository;

import br.com.ddd.domain.entity.order.Order;
import br.com.ddd.domain.repository.IOrderRepository;

import java.util.List;

public class OrderRepository implements IOrderRepository {

    @Override
    public void create(final Order entity) {

    }

    @Override
    public void update(final Order entity) {

    }

    @Override
    public Order findById(final String id) {
        return null;
    }

    @Override
    public List<Order> findAll() {
        return null;
    }
}
