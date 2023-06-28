package br.com.ddd.infrastructure.checkout.repository.mongo.adapter;

import br.com.ddd.infrastructure.checkout.repository.mongo.model.OrderItemMongoModel;
import br.com.ddd.infrastructure.checkout.repository.mongo.model.OrderMongoModel;
import br.com.ddd.infrastructure.checkout.repository.shared.IOrderItemModel;
import br.com.ddd.infrastructure.checkout.repository.shared.IOrderModel;
import br.com.ddd.infrastructure.shared.repository.IRepositoryAdapter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class OrderMongoRepositoryAdapterImpl implements IRepositoryAdapter<IOrderModel> {

    private final List<IOrderModel> models;

    public OrderMongoRepositoryAdapterImpl() {
        this.models = new ArrayList<>(this.buildInitOrders());
    }

    public List<IOrderModel> findAll() {
        return this.models;
    }

    public IOrderModel findById(final String id) {
        return this.models.stream().filter(m -> m.id().equalsIgnoreCase(id)).findFirst().orElse(null);
    }

    public void create(IOrderModel model) {
        this.models.add(model);
    }

    public void update(final IOrderModel model) {
        final var result = this.findById(model.id());
        if (Objects.isNull(result))
            throw new RuntimeException("Product not found");
        this.models.remove(model);
        this.create(model);

    }

    private List<IOrderModel> buildInitOrders() {
        return List.of(
                this.buildOrderModel(),
                this.buildOrderModel(),
                this.buildOrderModel(),
                this.buildOrderModel(),
                this.buildOrderModel()
        );
    }

    private IOrderModel buildOrderModel() {
        return new OrderMongoModel(
                UUID.randomUUID().toString(),
                UUID.randomUUID().toString(),
                List.of(
                        this.buildInitOrdersItems(),
                        this.buildInitOrdersItems(),
                        this.buildInitOrdersItems(),
                        this.buildInitOrdersItems()
                )
        );
    }

    private IOrderItemModel buildInitOrdersItems() {

        return new OrderItemMongoModel(
                UUID.randomUUID().toString(),
                UUID.randomUUID().toString(),
                BigDecimal.ONE,
                UUID.randomUUID().toString(),
                12L
        );
    }
}
