package com._1n5aN1aC.tacotek.network;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

import com._1n5aN1aC.tacotek.common.ModInfo;

public class ModNetwork {
	public static SimpleNetworkWrapper net;
	public static int messages = 0;

	public static void init() {
		net = NetworkRegistry.INSTANCE.newSimpleChannel(ModInfo.MOD_CHANNEL);

		//registerMessage(SyncPropertiesPacket.class, SyncPropertiesPacket.Message.class);
		registerMessage(GUIPacket.class, GUIPacket.GUImessage.class);
	}

	public static void registerClientSide(Class handler, Class message)
	{
		net.registerMessage(handler, message, messages, Side.CLIENT);
		messages++;
	}

	private static void registerMessage(Class handler, Class message)
	{
		net.registerMessage(handler, message, messages, Side.CLIENT);
		net.registerMessage(handler, message, messages, Side.SERVER);
		messages++;
	}

	public static void sendToDimension(IMessage message, EntityPlayer player)
	{
		net.sendToDimension(message, player.dimension);
	}
}