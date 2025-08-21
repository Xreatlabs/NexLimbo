package ua.xreatlabs.limbo.protocol.packets.login;

import ua.xreatlabs.limbo.connection.ClientConnection;
import ua.xreatlabs.limbo.protocol.PacketIn;
import ua.xreatlabs.limbo.protocol.PacketOut;
import ua.xreatlabs.limbo.server.LimboServer;

public class PacketLoginAcknowledged implements PacketIn, PacketOut {

    @Override
    public void handle(ClientConnection conn, LimboServer server) {
        server.getPacketHandler().handle(conn, this);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
