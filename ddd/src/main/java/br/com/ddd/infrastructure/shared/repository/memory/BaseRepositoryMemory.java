package br.com.ddd.infrastructure.shared.repository.memory;

public class BaseRepositoryMemory<T extends IAdapter> {

    protected final T mock;

    public BaseRepositoryMemory(final T mock) {
        this.mock = mock;
    }
}
