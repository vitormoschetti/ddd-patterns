package br.com.ddd.domain.shared.notification;

import java.util.List;

public interface INotification {

    void addMessage(INotificationError error);

    List<INotificationError> messages(final String context);

    List<INotificationError> messages();

}
