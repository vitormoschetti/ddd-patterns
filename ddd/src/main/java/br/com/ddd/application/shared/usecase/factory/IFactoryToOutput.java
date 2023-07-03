package br.com.ddd.application.shared.usecase.factory;

public interface IFactoryToOutput<TIn, TOut> {

    TOut convert(TIn input);

}
