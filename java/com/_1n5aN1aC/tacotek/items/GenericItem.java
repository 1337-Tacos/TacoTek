package com._1n5aN1aC.tacotek.items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com._1n5aN1aC.tacotek.common.ModInfo;
import com._1n5aN1aC.tacotek.common.tacotek;

public class GenericItem extends Item implements IRenderable {

	private final String name;
	private String description = null;

	/**
	 * Constructor:name.
	 * @param name the unique item name of the item
	 */
	public GenericItem(String name) {
		this.name = name;

		this.setUnlocalizedName(ModInfo.MOD_ID + "_" + name);
		this.setCreativeTab(tacotek.tacotekTab);
	}

	public GenericItem(String name, String description) {
		this(name);
		this.description = description;
	}

	/**
	 * Constructor:name, and stack limit.
	 * @param name the unique item name of the item
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

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer player, List dataList, boolean bool) {
		//Only add the description if we actually gave it a description.
		if (this.description != null) {
			dataList.add(description);
		}
	}

	/**
	 * @return the itemName of the item
	 */
	@Override
	public String getName() {
		return name;
	}

	@Override
	public Item getItem() {
		return this;
	}
}