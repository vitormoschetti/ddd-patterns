package br.com.ddd.infrastructure.checkout.repository.shared;

import br.com.ddd.infrastructure.shared.model.IModel;

import java.math.BigDecimal;

public interface IOrderItemModel extends IModel {

    String id();

    String name();

    BigDecimal price();

    String productId();

    Long quantity();

}
