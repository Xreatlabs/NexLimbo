package ua.xreatlabs.limbo.protocol.packets.play;

import ua.xreatlabs.limbo.protocol.ByteMessage;
import ua.xreatlabs.limbo.protocol.PacketOut;
import ua.xreatlabs.limbo.protocol.registry.Version;

public class PacketGameEvent implements PacketOut {

    private byte type;
    private float value;

    public void setType(byte type) {
        this.type = type;
    }

    public void setValue(float value) {
        this.value = value;
    }

    @Override
    public void encode(ByteMessage msg, Version version) {
        msg.writeByte(type);
        msg.writeFloat(value);
    }
}
