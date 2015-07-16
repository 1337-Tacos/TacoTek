package com._1n5aN1aC.tacotek.items;

import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

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
	private String description = "";
	
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
	
	public GenericItem(String name, String description) {
		this(name);
		this.description = description;
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
	
	public GenericItem(String name, String description, int stackLimit) {
		this(name, stackLimit);
		this.description = description;
	}
	
	/**
	 * @return the itemName of the item
	 */
	public String getName() {
		return name;
	}
	
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer player, List dataList, boolean bool) {
		//Only add the description if we actually gave it a description.
		if (!this.description.equals("")) {
			dataList.add(description);
		}
	}
}