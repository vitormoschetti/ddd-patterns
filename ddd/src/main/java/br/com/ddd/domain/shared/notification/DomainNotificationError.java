package br.com.ddd.domain.shared.notification;

public record DomainNotificationError(String message, String context, String action,
                                      String location) implements INotificationError {

    @Override
    public String toString() {
        return String.format("""
                        Message: %s
                        Context: %s
                        Action: %s
                        Location: %s
                        """,
                this.message, this.context, this.action, this.location);
    }


}
