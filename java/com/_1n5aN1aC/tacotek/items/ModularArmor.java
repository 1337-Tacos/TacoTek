package com._1n5aN1aC.tacotek.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ModularArmor extends GenericArmor {
	
	public ModularArmor(String name, ArmorMaterial material, int renderIndex, int armorType) {
		super(name, material, renderIndex, armorType);
	}
	
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
		//We only operate on the Modular Chestplate itself
		if (itemStack.getItem() == ItemsHelper.modularChest) {
			//We require the player to be wearing full Modular Armor before we do much of anything.
			//TODO: Allow partial use of modular armor with reduced functionality, depending on pieces worn
			if (player.inventory.armorItemInSlot(3) != null && player.inventory.armorItemInSlot(3).getItem() == ItemsHelper.modularHelm
					&& player.inventory.armorItemInSlot(2) != null && player.inventory.armorItemInSlot(2).getItem() == ItemsHelper.modularChest
					&& player.inventory.armorItemInSlot(1) != null && player.inventory.armorItemInSlot(1).getItem() == ItemsHelper.modularLegs
					&& player.inventory.armorItemInSlot(0) != null && player.inventory.armorItemInSlot(0).getItem() == ItemsHelper.modularBoots) {
					this.effectPlayer(player, Potion.regeneration, 1, 139);
					//TODO:  Check if each refresh of potion generates additional packets, and if so, how much overhead this amounts to
					this.effectPlayer(player, Potion.nightVision, 0, 239);
			}
		}
	}
	
	/**
	 * Applies a specified potion effect to the player for the specified number of seconds, then refreshing it.
	 * For nightvision, it is refreshed at <10 seconds, otherwise, <1 second
	 * @param player the player object to apply the potion to
	 * @param potion the potion effect to apply
	 * @param amplifier the strength to apply said potion at
	 * @param length how long (in ticks) to apply the effect for.
	 */
	private void effectPlayer(EntityPlayer player, Potion potion, int amplifier, int length) {
		int refresh = 25;
	    //If nightvision, then refresh at <10 seconds
		if (potion.id == Potion.nightVision.getId())
			refresh = 220;
	    if (player.getActivePotionEffect(potion) == null || player.getActivePotionEffect(potion).getDuration() <= refresh)
	        player.addPotionEffect(new PotionEffect(potion.id, length, amplifier, true, false));
	}
}