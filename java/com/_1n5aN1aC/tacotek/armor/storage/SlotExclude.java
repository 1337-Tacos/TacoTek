package com._1n5aN1aC.tacotek.armor.storage;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import com._1n5aN1aC.tacotek.armor.module.GenericModule;

/**
 * SlotExclude simply refers to a slot that prevents you from picking up the item
 * if the item is the same as the storage item.  </br>
 * Currently, it does this by denying any modular armor be picked up with the mouse.
 * @author 1n5aN1aC
 */
public class SlotExclude extends Slot {
	
	public SlotExclude(IInventory inventory, int par2, int par3, int par4) {
		super(inventory, par2, par3, par4);
	}

	/**
	 * Only lets you put an item in here if it's not a piece of armor
	 */
	@Override
	public boolean isItemValid(ItemStack stack) {
		return (stack.getItem() instanceof GenericModule);
	}
}