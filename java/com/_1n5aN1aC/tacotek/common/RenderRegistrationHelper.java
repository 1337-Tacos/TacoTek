package com._1n5aN1aC.tacotek.common;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

import com._1n5aN1aC.tacotek.blocks.BlocksHelper;
import com._1n5aN1aC.tacotek.blocks.GenericBlock;
import com._1n5aN1aC.tacotek.items.GenericFood;
import com._1n5aN1aC.tacotek.items.GenericItem;
import com._1n5aN1aC.tacotek.items.IRenderable;
import com._1n5aN1aC.tacotek.items.ItemsHelper;
import com._1n5aN1aC.tacotek.proxy.CommonProxy;

public final class RenderRegistrationHelper {
	
	public static void registerItemRenderer(CommonProxy proxy) {
		regItem(proxy, ItemsHelper.salt);
		regItem(proxy, ItemsHelper.taco);
	}
	
	public static void registerBlockRenderer(CommonProxy proxy) {
		regItem(proxy, BlocksHelper.tacoBox);
	}
	
	/**
	 * Registers the Texture and for a GenericItem
	 * @param proxy the commonProxy object that will be referenced for pretty naming
	 * @param item the GenericItem to apply the texture to. 
	 */
	public static void regItem(CommonProxy proxy, IRenderable item) {
		//Register the Mesh
		//Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, meta, new ModelResourceLocation("modid:itemname", "inventory"));
	    Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item.getItem(), 0, new ModelResourceLocation(tacotek.MODID + ":" + item.getName(), "inventory"));
	}
}