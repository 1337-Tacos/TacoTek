package com._1n5aN1aC.tacotek.armor;

import com._1n5aN1aC.tacotek.common.ModInfo;

public class ModularArmor_T1 extends ModularArmor {

	public ModularArmor_T1(String name, ArmorMaterial material, int renderIndex, int armorType) {
		super(name, material, renderIndex, armorType);
		this.invSize = ModInfo.T1Modular_Size;
	}
}