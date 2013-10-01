package assets.tacotek.common;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;

public class PlayerInventoryHelper {

	//This is just for the enderstorage bags.
	//It finds all itemstacks in players inventory that are of the passed type, deletes them, and returns how many it found.
	public static int loadBag(EntityPlayer player, int blockID, int curDmg) {
		InventoryPlayer invContainer=player.inventory;
		ItemStack[] inv = invContainer.mainInventory;
		int howMany = 0;

		//Makes sure bag isn't already full.
		if(curDmg != 0) {

			for(int i = 0; i < inv.length; i++) {

				//If itemstack at index is the same as the item passed.
				if(inv[i] != null && inv[i].itemID == blockID) {

					//Adds the stack size to the howMany counter.
					howMany = howMany + inv[i].stackSize;
					
					//Deletes stack from array.
					inv[i] = null;

					if(curDmg - howMany == 0) {
						break;
					}

					//Checks if amount will overflow bag. If yes returns overflow to inventory and breaks loop.
					if(curDmg - howMany < 0) {
						int giveBack = Math.abs(curDmg - howMany);
						invContainer.addItemStackToInventory(new ItemStack(Block.torchWood, giveBack));
						howMany = howMany - giveBack;
						break;
					}
				}
			}
		}
		return howMany;
	}
}