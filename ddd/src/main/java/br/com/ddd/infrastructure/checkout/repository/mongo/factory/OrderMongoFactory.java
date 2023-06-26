package br.com.ddd.infrastructure.checkout.repository.mongo.factory;

import br.com.ddd.domain.checkout.entity.Order;
import br.com.ddd.domain.checkout.entity.OrderItem;
import br.com.ddd.infrastructure.checkout.repository.mongo.model.OrderMongoModel;
import br.com.ddd.infrastructure.checkout.repository.shared.IOrderItemModel;
import br.com.ddd.infrastructure.checkout.repository.shared.IOrderModel;
import br.com.ddd.infrastructure.shared.factory.IFactory;

public class OrderMongoFactory implements IFactory<Order, IOrderModel> {

    private final IFactory<OrderItem, IOrderItemModel> factory;

    public OrderMongoFactory(final IFactory<OrderItem, IOrderItemModel> factory) {
        this.factory = factory;
    }


    @Override
    public IOrderModel convert(final Order input) {
        return new OrderMongoModel(input.getId(), input.getCustomerId(),
                input.getItems()
                        .stream()
                        .map(
                                this.factory::convert
                        ).toList());
    }


}
