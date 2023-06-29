package br.com.ddd.application.shared.usecase;

import br.com.ddd.application.shared.input.IInput;
import br.com.ddd.application.shared.output.IOutput;

public interface IUseCase<TParam extends IInput, TOut extends IOutput> {

    TOut execute(final TParam param);

}
