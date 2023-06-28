package br.com.ddd.infrastructure.customer.repository.dynamo.adapter;

import br.com.ddd.infrastructure.customer.repository.dynamo.model.CustomerDynamoModel;
import br.com.ddd.infrastructure.customer.repository.shared.ICustomerModel;
import br.com.ddd.infrastructure.shared.repository.IRepositoryAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class CustomerDynamoRepositoryAdapterImpl implements IRepositoryAdapter<ICustomerModel> {

    private final List<ICustomerModel> models;

    public CustomerDynamoRepositoryAdapterImpl() {
        this.models = new ArrayList<>(this.buildInitProducts());
    }

    public List<ICustomerModel> findAll() {
        return this.models;
    }

    public ICustomerModel findById(final String id) {
        return this.models.stream().filter(m -> m.getId().equalsIgnoreCase(id)).findFirst().orElse(null);
    }

    public void create(ICustomerModel model) {
        this.models.add(model);
    }

    public void update(final ICustomerModel model) {
        final var result = this.findById(model.getId());
        if (Objects.isNull(result))
            throw new RuntimeException("Product not found");
        this.models.remove(model);
        this.create(model);

    }

    private List<ICustomerModel> buildInitProducts() {
        return List.of(
                this.buildProductModel(),
                this.buildProductModel(),
                this.buildProductModel(),
                this.buildProductModel(),
                this.buildProductModel()
        );
    }

    private ICustomerModel buildProductModel() {
        return new CustomerDynamoModel(
                UUID.randomUUID().toString(),
                UUID.randomUUID().toString(),
                UUID.randomUUID().toString(),
                UUID.randomUUID().toString(),
                UUID.randomUUID().toString(),
                UUID.randomUUID().toString(),
                1L,
                Boolean.TRUE
        );
    }

}
