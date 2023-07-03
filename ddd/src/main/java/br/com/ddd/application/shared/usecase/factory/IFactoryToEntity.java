package br.com.ddd.application.shared.usecase.factory;

import br.com.ddd.application.shared.input.IInput;
import br.com.ddd.domain.shared.entity.IAggregateRoot;

public interface IFactoryToEntity<TIn extends IInput, TOut extends IAggregateRoot> {

    TOut convert(TIn input);

}
