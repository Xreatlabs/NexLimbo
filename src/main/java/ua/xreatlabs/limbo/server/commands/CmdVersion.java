package ua.xreatlabs.limbo.server.commands;

import ua.xreatlabs.limbo.server.Command;
import ua.xreatlabs.limbo.server.Log;
import ua.xreatlabs.limbo.BuildConfig;

public class CmdVersion implements Command {

    @Override
    public void execute() {
        Log.info("Version: %s", BuildConfig.LIMBO_VERSION);
    }

    @Override
    public String description() {
        return "Display limbo version";
    }
}
