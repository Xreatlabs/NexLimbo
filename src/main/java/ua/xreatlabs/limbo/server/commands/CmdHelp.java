package ua.xreatlabs.limbo.server.commands;

import ua.xreatlabs.limbo.server.Command;
import ua.xreatlabs.limbo.server.LimboServer;
import ua.xreatlabs.limbo.server.Log;

import java.util.Map;

public class CmdHelp implements Command {

    private final LimboServer server;

    public CmdHelp(LimboServer server) {
        this.server = server;
    }

    @Override
    public void execute() {
        Map<String, Command> commands = server.getCommandManager().getCommands();

        Log.info("Available commands:");

        for (Map.Entry<String, Command> entry : commands.entrySet()) {
            Log.info("%s - %s", entry.getKey(), entry.getValue().description());
        }
    }

    @Override
    public String description() {
        return "Show this message";
    }
}
