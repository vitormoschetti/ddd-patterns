package br.com.ddd.infrastructure.checkout.repository.shared;

import br.com.ddd.infrastructure.shared.model.IModel;

import java.util.List;

public interface IOrderModel extends IModel {

    String id();

    String customerId();

    List<IOrderItemModel> items();

}
