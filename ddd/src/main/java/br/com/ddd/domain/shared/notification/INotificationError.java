package br.com.ddd.domain.shared.notification;

public interface INotificationError {

    String message();

    String context();

    String action();

    String location();

}
