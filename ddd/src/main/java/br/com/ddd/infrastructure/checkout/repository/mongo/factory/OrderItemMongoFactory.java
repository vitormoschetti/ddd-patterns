package br.com.ddd.infrastructure.checkout.repository.mongo.factory;

import br.com.ddd.domain.checkout.entity.OrderItem;
import br.com.ddd.infrastructure.checkout.repository.mongo.model.OrderItemMongoModel;
import br.com.ddd.infrastructure.shared.factory.IFactory;

public class OrderItemMongoFactory implements IFactory<OrderItem, OrderItemMongoModel> {
    @Override
    public OrderItemMongoModel convert(final OrderItem input) {
        return new OrderItemMongoModel(input.getId(), input.getName(), input.getPrice(),
                input.getProductId(), input.getQuantity());
    }
}
