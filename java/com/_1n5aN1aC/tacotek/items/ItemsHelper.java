package com._1n5aN1aC.tacotek.items;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

import com._1n5aN1aC.tacotek.common.tacotek;
import com._1n5aN1aC.tacotek.proxy.CommonProxy;

public final class ItemsHelper {
	//Generic Items
	public static GenericItem salt;
	public static Taco taco;

	public static void setupItems(CommonProxy proxy) {
		//Generic Items
		GameRegistry.registerItem( salt = new GenericItem("salt"), "salt");
		GameRegistry.registerItem( taco = new Taco("taco"), "taco");
	}
}