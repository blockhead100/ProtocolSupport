package protocolsupport.protocol.pipeline.version.v_1_11;

import protocolsupport.api.utils.NetworkState;
import protocolsupport.protocol.packet.middle.impl.serverbound.IServerboundMiddlePacketV11;
import protocolsupport.protocol.packet.middle.impl.serverbound.handshake.v_7_8_9r1_9r2_10_11_12r1_12r2_13_14r1_14r2_15_16r1_16r2_17r1_17r2_18.SetProtocol;
import protocolsupport.protocol.packet.middle.impl.serverbound.login.v_7_8_9r1_9r2_10_11_12r1_12r2_13_14r1_14r2_15_16r1_16r2_17r1_17r2_18.LoginStart;
import protocolsupport.protocol.packet.middle.impl.serverbound.login.v_8_9r1_9r2_10_11_12r1_12r2_13_14r1_14r2_15_16r1_16r2_17r1_17r2_18.EncryptionResponse;
import protocolsupport.protocol.packet.middle.impl.serverbound.play.v_10_11_12r1_12r2_13_14r1_14r2_15_16r1_16r2_17r1_17r2_18.ResourcePackStatus;
import protocolsupport.protocol.packet.middle.impl.serverbound.play.v_11_12r1_12r2_13.BlockPlace;
import protocolsupport.protocol.packet.middle.impl.serverbound.play.v_4_5_6_7_8_9r1_9r2_10_11_12r1_12r2_13_14r1_14r2_15_16r1_16r2.InventoryClick;
import protocolsupport.protocol.packet.middle.impl.serverbound.play.v_4_5_6_7_8_9r1_9r2_10_11_12r1_12r2_13_14r1_14r2_15_16r1_16r2.InventoryClose;
import protocolsupport.protocol.packet.middle.impl.serverbound.play.v_4_5_6_7_8_9r1_9r2_10_11_12r1_12r2_13_14r1_14r2_15_16r1_16r2.InventoryConfirmTransaction;
import protocolsupport.protocol.packet.middle.impl.serverbound.play.v_4_5_6_7_8_9r1_9r2_10_11_12r1_12r2_13_14r1_14r2_15_16r1_16r2_17r1_17r2_18.CreativeSetSlot;
import protocolsupport.protocol.packet.middle.impl.serverbound.play.v_4_5_6_7_8_9r1_9r2_10_11_12r1_12r2_13_14r1_14r2_15_16r1_16r2_17r1_17r2_18.Ground;
import protocolsupport.protocol.packet.middle.impl.serverbound.play.v_4_5_6_7_8_9r1_9r2_10_11_12r1_12r2_13_14r1_14r2_15_16r1_16r2_17r1_17r2_18.HeldSlot;
import protocolsupport.protocol.packet.middle.impl.serverbound.play.v_4_5_6_7_8_9r1_9r2_10_11_12r1_12r2_13_14r1_14r2_15_16r1_16r2_17r1_17r2_18.InventoryButton;
import protocolsupport.protocol.packet.middle.impl.serverbound.play.v_4_5_6_7_8_9r1_9r2_10_11_12r1_12r2_13_14r1_14r2_15_16r1_16r2_17r1_17r2_18.Look;
import protocolsupport.protocol.packet.middle.impl.serverbound.play.v_6_7_8_9r1_9r2_10_11_12r1_12r2_13_14r1_14r2_15.PlayerAbilities;
import protocolsupport.protocol.packet.middle.impl.serverbound.play.v_7_8_9r1_9r2_10_11_12r1_12r2_13_14r1_14r2_15_16r1_16r2_17r1_17r2_18.Chat;
import protocolsupport.protocol.packet.middle.impl.serverbound.play.v_7_8_9r1_9r2_10_11_12r1_12r2_13_14r1_14r2_15_16r1_16r2_17r1_17r2_18.ClientCommand;
import protocolsupport.protocol.packet.middle.impl.serverbound.play.v_8_9r1_9r2_10_11_12r1_12r2.CustomPayload;
import protocolsupport.protocol.packet.middle.impl.serverbound.play.v_8_9r1_9r2_10_11_12r1_12r2_13.UpdateSign;
import protocolsupport.protocol.packet.middle.impl.serverbound.play.v_8_9r1_9r2_10_11_12r1_12r2_13_14r1_14r2_15_16r1_16r2_17r1_17r2_18.EntityAction;
import protocolsupport.protocol.packet.middle.impl.serverbound.play.v_8_9r1_9r2_10_11_12r1_12r2_13_14r1_14r2_15_16r1_16r2_17r1_17r2_18.KeepAlive;
import protocolsupport.protocol.packet.middle.impl.serverbound.play.v_8_9r1_9r2_10_11_12r1_12r2_13_14r1_14r2_15_16r1_16r2_17r1_17r2_18.Move;
import protocolsupport.protocol.packet.middle.impl.serverbound.play.v_8_9r1_9r2_10_11_12r1_12r2_13_14r1_14r2_15_16r1_16r2_17r1_17r2_18.Spectate;
import protocolsupport.protocol.packet.middle.impl.serverbound.play.v_8_9r1_9r2_10_11_12r1_12r2_13_14r1_14r2_15_16r1_16r2_17r1_17r2_18.SteerVehicle;
import protocolsupport.protocol.packet.middle.impl.serverbound.play.v_9r1_9r2_10_11_12r1_12r2.TabComplete;
import protocolsupport.protocol.packet.middle.impl.serverbound.play.v_9r1_9r2_10_11_12r1_12r2_13.BlockDig;
import protocolsupport.protocol.packet.middle.impl.serverbound.play.v_9r1_9r2_10_11_12r1_12r2_13_14r1_14r2_15.UseEntity;
import protocolsupport.protocol.packet.middle.impl.serverbound.play.v_9r1_9r2_10_11_12r1_12r2_13_14r1_14r2_15_16r1_16r2.ClientSettings;
import protocolsupport.protocol.packet.middle.impl.serverbound.play.v_9r1_9r2_10_11_12r1_12r2_13_14r1_14r2_15_16r1_16r2_17r1_17r2_18.Animation;
import protocolsupport.protocol.packet.middle.impl.serverbound.play.v_9r1_9r2_10_11_12r1_12r2_13_14r1_14r2_15_16r1_16r2_17r1_17r2_18.MoveLook;
import protocolsupport.protocol.packet.middle.impl.serverbound.play.v_9r1_9r2_10_11_12r1_12r2_13_14r1_14r2_15_16r1_16r2_17r1_17r2_18.MoveVehicle;
import protocolsupport.protocol.packet.middle.impl.serverbound.play.v_9r1_9r2_10_11_12r1_12r2_13_14r1_14r2_15_16r1_16r2_17r1_17r2_18.SteerBoat;
import protocolsupport.protocol.packet.middle.impl.serverbound.play.v_9r1_9r2_10_11_12r1_12r2_13_14r1_14r2_15_16r1_16r2_17r1_17r2_18.TeleportAccept;
import protocolsupport.protocol.packet.middle.impl.serverbound.play.v_9r1_9r2_10_11_12r1_12r2_13_14r1_14r2_15_16r1_16r2_17r1_17r2_18.UseItem;
import protocolsupport.protocol.packet.middle.impl.serverbound.status.v_7_8_9r1_9r2_10_11_12r1_12r2_13_14r1_14r2_15_16r1_16r2_17r1_17r2_18.Ping;
import protocolsupport.protocol.packet.middle.impl.serverbound.status.v_7_8_9r1_9r2_10_11_12r1_12r2_13_14r1_14r2_15_16r1_16r2_17r1_17r2_18.ServerInfoRequest;
import protocolsupport.protocol.pipeline.IPacketDataChannelIO;
import protocolsupport.protocol.pipeline.version.util.decoder.AbstractModernPacketDecoder;
import protocolsupport.protocol.storage.netcache.NetworkDataCache;

public class PacketDecoder extends AbstractModernPacketDecoder<IServerboundMiddlePacketV11> {

	public PacketDecoder(IPacketDataChannelIO io, NetworkDataCache cache) {
		super(io, cache);
		registry.register(NetworkState.HANDSHAKING, 0x00, SetProtocol::new);
		registry.register(NetworkState.LOGIN, 0x00, LoginStart::new);
		registry.register(NetworkState.LOGIN, 0x01, EncryptionResponse::new);
		registry.register(NetworkState.STATUS, 0x00, ServerInfoRequest::new);
		registry.register(NetworkState.STATUS, 0x01, Ping::new);
		registry.register(NetworkState.PLAY, 0x00, TeleportAccept::new);
		registry.register(NetworkState.PLAY, 0x01, TabComplete::new);
		registry.register(NetworkState.PLAY, 0x02, Chat::new);
		registry.register(NetworkState.PLAY, 0x03, ClientCommand::new);
		registry.register(NetworkState.PLAY, 0x04, ClientSettings::new);
		registry.register(NetworkState.PLAY, 0x05, InventoryConfirmTransaction::new);
		registry.register(NetworkState.PLAY, 0x06, InventoryButton::new);
		registry.register(NetworkState.PLAY, 0x07, InventoryClick::new);
		registry.register(NetworkState.PLAY, 0x08, InventoryClose::new);
		registry.register(NetworkState.PLAY, 0x09, CustomPayload::new);
		registry.register(NetworkState.PLAY, 0x0A, UseEntity::new);
		registry.register(NetworkState.PLAY, 0x0B, KeepAlive::new);
		registry.register(NetworkState.PLAY, 0x0C, Move::new);
		registry.register(NetworkState.PLAY, 0x0D, MoveLook::new);
		registry.register(NetworkState.PLAY, 0x0E, Look::new);
		registry.register(NetworkState.PLAY, 0x0F, Ground::new);
		registry.register(NetworkState.PLAY, 0x10, MoveVehicle::new);
		registry.register(NetworkState.PLAY, 0x11, SteerBoat::new);
		registry.register(NetworkState.PLAY, 0x12, PlayerAbilities::new);
		registry.register(NetworkState.PLAY, 0x13, BlockDig::new);
		registry.register(NetworkState.PLAY, 0x14, EntityAction::new);
		registry.register(NetworkState.PLAY, 0x15, SteerVehicle::new);
		registry.register(NetworkState.PLAY, 0x16, ResourcePackStatus::new);
		registry.register(NetworkState.PLAY, 0x17, HeldSlot::new);
		registry.register(NetworkState.PLAY, 0x18, CreativeSetSlot::new);
		registry.register(NetworkState.PLAY, 0x19, UpdateSign::new);
		registry.register(NetworkState.PLAY, 0x1A, Animation::new);
		registry.register(NetworkState.PLAY, 0x1B, Spectate::new);
		registry.register(NetworkState.PLAY, 0x1C, BlockPlace::new);
		registry.register(NetworkState.PLAY, 0x1D, UseItem::new);
	}

}
