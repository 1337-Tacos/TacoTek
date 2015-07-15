package com._1n5aN1aC.tacotek.items;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

import com._1n5aN1aC.tacotek.common.tacotek;
import com._1n5aN1aC.tacotek.proxy.ServerProxy;

import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GenericItem extends Item {

	private final String name;
	
	/**
	 * Constructor:name.
	 * @param name the unique item name of the item
	 * @param prettyName the pretty (English) name of the item
	 */
	public GenericItem(String name) {
		this.name = name;
		
		this.setUnlocalizedName(tacotek.MODID + "_" + name);
		this.setCreativeTab(tacotek.tacotekTab);
	}
	
	/**
	 * Constructor:name, and stack limit.
	 * @param name the unique item name of the item
	 * @param prettyName the pretty (English) name of the item
	 * @param stackLimit the maximum of these items in one stack
	 */
	public GenericItem(String name, int stackLimit) {
		this(name);
		this.maxStackSize = stackLimit;
	}
	
	/**
	 * @return the itemName of the item
	 */
	public String getName() {
		return name;
	}
}