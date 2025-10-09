package com.xreatlabs.limbo.command;

import com.xreatlabs.limbo.NexLimboBungee;

import revxrsal.commands.annotation.Command;
import revxrsal.commands.annotation.Default;
import revxrsal.commands.annotation.Dependency;
import revxrsal.commands.bungee.annotation.CommandPermission;
import revxrsal.commands.command.CommandActor;
import revxrsal.commands.exception.SendMessageException;
import ua.nanit.limbo.server.LimboServer;

@Command("limbostart")
public class StartCommand {
    @Dependency
    private NexLimboBungee plugin;

    @Default
    @CommandPermission("limbo.start")
    public void execute(CommandActor actor, LimboServer limboServer) throws Exception {
        if (limboServer.isRunning())
            throw new SendMessageException(plugin.getLimboConfig().getMessages().message("already-running"));
        limboServer.start();
        throw new SendMessageException(plugin.getLimboConfig().getMessages().message("successfully-started"));
    }
}
