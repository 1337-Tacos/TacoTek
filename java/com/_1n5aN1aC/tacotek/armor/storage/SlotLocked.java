package com._1n5aN1aC.tacotek.armor.storage;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;

/**
 * SlotLocked simply refers to a slot where no-one can pick the item in it up-
 * No matter what.
 * @author 1n5aN1aC
 */
public class SlotLocked extends Slot {
	public SlotLocked(IInventory inv, int par2, int par3, int par4) {
		super(inv, par2, par3, par4);
	}

	/** It's a locked slot- you can't take it no matter what. */
	@Override
	public boolean canTakeStack(EntityPlayer player) {
		return false;
	}
}