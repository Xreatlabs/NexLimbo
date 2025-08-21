package ua.xreatlabs.limbo.server.commands;

import ua.xreatlabs.limbo.server.Command;
import ua.xreatlabs.limbo.server.LimboServer;
import ua.xreatlabs.limbo.server.Log;

public class CmdConn implements Command {

    private final LimboServer server;

    public CmdConn(LimboServer server) {
        this.server = server;
    }

    @Override
    public void execute() {
        Log.info("Connections: %d", server.getConnections().getCount());
    }

    @Override
    public String description() {
        return "Display connections count";
    }
}
