package br.com.ddd.core.domain.events;

import java.time.Instant;
import java.time.LocalDateTime;

public interface IEvent<T> {

    Instant dateTimeOccured();

    T eventData();


}
