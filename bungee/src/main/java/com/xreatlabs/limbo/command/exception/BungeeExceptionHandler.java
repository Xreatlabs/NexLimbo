package com.xreatlabs.limbo.command.exception;

import com.xreatlabs.limbo.NexLimboBungee;

import revxrsal.commands.bungee.exception.BungeeExceptionAdapter;
import revxrsal.commands.command.CommandActor;
import revxrsal.commands.exception.MissingArgumentException;
import revxrsal.commands.exception.NoPermissionException;

public class BungeeExceptionHandler extends BungeeExceptionAdapter {
    private final NexLimboBungee plugin;

    public BungeeExceptionHandler(NexLimboBungee plugin) {
        this.plugin = plugin;
    }

    @Override
    public void missingArgument(CommandActor actor, MissingArgumentException exception) {
        actor.reply(plugin.getLimboConfig().getMessages().message("no-argument"));
    }

    @Override
    public void noPermission(CommandActor actor, NoPermissionException exception) {
        super.noPermission(actor, exception);
    }


}
