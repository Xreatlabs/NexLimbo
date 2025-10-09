package com.bivashy.limbo.command;

import com.bivashy.limbo.NexLimboVelocity;
import com.bivashy.limbo.command.exception.SendComponentException;

import revxrsal.commands.annotation.Command;
import revxrsal.commands.annotation.Default;
import revxrsal.commands.annotation.Dependency;
import revxrsal.commands.command.CommandActor;
import revxrsal.commands.velocity.annotation.CommandPermission;
import ua.nanit.limbo.server.LimboServer;

@Command("limboconn")
public class ConnectionCountCommand {
    @Dependency
    private NexLimboVelocity plugin;

    @Default
    @CommandPermission("limbo.connection")
    public void execute(CommandActor actor, LimboServer limboServer) {
        throw new SendComponentException(plugin.getLimboConfig().getMessages().message("connection-count", "%count%", limboServer.getConnections().getCount()));
    }
}
