package com._1n5aN1aC.tacotek.armor;

import com._1n5aN1aC.tacotek.common.ModInfo;
import com._1n5aN1aC.tacotek.common.tacotek;
import com._1n5aN1aC.tacotek.items.IRenderable;

import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;

public class GenericArmor extends ItemArmor implements IRenderable {

	private final String name;

	public GenericArmor(String name, ArmorMaterial material, int renderIndex, int armorType) {
		super(material, renderIndex, armorType);
		this.name = name;
		this.setUnlocalizedName(ModInfo.MOD_ID + "_" + name);
		this.setCreativeTab(tacotek.tacotekTab);
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