package ua.xreatlabs.limbo.server;

public interface Command {

    void execute();

    String description();

}
