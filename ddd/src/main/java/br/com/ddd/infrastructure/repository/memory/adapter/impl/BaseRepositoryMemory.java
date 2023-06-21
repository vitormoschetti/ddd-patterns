package br.com.ddd.infrastructure.repository.memory.adapter.impl;

import br.com.ddd.infrastructure.shared.repository.memory.IMemoryMock;

public class BaseRepositoryMemory<T extends IMemoryMock> {

    protected final T mock;

    public BaseRepositoryMemory(final T mock) {
        this.mock = mock;
    }
}
