package com.xreatlabs.limbo.command;

import com.xreatlabs.limbo.NexLimboVelocity;
import com.xreatlabs.limbo.command.exception.SendComponentException;

import revxrsal.commands.annotation.Command;
import revxrsal.commands.annotation.Default;
import revxrsal.commands.annotation.Dependency;
import revxrsal.commands.command.CommandActor;
import revxrsal.commands.velocity.annotation.CommandPermission;

@Command({"mem", "memory"})
public class MemoryCommand {
    @Dependency
    private NexLimboVelocity plugin;

    @Default
    @CommandPermission("limbo.memory")
    public void execute(CommandActor actor) {
        Runtime runtime = Runtime.getRuntime();
        long mb = 1024 * 1024;
        long used = (runtime.totalMemory() - runtime.freeMemory()) / mb;
        long total = runtime.totalMemory() / mb;
        long free = runtime.freeMemory() / mb;
        long max = runtime.maxMemory() / mb;

        throw new SendComponentException(
                plugin.getLimboConfig().getMessages().message("memory", "%used%", used, "%total%", total, "%free%", free, "%max%", max));
    }
}
