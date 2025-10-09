package com.xreatlabs.limbo.config;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.spongepowered.configurate.ConfigurateException;
import org.spongepowered.configurate.ConfigurationNode;
import org.spongepowered.configurate.ConfigurationOptions;
import org.spongepowered.configurate.serialize.SerializationException;
import org.spongepowered.configurate.serialize.TypeSerializerCollection;
import org.spongepowered.configurate.yaml.YamlConfigurationLoader;

import com.xreatlabs.limbo.NexLimboVelocity;
import com.xreatlabs.limbo.config.model.VelocityLimboServer;
import com.xreatlabs.limbo.config.model.VelocityLimboServer.VelocityLimboServerSerializer;

import ua.nanit.limbo.server.Log;

public class LimboConfig {

    private List<VelocityLimboServer> servers;
    private MessageConfiguration messages;
    private ConfigurationNode root;

    public LimboConfig(NexLimboVelocity plugin) {
        try {
            root = YamlConfigurationLoader.builder()
                    .defaultOptions(ConfigurationOptions.defaults()
                            .serializers(
                                    TypeSerializerCollection.builder()
                                            .register(VelocityLimboServer.class, new VelocityLimboServerSerializer())
                                            .build()))
                    .file(ConfigurationUtil.saveDefaultConfig(plugin, "config.yml"))
                    .build().
                    load();
            servers = root.node("limbos").childrenMap().values().stream().map(node -> {
                try {
                    return node.get(VelocityLimboServer.class);
                } catch (SerializationException e) {
                    Log.error("Cannot load limbos from configuration", e);
                    return null;
                }
            }).collect(Collectors.toList());
            messages = new MessageConfiguration(root.node("messages"));
        } catch (ConfigurateException e) {
            Log.warning("Cannot load config.yml", e);
        }
    }

    public MessageConfiguration getMessages() {
        return messages;
    }

    public List<VelocityLimboServer> getServers() {
        return Collections.unmodifiableList(servers);
    }

}