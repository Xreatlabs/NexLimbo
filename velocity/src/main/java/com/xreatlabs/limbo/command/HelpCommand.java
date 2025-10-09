package com.xreatlabs.limbo.command;

import com.xreatlabs.limbo.NexLimboVelocity;
import com.xreatlabs.limbo.command.exception.SendComponentException;

import revxrsal.commands.annotation.Command;
import revxrsal.commands.annotation.Default;
import revxrsal.commands.annotation.Dependency;
import revxrsal.commands.command.CommandActor;

@Command("limbohelp")
public class HelpCommand {
    @Dependency
    private NexLimboVelocity plugin;

    @Default
    public void execute(CommandActor actor) {
        throw new SendComponentException(plugin.getLimboConfig().getMessages().message("help"));
    }
}
