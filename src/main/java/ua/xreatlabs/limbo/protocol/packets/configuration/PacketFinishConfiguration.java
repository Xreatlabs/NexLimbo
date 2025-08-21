package ua.xreatlabs.limbo.protocol.packets.configuration;

import ua.xreatlabs.limbo.connection.ClientConnection;
import ua.xreatlabs.limbo.protocol.PacketIn;
import ua.xreatlabs.limbo.protocol.PacketOut;
import ua.xreatlabs.limbo.server.LimboServer;

public class PacketFinishConfiguration implements PacketIn, PacketOut {

    @Override
    public void handle(ClientConnection conn, LimboServer server) {
        server.getPacketHandler().handle(conn, this);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
