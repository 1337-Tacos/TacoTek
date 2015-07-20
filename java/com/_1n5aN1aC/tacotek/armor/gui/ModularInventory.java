package com._1n5aN1aC.tacotek.armor.gui;

import com._1n5aN1aC.tacotek.armor.module.GenericModule;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.IChatComponent;

public class ModularInventory implements IInventory {

	private String name = "Modular Armor Inventory";
	public static int INV_SIZE;

	private ItemStack[] inventory;
	private final ItemStack containerStack;

	public ModularInventory(ItemStack stack, int size) {
		this.INV_SIZE = size;

		inventory = new ItemStack[INV_SIZE];
		containerStack = stack;

		//In case we don't have a NBT tag yet.
		if (!stack.hasTagCompound())
			stack.setTagCompound( new NBTTagCompound() );

		readFromNBT(stack.getTagCompound());
	}

	public ItemStack getContainerStack() {
		return this.containerStack;
	}

	/**
	 * A custom method to read our inventory from an ItemStack's NBT compound
	 * </br> http://www.minecraftforge.net/wiki/How_to_use_NBT_Tag_Compound#Types_of_tags
	 * @param tagcompound
	 */
	public void readFromNBT(NBTTagCompound tagcompound) {
		// Gets the custom taglist we wrote to this compound, if any
		//TODO:  this part could be incorrect
		NBTTagList nbttaglist = tagcompound.getTagList("ItemInventory", 10);

		for (int i = 0; i < nbttaglist.tagCount(); ++i) {
			//TODO:  this part could be incorrect
			NBTTagCompound nbttagcompound1 = (NBTTagCompound)nbttaglist.get(i);
			int b0 = nbttagcompound1.getInteger("Slot");

			// Just double-checking that the saved slot index is within our inventory array bounds
			if (b0 >= 0 && b0 < this.getSizeInventory()) {
				this.setInventorySlotContents(b0, ItemStack.loadItemStackFromNBT(nbttagcompound1));
			}
		}
	}

	//A custom method to write our inventory to an ItemStack's NBT compound
	public void writeToNBT(NBTTagCompound tagcompound) {
		// Create a new NBT Tag List to store itemstacks as NBT Tags
		NBTTagList nbttaglist = new NBTTagList();

		for (int i = 0; i < this.getSizeInventory(); ++i) {
			// Only write stacks that contain items
			if (this.getStackInSlot(i) != null) {
				// Make a new NBT Tag Compound to write the itemstack and slot index to
				NBTTagCompound nbttagcompound1 = new NBTTagCompound();
				nbttagcompound1.setInteger("Slot", i);
				// Writes the itemstack in slot(i) to the Tag Compound we just made
				this.getStackInSlot(i).writeToNBT(nbttagcompound1);

				// add the tag compound to our tag list
				nbttaglist.appendTag(nbttagcompound1);
			}
		}
		// Add the TagList to the ItemStack's Tag Compound with the name "ItemInventory"
		tagcompound.setTag("ItemInventory", nbttaglist);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public boolean hasCustomName() {
		return true;
	}

	@Override
	public IChatComponent getDisplayName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSizeInventory() {
		return inventory.length;
	}

	@Override
	public ItemStack getStackInSlot(int index) {
		return inventory[index];
	}

	@Override
	//http://www.minecraftforum.net/forums/mapping-and-modding/mapping-and-modding-tutorials/1571597-forge-1-6-4-1-8-custom-inventories-in-items-and
	public ItemStack decrStackSize(int index, int count) {
		ItemStack stack = getStackInSlot(index);
		if (stack != null) {
			if (stack.stackSize > count) {
				stack = stack.splitStack(count);
				if (stack.stackSize == 0) {
					setInventorySlotContents(index, null);
				}
			}
			else {
				setInventorySlotContents(index, null);
			}
			this.markDirty();
		}
		return stack;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int index) {
		ItemStack stack = getStackInSlot(index);
		if (stack != null) {
			setInventorySlotContents(index, null);
		}
		return stack;
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
		this.inventory[index] = stack;
		if (stack != null && stack.stackSize > this.getInventoryStackLimit()) {
			stack.stackSize = this.getInventoryStackLimit();
		}
		this.markDirty();
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public void markDirty() {
		for (int i = 0; i < this.getSizeInventory(); ++i) {
			if (this.getStackInSlot(i) != null && this.getStackInSlot(i).stackSize == 0)
				this.setInventorySlotContents(i, null);
		}
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return true;
	}

	@Override
	public void openInventory(EntityPlayer player) {
		//
	}

	@Override
	public void closeInventory(EntityPlayer player) {
		//
	}

	/** Here we only allow users to put module items into the inventory. */
	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		if (stack == null || stack.getItem() == null) {
			return false;
		}
		return (stack.getItem() instanceof GenericModule);
	}

	@Override
	public int getField(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setField(int id, int value) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getFieldCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}
}