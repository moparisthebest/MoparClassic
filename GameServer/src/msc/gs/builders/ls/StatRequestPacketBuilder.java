package msc.gs.builders.ls;

import msc.config.Config;
import msc.gs.Instance;
import msc.gs.builders.LSPacketBuilder;
import msc.gs.connection.LSPacket;
import msc.gs.model.World;

public class StatRequestPacketBuilder {
	/**
	 * World instance
	 */
	public static final World world = Instance.getWorld();
	/**
	 * Packets uID
	 */
	private long uID;

	public LSPacket getPacket() {
		LSPacketBuilder packet = new LSPacketBuilder();
		packet.setUID(uID);
		packet.addInt(world.countPlayers());
		packet.addInt(world.countNpcs());
		packet.addLong(Config.START_TIME);
		return packet.toPacket();
	}

	/**
	 * Sets the packet to reply to
	 */
	public void setUID(long uID) {
		this.uID = uID;
	}
}