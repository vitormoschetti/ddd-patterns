package br.com.ddd.application.shared.usecase.factory;

import br.com.ddd.application.shared.output.IOutput;
import br.com.ddd.domain.shared.entity.IAggregateRoot;

public interface IFactoryToOutput<TIn extends IAggregateRoot, TOut extends IOutput> {

    TOut convert(TIn input);

}
