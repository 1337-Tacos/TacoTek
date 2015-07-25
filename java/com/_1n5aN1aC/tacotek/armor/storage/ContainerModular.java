package com._1n5aN1aC.tacotek.armor.storage;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerModular extends Container {

	protected final IInventory inventory;
	private final ItemStack stack;

	public ContainerModular(IInventory inventory, InventoryPlayer playerInv, ItemStack stack) {
		this.inventory = inventory;
		this.stack = stack;
		inventory.openInventory(playerInv.player);

		addPlayerInventory(inventory, playerInv);
	}

	private void addPlayerInventory(IInventory itemInv, InventoryPlayer playerInv) {
		// Container inventory
		int i = -1 * 18;
		for (int row = 0; row < 3; ++row) {
			for (int column = 0; column < 9; ++column) {
				addSlotToContainer(new SlotExclude(itemInv, column + row * 9, 6 + column * 18, 11 + row * 18));
			}
		}

		// Player inventory
		for (int row = 0; row < 3; ++row) {
			for (int column = 0; column < 9; ++column) {
				addSlotToContainer(new Slot(playerInv, column+row*9+9, 8+column*18, 103+row*18+i));
			}
		}

		// Player hotbar
		for (int column = 0; column < 9; ++column) {
			if (playerInv.getStackInSlot(column) != null && playerInv.getStackInSlot(column).getItem() == stack.getItem()) {
				addSlotToContainer(new SlotLocked(playerInv, column, 8+column*18, 161+i));
			} else {
				addSlotToContainer(new Slot(playerInv, column, 8+column*18, 161+i));
			}
		}
	}

	@Override
	public ItemStack slotClick(int slotIndex, int button, int modifier, EntityPlayer player) {
		if (modifier != 2 || player.inventory.currentItem != button) {
			return super.slotClick(slotIndex, button, modifier, player);
		}
		return null;
	}

	@Override
	public final boolean canInteractWith(EntityPlayer entityplayer) {
		return ItemStack.areItemStacksEqual(stack, entityplayer.getCurrentEquippedItem());
	}

	@Override
	public final ItemStack transferStackInSlot(EntityPlayer player, int index) {
		ItemStack itemStack = null;
		Slot slot = (Slot) inventorySlots.get(index);

		if (slot != null && slot.getHasStack()) {
			ItemStack thisStack = slot.getStack();
			itemStack = thisStack.copy();

			if (index < 27) {
				if (!mergeItemStack(thisStack, 27, 63, true))
					return null;
				else if (!mergeItemStack(thisStack, 0, 27, false)) {
					slot.onPickupFromSlot(player, thisStack);
					return null;
				}
			}

			if (thisStack.stackSize == 0)
				slot.putStack((ItemStack) null);
			else
				slot.onSlotChanged();

			if (thisStack.stackSize == itemStack.stackSize)
				return null;

			slot.onPickupFromSlot(player, thisStack);
		}

		return itemStack;
	}

	@Override
	public boolean mergeItemStack(ItemStack itemStack, int startIndex, int endIndex, boolean useEndIndex) {

		boolean flag = false;
		int k = startIndex;

		if (useEndIndex)
			k = endIndex - 1;

		Slot slot;
		ItemStack itemstack1;

		if (itemStack.isStackable()) {
			while (itemStack.stackSize > 0 && (!useEndIndex && k < endIndex || useEndIndex && k >= startIndex)) {
				slot = (Slot) inventorySlots.get(k);
				itemstack1 = slot.getStack();

				if (itemstack1 != null && itemstack1.getItem() == itemStack.getItem() && (!itemStack.getHasSubtypes() || itemStack.getItemDamage() == itemstack1.getItemDamage()) && ItemStack.areItemStackTagsEqual(itemStack, itemstack1) && slot.isItemValid(itemStack)) {
					int l = itemstack1.stackSize + itemStack.stackSize;

					if (l <= itemStack.getMaxStackSize()) {
						itemStack.stackSize = 0;
						itemstack1.stackSize = l;
						slot.onSlotChanged();
						flag = true;
					} else if (itemstack1.stackSize < itemStack.getMaxStackSize()) {
						itemStack.stackSize -= itemStack.getMaxStackSize() - itemstack1.stackSize;
						itemstack1.stackSize = itemStack.getMaxStackSize();
						slot.onSlotChanged();
						flag = true;
					}
				}

				if (useEndIndex) {
					--k;
				} else {
					++k;
				}
			}
		}

		if (itemStack.stackSize > 0) {
			if (useEndIndex) {
				k = endIndex - 1;
			} else {
				k = startIndex;
			}

			while (!useEndIndex && k < endIndex || useEndIndex && k >= startIndex) {
				slot = (Slot) inventorySlots.get(k);
				itemstack1 = slot.getStack();

				if (itemstack1 == null && slot.isItemValid(itemStack)) {
					if (1 < itemStack.stackSize) {
						ItemStack copy = itemStack.copy();
						copy.stackSize = 1;
						slot.putStack(copy);

						itemStack.stackSize -= 1;
						flag = true;
						break;
					}
					slot.putStack(itemStack.copy());
					slot.onSlotChanged();
					itemStack.stackSize = 0;
					flag = true;
					break;
				}

				if (useEndIndex)
					--k;
				else
					++k;
			}
		}
		return flag;
	}
}