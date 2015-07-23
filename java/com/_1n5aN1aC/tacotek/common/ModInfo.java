package com._1n5aN1aC.tacotek.common;

public class ModInfo {
	//Static Mod Values
	public static final String MOD_NAME = "TacoTek";
	public static final String MOD_VERSION = "0.0.2";
	public static final String MOD_ID = "tacotek";
	public static final String MOD_CHANNEL = "";
	public static final String MOD_CLIENT_PROXY = "com._1n5aN1aC.tacotek.proxy.ClientProxy";
	public static final String MOD_SERVER_PROXY = "com._1n5aN1aC.tacotek.proxy.ServerProxy";
	public static final String GUI_FACTORY_CLASS = "";

	//GUI Numbers
	private static byte modGuiIndex = 0;
	public static final byte GUI_MODULAR_ITEMT1 = modGuiIndex++;
	public static final byte GUI_MODULAR_ITEMT2 = modGuiIndex++;

	//Inventories
	public static final int T1Modular_Size = 4;
	public static final int T2Modular_Size = 9;
	
	//NBT
	public static final String TAG_ITEM_INVENTORY = "SLOTS";
}