package protocolsupport.protocol.typeremapper.chunk;

import io.netty.buffer.ByteBuf;
import protocolsupport.protocol.serializer.ArraySerializer;
import protocolsupport.protocol.typeremapper.utils.RemappingTable.ArrayBasedIdRemappingTable;

public class ChunkTransformerVaries extends ChunkTransformerBB {

	public ChunkTransformerVaries(ArrayBasedIdRemappingTable blockRemappingTable) {
		super(blockRemappingTable);
	}

	protected static final int globalPaletteBitsPerBlock = 14;

	public void toLegacyData(ByteBuf buffer) {
		for (int i = 0; i < sections.length; i++) {
			ChunkSection section = sections[i];
			if (section != null) {
				BlockStorageReader storage = section.blockdata;
				int bitsPerBlock = storage.getBitsPerBlock();
				if (bitsPerBlock > 8) {
					buffer.writeByte(globalPaletteBitsPerBlock);
					BlockStorageWriter blockstorage = new BlockStorageWriter(globalPaletteBitsPerBlock, blocksInSection);
					for (int blockIndex = 0; blockIndex < blocksInSection; blockIndex++) {
						blockstorage.setBlockState(blockIndex, blockRemappingTable.getRemap(storage.getBlockState(blockIndex)));
					}
					ArraySerializer.writeVarIntLongArray(buffer, blockstorage.getBlockData());
				} else {
					buffer.writeByte(bitsPerBlock);
					BlockPalette palette = new BlockPalette();
					BlockStorageWriter blockstorage = new BlockStorageWriter(bitsPerBlock, blocksInSection);
					for (int blockIndex = 0; blockIndex < blocksInSection; blockIndex++) {
						blockstorage.setBlockState(blockIndex, palette.getRuntimeId(blockRemappingTable.getRemap(storage.getBlockState(blockIndex))));
					}
					ArraySerializer.writeVarIntVarIntArray(buffer, palette.getBlockStates());
					ArraySerializer.writeVarIntLongArray(buffer, blockstorage.getBlockData());
				}
				buffer.writeBytes(section.blocklight);
				if (hasSkyLight) {
					buffer.writeBytes(section.skylight);
				}
			}
		}
		if (hasBiomeData) {
			for (int i = 0; i < biomeData.length; i++) {
				buffer.writeInt(biomeData[i]);
			}
		}
	}

}
