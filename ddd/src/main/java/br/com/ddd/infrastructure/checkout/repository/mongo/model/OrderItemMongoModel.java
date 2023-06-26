package br.com.ddd.infrastructure.checkout.repository.mongo.model;

import br.com.ddd.infrastructure.checkout.repository.shared.IOrderItemModel;

import java.math.BigDecimal;

public record OrderItemMongoModel(String id, String name, BigDecimal price, String productId,
                                  Long quantity) implements IOrderItemModel {

}
