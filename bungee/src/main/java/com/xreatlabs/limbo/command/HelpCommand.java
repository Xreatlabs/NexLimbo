package com.xreatlabs.limbo.command;

import com.xreatlabs.limbo.NexLimboBungee;

import revxrsal.commands.annotation.Command;
import revxrsal.commands.annotation.Default;
import revxrsal.commands.annotation.Dependency;
import revxrsal.commands.command.CommandActor;
import revxrsal.commands.exception.SendMessageException;

@Command("limbohelp")
public class HelpCommand {
    @Dependency
    private NexLimboBungee plugin;

    @Default
    public void execute(CommandActor actor) {
        throw new SendMessageException(plugin.getLimboConfig().getMessages().message("help"));
    }
}
