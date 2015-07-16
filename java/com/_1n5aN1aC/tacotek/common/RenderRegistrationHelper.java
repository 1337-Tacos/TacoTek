package com._1n5aN1aC.tacotek.common;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

import com._1n5aN1aC.tacotek.blocks.BlocksHelper;
import com._1n5aN1aC.tacotek.blocks.GenericBlock;
import com._1n5aN1aC.tacotek.items.GenericFood;
import com._1n5aN1aC.tacotek.items.GenericItem;
import com._1n5aN1aC.tacotek.items.ItemsHelper;
import com._1n5aN1aC.tacotek.proxy.CommonProxy;

public final class RenderRegistrationHelper {
	
	public static void registerItemRenderer(CommonProxy proxy) {
		regItem(proxy, ItemsHelper.salt);
		regFood(proxy, ItemsHelper.taco);
	}
	
	public static void registerBlockRenderer(CommonProxy proxy) {
		regBlock(proxy, BlocksHelper.tacoBox);
	}
	
	/**
	 * Registers the Texture and for a GenericItem
	 * @param proxy the commonProxy object that will be referenced for pretty naming
	 * @param item the GenericItem to apply the texture to. 
	 */
	public static void regItem(CommonProxy proxy, GenericItem item) {
		//Register the Mesh
		//Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, meta, new ModelResourceLocation("modid:itemname", "inventory"));
	    Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(tacotek.MODID + ":" + item.getName(), "inventory"));
	}
	
	/**
	 * Registers the Texture and for a GenericFood
	 * @param proxy the commonProxy object that will be referenced for pretty naming
	 * @param item the GenericItem to apply the texture to. 
	 */
	public static void regFood(CommonProxy proxy, GenericFood item) {
		//Register the Mesh
		//Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, meta, new ModelResourceLocation("modid:itemname", "inventory"));
	    Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(tacotek.MODID + ":" + item.getName(), "inventory"));
	}
	
	/**
	 * Registers the Texture for a GenericBlock
	 * @param proxy the commonProxy object that will be referenced for pretty naming
	 * @param block the GenericBlock to apply the texture to.
	 */
	public static void regBlock(CommonProxy proxy, GenericBlock block) {
		//Register the mesh
		//Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(ModBlocks.tutorialBlock, 0, new ModelResourceLocation("tutorial:tutorial_block", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(tacotek.MODID + ":" + block.getName(), "inventory"));
	}
}