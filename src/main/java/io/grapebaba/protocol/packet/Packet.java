/*
 * Copyright 2015 281165273grape@gmail.com
 *
 * Licensed under the Apache License, version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package io.grapebaba.protocol.packet;

import com.google.common.base.MoreObjects;

import io.grapebaba.protocol.Protocol;

import java.util.Objects;

/**
 * The data packet structure.
 */
public class Packet implements Protocol<PacketHeader, PacketBody> {
  private PacketHeader packetHeader;

  private PacketBody packetBody;

  @Override
  public PacketHeader header() {
    return packetHeader;
  }

  @Override
  public PacketBody body() {
    return packetBody;
  }

  @Override
  public byte getMagicNumber() {
    return 0;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Packet packet = (Packet) obj;
    return Objects.equals(packetHeader, packet.packetHeader)
        && Objects.equals(packetBody, packet.packetBody);
  }

  @Override
  public int hashCode() {
    return Objects.hash(packetHeader, packetBody);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this).add("packetBody", packetBody)
        .add("packetHeader", packetHeader).toString();
  }

  public static class PacketBuilder {
    private Packet packet;

    private PacketBuilder() {
      packet = new Packet();
    }

    public PacketBuilder withPacketHeader(PacketHeader packetHeader) {
      packet.packetHeader = packetHeader;
      return this;
    }

    public PacketBuilder withPacketBody(PacketBody packetBody) {
      packet.packetBody = packetBody;
      return this;
    }

    public static PacketBuilder packet() {
      return new PacketBuilder();
    }

    public Packet build() {
      return packet;
    }
  }
}
