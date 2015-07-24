package com._1n5aN1aC.tacotek.armor.storage;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IChatComponent;

import com._1n5aN1aC.tacotek.armor.module.GenericModule;
import com._1n5aN1aC.tacotek.common.ModInfo;

public class InventoryModular extends InventoryBasic implements IInventory {

	private String name = "Modular Armor Inventory";
	private boolean reading = false;

	private final ItemStack containerStack;
	private final EntityPlayer player;
	private ItemStack[] inventory;

	public InventoryModular(EntityPlayer player, ItemStack stack, String name, boolean customName, int size) {
		super(name, customName, size);

		this.inventory = new ItemStack[size];
		this.containerStack = stack;
		this.player = player;

		//In case we don't have a NBT tag yet.
		if (!hasInventory())
			writeToNBT();

		readFromNBT();
	}

	@Override
	public void openInventory(EntityPlayer player) {
		readFromNBT();
	}

	@Override
	public void closeInventory(EntityPlayer player) {
		//
	}

	public void closeInventory(ItemStack stack) {
		writeToNBT();
		SetNBT(stack);
	}

	/**
	 * @return if the itemStack has an attached NBT inventory 
	 */
	private boolean hasInventory() {
		//Does it have any NBT?
		if (containerStack.getTagCompound() == null)
			return false;
		//Does it have our NBT?
		return containerStack.getTagCompound().getTag(ModInfo.TAG_ITEM_INVENTORY) != null;
	}

	public ItemStack getItemStack() {
		return this.containerStack;
	}

	/**
	 * A custom method to read our inventory from an ItemStack's NBT compound
	 * Some inspiration from forestry
	 * </br> http://www.minecraftforge.net/wiki/How_to_use_NBT_Tag_Compound#Types_of_tags
	 */
	public void readFromNBT() {
		reading = true;
		NBTTagCompound NBT = containerStack.getTagCompound();

		if (NBT == null || !NBT.hasKey(ModInfo.TAG_ITEM_INVENTORY))
			return;

		// Gets the custom taglist we wrote to this compound, if any
		NBTTagCompound nbttags = NBT.getCompoundTag(ModInfo.TAG_ITEM_INVENTORY);

		for (int i = 0; i < inventory.length; i++) {
			String slotKey = getSlotNBTKey(i);
			if (nbttags.hasKey(slotKey)) {
				NBTTagCompound itemNBT = nbttags.getCompoundTag(slotKey);
				ItemStack stack = ItemStack.loadItemStackFromNBT(itemNBT);
				setInventorySlotContents(i, stack);
			}
			else {
				inventory[i] = null;
			}
		}
		reading = false;
	}

	/**
	 * A custom method to write our inventory to an ItemStack's NBT compound
	 * Mostly inspired by forestry
	 */
	public void writeToNBT() {
		if (containerStack == null)
			return;

		// Create a new NBT Tag List to store itemstacks as NBT Tags
		NBTTagCompound NBT = containerStack.getTagCompound();
		NBTTagCompound slotsNBT = new NBTTagCompound();

		//If one doesn't exist, we add one to it.
		if (NBT == null) {
			containerStack.setTagCompound(new NBTTagCompound());
			NBT = containerStack.getTagCompound();
		}

		for (int i = 0; i < inventory.length; i++) {
			ItemStack stack = getStackInSlot(i);
			// Only write stacks that contain items
			if (stack != null) {
				String slotKey = getSlotNBTKey(i);
				// Make a new NBT Tag Compound to write the itemstack and slot index to
				NBTTagCompound nbttagcompound1 = new NBTTagCompound();
				stack.writeToNBT(nbttagcompound1);
				slotsNBT.setTag(slotKey, nbttagcompound1);
			}
		}
		// Add the TagList to the ItemStack's Tag Compound with the correct name
		NBT.setTag(ModInfo.TAG_ITEM_INVENTORY, slotsNBT);
		containerStack.getTagCompound().setTag(ModInfo.TAG_ITEM_INVENTORY, slotsNBT);
	}

	private static String getSlotNBTKey(int i) {
		return Integer.toString(i, Character.MAX_RADIX);
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
	@SuppressWarnings("all")
	public ItemStack decrStackSize(int index, int count) {
		ItemStack stack = getStackInSlot(index);
		if (stack == null)
			return null;

		if (stack.stackSize > count) {
			setInventorySlotContents(index, stack);

			return stack.splitStack(count);
		} else {
			setInventorySlotContents(index, null);
			return stack;
		}
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
		//npe prevention, by checking for empty stacks, and removing them.
		if (stack != null && stack.stackSize == 0) {
			stack = null;
		}

		inventory[index] = stack;

		//Now we update the NBT Tag data.
		//Some tutorials do not do this here, and rather do it upon closing,
		//But forestry does it in here, which seems to work well.
		NBTTagCompound nbt = containerStack.getTagCompound();

		//If no nbt exists, we create those NBT tags:
		if (nbt == null) {
			nbt = new NBTTagCompound();
			containerStack.setTagCompound(nbt);
		}

		//Similarly, if our specific inventory NBT doesn't exist, create it.
		NBTTagCompound slotNBT;
		if (!nbt.hasKey(ModInfo.TAG_ITEM_INVENTORY)) {
			slotNBT = new NBTTagCompound();
			nbt.setTag(ModInfo.TAG_ITEM_INVENTORY, slotNBT);
		} else {
			slotNBT = nbt.getCompoundTag(ModInfo.TAG_ITEM_INVENTORY);
		}

		//Now we know the overall tag exists; let's check if the specific slot one exists.
		String slotKey = getSlotNBTKey(index);
		if (stack == null) {
			slotNBT.removeTag(ModInfo.TAG_ITEM_INVENTORY);
		} else {
			NBTTagCompound itemNBT = new NBTTagCompound();
			stack.writeToNBT(itemNBT);
			slotNBT.setTag(slotKey, itemNBT);
		}
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public void markDirty() {
		super.markDirty();
		if (!reading) {
			writeToNBT();
			SetNBT(null);
		}
	}

	private void SetNBT(ItemStack stack) {
		if (stack == null && player != null) {
			stack = player.getCurrentEquippedItem();
		}
		if (stack != null && stack.getItem() == this.containerStack.getItem()) {
			stack.setTagCompound(containerStack.getTagCompound());
		}
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return true;
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