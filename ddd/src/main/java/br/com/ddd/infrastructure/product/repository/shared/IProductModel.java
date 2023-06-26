package br.com.ddd.infrastructure.product.repository.shared;

import br.com.ddd.infrastructure.shared.model.IModel;

import java.math.BigDecimal;

public interface IProductModel extends IModel {

    String id();

    String name();

    BigDecimal price();

}
