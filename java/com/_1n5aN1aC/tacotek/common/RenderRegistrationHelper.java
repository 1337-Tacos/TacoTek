package com._1n5aN1aC.tacotek.common;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;

import com._1n5aN1aC.tacotek.blocks.BlocksHelper;
import com._1n5aN1aC.tacotek.items.IRenderable;
import com._1n5aN1aC.tacotek.items.ItemsHelper;

public final class RenderRegistrationHelper {
	
	public static void registerItemRenderer() {
		//Items
		regItem(ItemsHelper.salt);
		
		//Food
		regItem(ItemsHelper.taco);

		//Tux Armor
		regItem(ItemsHelper.tuxHelm);
		regItem(ItemsHelper.tuxChest);
		regItem(ItemsHelper.tuxLegs);
		regItem(ItemsHelper.tuxBoots);
		
		//Modular Armor #1
		regItem(ItemsHelper.modularHelm);
		regItem(ItemsHelper.modularChest);
		regItem(ItemsHelper.modularLegs);
		regItem(ItemsHelper.modularBoots);
	}
	
	public static void registerBlockRenderer() {
		//Blocks
		regItem(BlocksHelper.tacoBox);
	}
	
	/**
	 * Registers the Texture and for any item that implements an IRenderable
	 * @param item the IRenderable to apply the texture to. 
	 */
	public static void regItem(IRenderable item) {
		//Register the Mesh
		//Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, meta, new ModelResourceLocation("modid:itemname", "inventory"));
	    Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item.getItem(), 0, new ModelResourceLocation(tacotek.MODID + ":" + item.getName(), "inventory"));
	}
}