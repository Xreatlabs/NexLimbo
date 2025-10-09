package com.bivashy.limbo;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.bivashy.limbo.config.LimboConfig;
import com.bivashy.limbo.command.LampBungeeCommandHandler;
import com.bivashy.limbo.config.model.BungeeLimboServer;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.plugin.Plugin;
import ua.nanit.limbo.NexLimbo;
import ua.nanit.limbo.server.Command;
import ua.nanit.limbo.server.CommandHandler;
import ua.nanit.limbo.server.LimboServer;

public class NexLimboBungee extends Plugin {
    static {
        NexLimbo.class.getName(); // For preventing minimizing this class
    }

    private static NexLimboBungee instance;
    private final Map<String, LimboServer> servers = new HashMap<>();
    private LimboConfig limboConfig;

    @Override
    public void onEnable() {
        instance = this;
        limboConfig = new LimboConfig(this);
        CommandHandler<Command> commandHandler = new LampBungeeCommandHandler(this).registerAll();
        try {
            for (BungeeLimboServer bungeeLimboServer : limboConfig.getServers()) {
                LimboServer server = new LimboServer(bungeeLimboServer.getLimboConfig(), commandHandler,
                        getClass().getClassLoader());

                ServerInfo serverInfo = ProxyServer.getInstance().constructServerInfo(bungeeLimboServer.getLimboName(), bungeeLimboServer.getLimboConfig()
                        .getAddress(), bungeeLimboServer.getMotd(), bungeeLimboServer.isRestricted());
                servers.put(serverInfo.getName(), server);
                ProxyServer.getInstance()
                        .getServers()
                        .put(serverInfo.getName(),
                                serverInfo);
                ProxyServer.getInstance().getConfig().getServers().put(serverInfo
                        .getName(), serverInfo);

                server.start();
            }
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Map<String, LimboServer> getServers() {
        return Collections.unmodifiableMap(servers);
    }

    public LimboConfig getLimboConfig() {
        return limboConfig;
    }

    public static NexLimboBungee getInstance() {
        return instance;
    }
}
