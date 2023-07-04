package br.com.ddd.domain.shared.notification;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DomainNotification implements INotification {

    private Set<INotificationError> errors;

    public DomainNotification() {
        this.errors = new HashSet<>();
    }

    @Override
    public void addMessage(final INotificationError error) {
        this.errors.add(error);
    }

    @Override
    public Set<INotificationError> messages() {
        return this.errors;
    }
}
