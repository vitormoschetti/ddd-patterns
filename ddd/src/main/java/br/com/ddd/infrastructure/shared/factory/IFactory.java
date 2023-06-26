package br.com.ddd.infrastructure.shared.factory;

import br.com.ddd.infrastructure.shared.model.IModel;

public interface IFactory<TIn, TOut extends IModel> {

    TOut convert(TIn input);

}
