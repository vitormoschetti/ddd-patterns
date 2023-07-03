package br.com.ddd.domain.shared.notification;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DomainNotification implements INotification {

    private List<INotificationError> errors;

    public DomainNotification() {
        this.errors = new ArrayList<>();
    }

    @Override
    public void addMessage(final INotificationError error) {
        this.errors.add(error);
    }

    @Override
    public List<INotificationError> messages(final String context) {
        return this.errors.stream().filter(errorContext -> Objects.equals(errorContext.context(), context)).toList();
    }

    @Override
    public List<INotificationError> messages() {
        return this.errors;
    }
}
