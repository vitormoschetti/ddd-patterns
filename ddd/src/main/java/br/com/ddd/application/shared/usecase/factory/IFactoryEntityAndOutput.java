package br.com.ddd.application.shared.usecase.factory;

import br.com.ddd.application.shared.input.IInput;
import br.com.ddd.application.shared.output.IOutput;
import br.com.ddd.domain.shared.entity.IAggregateRoot;

public interface IFactoryEntityAndOutput
        <Entity extends IAggregateRoot,
                Input extends IInput,
                Output extends IOutput>
        extends IFactoryToEntity<Input, Entity>,
        IFactoryToOutput<Entity, Output> {
}
