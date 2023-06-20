package br.com.ddd.core.domain.events.shared;

import br.com.ddd.core.domain.events.IEvent;

public interface IEventHandler<T> {

    void handle(IEvent<T> event);

}
