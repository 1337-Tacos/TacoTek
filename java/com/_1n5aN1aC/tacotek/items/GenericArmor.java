package com._1n5aN1aC.tacotek.items;

import com._1n5aN1aC.tacotek.common.tacotek;

import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;

public class GenericArmor extends ItemArmor implements IRenderable {
	
	private final String name;
	
	public GenericArmor(String name, ArmorMaterial material, int renderIndex, int armorType) {
		super(material, renderIndex, armorType);
		this.name = name;
		this.setUnlocalizedName(tacotek.MODID + "_" + name);
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