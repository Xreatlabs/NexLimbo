package ua.xreatlabs.limbo.server.commands;

import ua.xreatlabs.limbo.server.Command;

public class CmdStop implements Command {

    @Override
    public void execute() {
        System.exit(0);
    }

    @Override
    public String description() {
        return "Stop the server";
    }
}
