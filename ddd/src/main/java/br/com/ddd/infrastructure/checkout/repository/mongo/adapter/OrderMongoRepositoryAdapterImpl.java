package br.com.ddd.infrastructure.checkout.repository.mongo.adapter;

import br.com.ddd.infrastructure.checkout.repository.mongo.adapter.adaptersMock.OrderMock;
import br.com.ddd.infrastructure.checkout.repository.shared.IOrderModel;
import br.com.ddd.infrastructure.shared.repository.IRepositoryAdapter;

import java.util.List;

public class OrderMongoRepositoryAdapterImpl implements IRepositoryAdapter<IOrderModel> {

    private OrderMock mock;

    @Override
    public void create(final IOrderModel model) {
        this.mock.create(model);
    }

    @Override
    public void update(final IOrderModel model) {
        this.mock.update(model);
    }

    @Override
    public IOrderModel findById(final String id) {
        return this.mock.findById(id);
    }

    @Override
    public List<IOrderModel> findAll() {
        return this.mock.findAll();
    }
}
