package br.com.ddd.application.shared.usecase;

public interface IUseCase<TParam, TOut> {

    TOut execute(final TParam param);

}
