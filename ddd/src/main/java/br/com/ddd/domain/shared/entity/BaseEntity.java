package br.com.ddd.domain.shared.entity;

import br.com.ddd.domain.shared.notification.INotification;
import br.com.ddd.domain.shared.notification.INotificationError;

import java.util.List;
import java.util.Set;

public abstract class BaseEntity {

    private final INotification notification;

    protected BaseEntity(final INotification notification) {
        this.notification = notification;
    }

    public Boolean hasErrors() {
        return this.notification.messages().size() > 0;
    }

    public Set<INotificationError> getMessages() {
        return this.notification.messages();
    }

    public void addMessage(final INotificationError error) {
        this.notification.addMessage(error);
    }

}
