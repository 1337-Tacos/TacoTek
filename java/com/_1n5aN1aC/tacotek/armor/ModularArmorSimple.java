package com._1n5aN1aC.tacotek.armor;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * This class is for modular armor that doesn't have an effect </br>
 * This is used solely for the non-chestplate parts of the modular armor suit.
 * @author 1n5aN1aC
 */
public class ModularArmorSimple extends GenericArmor {

	/**
	 * Creates a new type of Modular Armor
	 * @param name the uniqueid of the ModularArmorMain
	 * @param material the armorMaterial type which this armor is made out of
	 * @param renderIndex 2 for leggings, 1 for others.
	 * @param armorType Stores the armor type: 0 is helmet, 1 is plate, 2 is legs and 3 is boots
	 */
	public ModularArmorSimple(String name, ArmorMaterial material, int renderIndex, int armorType) {
		super(name, material, renderIndex, armorType);
		//An option to allow coloring of armor or somesuch:
		//this.setHasSubtypes(true);
	}

	/**
	 * We override this, because weird issues seem to happen when a user
	 * Equips Modular-armor with a right click.
	 */
	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player) {
		return itemstack;
	}
}