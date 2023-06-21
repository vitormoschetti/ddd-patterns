package br.com.ddd.core.domain.events;

import java.time.Instant;

public interface IEvent<T> {

    String traceId();
    Instant instantCreated();

    T payload();


}
