package br.com.ddd.infrastructure.customer.repository.shared;

import br.com.ddd.infrastructure.shared.model.IModel;

public interface ICustomerModel extends IModel {

    String getId();

    String getName();

    String getStreet();

    String getCity();

    String getState();

    String getZipCode();

    Boolean getActive();

    Long getRewardPoints();

}
