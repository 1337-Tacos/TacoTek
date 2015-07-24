package com._1n5aN1aC.tacotek.items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com._1n5aN1aC.tacotek.common.ModInfo;
import com._1n5aN1aC.tacotek.common.tacotek;

/**
 * A (Mostly) abstract class, which is used to initialize a basic item. </br>
 * This <b>CAN</b> be used by itself, however, it will create an item that does absolutly nothing.
 * @author 1n5aN1aC
 */
public class GenericItem extends Item implements IRenderable {

	/** The uniqueid of the item */
	private final String name;
	/** The (Tooltip) Description to be used for this Item */
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

	/**
	 * Constructor:name, and description.
	 * @param name the unique item name of the item
	 * @param description the (tooltip) description to apply to this item
	 */
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

	/**
	 * Constructor:name, description, and stack limit.
	 * @param name the unique item name of the item
	 * @param description the (tooltip) description to apply to this item
	 * @param stackLimit the maximum of these items in one stack
	 */
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
	 * getName is part of IRenderable, and is used by RenderRegistrationHelper
	 * to make register the item's texture.
	 * @return the itemName of the item
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * getItem is part of IRenderable, and is used by RenderRegistrationHelper
	 * to make register the item's texture.
	 * @return the base Item to be used for this Object
	 */
	@Override
	public Item getItem() {
		return this;
	}
}