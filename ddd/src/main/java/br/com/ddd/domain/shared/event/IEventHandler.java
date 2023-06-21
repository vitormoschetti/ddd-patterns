package br.com.ddd.domain.shared.event;

public interface IEventHandler<T> {

    void handle(IEvent<T> event);

}
