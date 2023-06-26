package br.com.ddd.infrastructure.checkout.repository.mongo.model;

import br.com.ddd.infrastructure.checkout.repository.shared.IOrderItemModel;
import br.com.ddd.infrastructure.checkout.repository.shared.IOrderModel;

import java.util.List;

public record OrderMongoModel(String id, String customerId, List<IOrderItemModel> items) implements IOrderModel {

}
