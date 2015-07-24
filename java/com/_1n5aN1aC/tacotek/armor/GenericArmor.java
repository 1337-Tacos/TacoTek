package com._1n5aN1aC.tacotek.armor;

import com._1n5aN1aC.tacotek.common.ModInfo;
import com._1n5aN1aC.tacotek.common.tacotek;
import com._1n5aN1aC.tacotek.items.IRenderable;

import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;

/**
 * A (mostly) abstract class, which is used as the base for all of our armor system. </br>
 * It <b>CAN</b> be used in armor by itself, but will provide no additional functions.
 * @author 1n5aN1aC
 */
public class GenericArmor extends ItemArmor implements IRenderable {

	/** The internal name of the item being initialized */
	private final String name;

	/**
	 * Creates a GenericArmor
	 * @param name the internal name of the item.
	 * @param material the ArmorMaterial of the armor being created
	 * @param renderIndex Used to select the correspondent armor to be rendered on the player: 0 is cloth, 1 is chain, 2 is iron, 3 is diamond and 4 is gold.
	 * @param armorType Stores the armor type: 0 is helmet, 1 is plate, 2 is legs and 3 is boots
	 */
	public GenericArmor(String name, ArmorMaterial material, int renderIndex, int armorType) {
		super(material, renderIndex, armorType);
		this.name = name;
		this.setUnlocalizedName(ModInfo.MOD_ID + "_" + name);
		this.setCreativeTab(tacotek.tacotekTab);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Item getItem() {
		return this;
	}
}