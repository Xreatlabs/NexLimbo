/*
 * Copyright (C) 2020-2025 XreatLabs
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package ua.xreatlabs.limbo.protocol.packets.login;

import ua.xreatlabs.limbo.protocol.ByteMessage;
import ua.xreatlabs.limbo.protocol.PacketOut;
import ua.xreatlabs.limbo.protocol.registry.Version;

public class PacketDisconnect implements PacketOut {

    private String reason;

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public void encode(ByteMessage msg, Version version) {
        msg.writeString(String.format("{\"text\": \"%s\"}", reason));
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

}
