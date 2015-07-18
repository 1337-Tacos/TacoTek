package com._1n5aN1aC.tacotek.armor;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public abstract class ModularArmor extends GenericArmor {

	/** The number of Inventory Slots in this armor */
	public static int invSize;
	/**
	 * Which piece of the armor is this?
	 * 0 = boots
	 * 1 = legs
	 * 2 = chest
	 * 3 = helm
	 */
	public final int armorPiece;

	public ModularArmor(String name, int piece, ArmorMaterial material, int renderIndex, int armorType) {
		super(name, material, renderIndex, armorType);
		this.armorPiece = piece;
	}

	/** @return the number of inventory slots this Tier of ModularArmor has. */
	public int getSize() {
		return this.invSize;
	}

	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
		//We only operate on a Modular Chestplate itself
		if (itemStack.getItem() instanceof ModularArmor) {
			//System.out.println(((ModularArmor)itemStack.getItem()).armorPiece);
		}
		if (itemStack.getItem() instanceof ModularArmor && ((ModularArmor)itemStack.getItem()).armorPiece == 2) {
			//We require the player to be wearing full Modular Armor before we do much of anything.
			//TODO: Allow partial use of modular armor with reduced functionality, depending on pieces worn
			if (player.inventory.armorItemInSlot(3) != null && player.inventory.armorItemInSlot(3).getItem() instanceof ModularArmor
					&& player.inventory.armorItemInSlot(2) != null && player.inventory.armorItemInSlot(2).getItem() instanceof ModularArmor
					&& player.inventory.armorItemInSlot(1) != null && player.inventory.armorItemInSlot(1).getItem() instanceof ModularArmor
					&& player.inventory.armorItemInSlot(0) != null && player.inventory.armorItemInSlot(0).getItem() instanceof ModularArmor) {
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