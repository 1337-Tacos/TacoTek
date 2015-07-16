package com._1n5aN1aC.tacotek.items;

import net.minecraft.item.ItemFood;

import com._1n5aN1aC.tacotek.common.tacotek;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GenericFood extends ItemFood {
	
	private final String name;

	/**
	 * @param id The ID which to assign to the GenericFood
	 * @param name The UnlocalizedName which to give the Genericfood
	 * @param heal The amount it should heal when eaten.
	 * @param wolfFood Can it be fed to pet wolves?
	 */
	public GenericFood(String name, int heal, boolean wolfFood) {
		super(heal, wolfFood);
		this.name = name;
		this.setCreativeTab(tacotek.tacotekTab);
	}

	/**
	 * @param id The ID which to assign to the GenericFood
	 * @param name The UnlocalizedName which to give the Genericfood
	 * @param heal The amount it should heal when eaten.
	 * @param wolfFood Can it be fed to pet wolves?
	 * @param desc The Tool-tip Description to give the item.
	 */
	public GenericFood(int id, String name, int heal, boolean wolfFood, int potID, int duration, int effectLvl, float chance) {
		this(name, heal, wolfFood);
		this.setPotionEffect(potID, duration, effectLvl, chance);
	}

	/**
	 * @return the itemName of the taco
	 */
	public String getName() {
		return name;
	}
}