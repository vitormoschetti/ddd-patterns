package br.com.ddd.infrastructure.checkout.repository.shared;

import br.com.ddd.domain.checkout.entity.Order;
import br.com.ddd.domain.checkout.entity.OrderItem;
import br.com.ddd.domain.checkout.repository.IOrderRepository;
import br.com.ddd.infrastructure.shared.factory.IFactory;
import br.com.ddd.infrastructure.shared.repository.IRepositoryAdapter;

import java.util.List;

public class OrderRepository implements IOrderRepository {

    private final IRepositoryAdapter<IOrderModel> adapter;
    private final IFactory<Order, IOrderModel> factory;

    public OrderRepository(final IRepositoryAdapter<IOrderModel> adapter,
                           final IFactory<Order, IOrderModel> factory) {
        this.adapter = adapter;
        this.factory = factory;
    }

    @Override
    public void create(final Order entity) {
        this.adapter.create(this.factory.convert(entity));
    }

    @Override
    public void update(final Order entity) {
        this.adapter.update(this.factory.convert(entity));
    }

    @Override
    public Order findById(final String id) {
        final var model = this.adapter.findById(id);
        return new Order(model.id(), model.customerId(), model.items().stream().map(m -> new OrderItem(m.id(),
                m.name(), m.price(), m.productId(), m.quantity())).toList());
    }

    @Override
    public List<Order> findAll() {
        return this.adapter.findAll().stream().map(o ->
                new Order(o.id(), o.customerId(), o.items().stream().map(m -> new OrderItem(m.id(),
                        m.name(), m.price(), m.productId(), m.quantity())).toList())).toList();
    }
}
