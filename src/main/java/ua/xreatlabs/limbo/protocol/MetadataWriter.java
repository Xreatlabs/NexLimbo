package ua.xreatlabs.limbo.protocol;

import ua.xreatlabs.limbo.protocol.registry.Version;

@FunctionalInterface
public interface MetadataWriter {

    void writeData(ByteMessage message, Version version);

}
