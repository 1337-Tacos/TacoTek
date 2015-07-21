package com._1n5aN1aC.tacotek.armor.gui;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class ModularContainer<I extends ModularInventory> extends Container {

	protected final I inventory;

	public ModularContainer(I inventory, InventoryPlayer playerInv, int xInv, int yInv) {
		this.inventory = inventory;
		addPlayerInventory(playerInv, xInv, yInv);
	}

	@Override
	public ItemStack slotClick(int slotIndex, int button, int modifier, EntityPlayer player) {
		if (!canInteractWith(player)) {
			return null;
		}

		Slot slot = (slotIndex < 0) ? null : (Slot) this.inventorySlots.get(slotIndex);
		//if (slot instanceof customSlot && ((CustomSlot) slot).isPhantom()) {
		//	return SlotHelper.slotClickedPhantom(slot, button, modifier, player);
		//}

		inventory.onSlotClick(player);
		
		return super.slotClick(slotIndex, button, modifier, player);
	}

	@Override
	public final ItemStack transferStackInSlot(EntityPlayer player, int index) {
		if (!canInteractWith(player)) {
			return null;
		}
		return transferStackInSlot(inventorySlots, player, index);
	}

	@Override
	public final boolean canInteractWith(EntityPlayer entityplayer) {
		return inventory.isUseableByPlayer(entityplayer);
	}

	@SuppressWarnings("unused")
	public final ItemStack transferStackInSlot(List slots, EntityPlayer player, int index) {
		Slot slot = (Slot) inventorySlots.get(index);
		if (slot == null || !slot.getHasStack()) {
			return null;
		}

		int numSlots = inventorySlots.size();
		ItemStack stackInSlot = slot.getStack();
		ItemStack originalStack = stackInSlot.copy();

		//if (!shiftItemStack(inventorySlots, stackInSlot, index, numSlots)) {
		if (false) {
			return null;
		}

		slot.onSlotChange(stackInSlot, originalStack);
		if (stackInSlot.stackSize <= 0) {
			slot.putStack(null);
		} else {
			slot.onSlotChanged();
		}

		if (stackInSlot.stackSize == originalStack.stackSize) {
			return null;
		}

		slot.onPickupFromSlot(player, stackInSlot);
		return originalStack;
	}

	private void addPlayerInventory(InventoryPlayer playerInv, int xInv, int yInv) {
		// Player inventory
		for (int row = 0; row < 3; row++) {
			for (int column = 0; column < 9; column++) {
				addSlotToContainer(new Slot(playerInv, column + row * 9 + 9, xInv + column * 18, yInv + row * 18));
			}
		}
		// Player hotbar
		//TODO:  ??!?!?!
		for (int column = 0; column < 9; column++) {
			addSlotToContainer(new Slot(playerInv, column, xInv + column * 18, yInv + 58));
		}
	}
}