package br.com.ddd.domain.shared.event;

import java.time.Instant;

public interface IEvent<T> {

    String traceId();
    Instant instantCreated();

    T payload();


}
