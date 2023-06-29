package br.com.ddd.application.shared.usecase;

import br.com.ddd.application.shared.output.IOutput;

public interface IUseCaseWithoutParam<TOut extends IOutput> {

    TOut execute();

}
