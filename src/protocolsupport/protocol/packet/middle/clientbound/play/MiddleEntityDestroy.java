package protocolsupport.protocol.packet.middle.clientbound.play;

import java.util.ArrayList;

import io.netty.buffer.ByteBuf;
import protocolsupport.protocol.codec.ArrayCodec;
import protocolsupport.protocol.packet.middle.CancelMiddlePacketException;
import protocolsupport.protocol.packet.middle.ClientBoundMiddlePacket;
import protocolsupport.protocol.storage.netcache.NetworkEntityCache;
import protocolsupport.protocol.types.networkentity.NetworkEntity;

public abstract class MiddleEntityDestroy extends ClientBoundMiddlePacket {

	protected MiddleEntityDestroy(MiddlePacketInit init) {
		super(init);
	}

	protected final NetworkEntityCache entityCache = cache.getEntityCache();

	protected ArrayList<NetworkEntity> entities;

	@Override
	protected void decode(ByteBuf serverdata) {
		int[] entityIds = ArrayCodec.readVarIntVarIntArray(serverdata);
		entities = entityCache.removeEntities(entityIds);

		if (entities.isEmpty()) {
			throw CancelMiddlePacketException.INSTANCE;
		}
	}

}
