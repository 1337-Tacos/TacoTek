package com._1n5aN1aC.tacotek.network;

import com._1n5aN1aC.tacotek.armor.ModularArmor;
import com._1n5aN1aC.tacotek.common.GuiHandler;
import com._1n5aN1aC.tacotek.common.ModInfo;
import com._1n5aN1aC.tacotek.common.tacotek;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.internal.FMLNetworkHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class GUIPacket implements IMessageHandler<GUIPacket.GUImessage, IMessage> {

	public static final byte FROM_KEYBIND = 0;
	public static final byte FROM_HOLDING = 1;
	public static final byte FROM_TILE = 2;

	@Override
	public IMessage onMessage(GUImessage message, MessageContext context) {
		if (context.side.isServer()) {
			EntityPlayerMP player = context.getServerHandler().playerEntity;

			if (player != null) {
				int playerX = (int) player.posX;
				int playerY = (int) player.posY;
				int playerZ = (int) player.posZ;
				World world = player.worldObj;

				if (message.type == ModInfo.GUI_MODULAR_ITEM) {
					if (message.from == FROM_KEYBIND) {
						if (player.getCurrentArmor(1).getItem() instanceof ModularArmor) {
							FMLNetworkHandler.openGui(player, tacotek.instance, GuiHandler.MODULAR_ARMOR_WEARING, world, playerX, playerY, playerZ);
							return null;
						}
					}
					if (message.from == FROM_HOLDING) {
						if (player.getCurrentEquippedItem().getItem() instanceof ModularArmor) {
							FMLNetworkHandler.openGui(player, tacotek.instance, GuiHandler.MODULAR_ARMOR_HOLDING, world, playerX, playerY, playerZ);
							return null;
						}
					}
				}
			}

		}
		return null;
	}

	public static class GUImessage implements IMessage {

		private byte type;
		private byte from;

		public GUImessage() {}

		public GUImessage(byte type, byte from) {
			this.type = type;
			this.from = from;
		}

		@Override
		public void fromBytes(ByteBuf buf) {
			this.type = buf.readByte();
			this.from = buf.readByte();
		}

		@Override
		public void toBytes(ByteBuf buf) {
			buf.writeByte(type);
			buf.writeByte(from);
		}
	}
}