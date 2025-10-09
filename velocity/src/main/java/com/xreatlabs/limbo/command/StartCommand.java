package com.xreatlabs.limbo.command;

import com.xreatlabs.limbo.NexLimboVelocity;
import com.xreatlabs.limbo.command.exception.SendComponentException;

import revxrsal.commands.annotation.Command;
import revxrsal.commands.annotation.Default;
import revxrsal.commands.annotation.Dependency;
import revxrsal.commands.command.CommandActor;
import revxrsal.commands.velocity.annotation.CommandPermission;
import ua.nanit.limbo.server.LimboServer;

@Command("limbostart")
public class StartCommand {
    @Dependency
    private NexLimboVelocity plugin;

    @Default
    @CommandPermission("limbo.start")
    public void execute(CommandActor actor, LimboServer limboServer) throws Exception {
        if (limboServer.isRunning())
            throw new SendComponentException(plugin.getLimboConfig().getMessages().message("already-running"));
        limboServer.start();
        throw new SendComponentException(plugin.getLimboConfig().getMessages().message("successfully-started"));
    }
}
