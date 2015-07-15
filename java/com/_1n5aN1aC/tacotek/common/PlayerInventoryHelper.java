package com._1n5aN1aC.tacotek.common;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class PlayerInventoryHelper {

	//This is just for the enderstorage bags.
	//It finds all itemstacks in players inventory that are of the passed type and deletes them. Returns how many it found.
	public static int loadBag(EntityPlayer player, Item item, int curDmg) {
		InventoryPlayer invContainer=player.inventory;
		ItemStack[] inv = invContainer.mainInventory;
		int howMany = 0;

		//Makes sure bag isn't already full.
		if(curDmg != 0) {

			for(int i = 0; i < inv.length; i++) {

				//If itemstack at index is the same as the item passed.
				if(inv[i] != null && inv[i].getItem() == item) {

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
						invContainer.addItemStackToInventory(new ItemStack(item, giveBack));
						howMany = howMany - giveBack;
						break;
					}
				}
			}
		}
		return howMany;
	}
	
	//Searches the players inventory for item stacks that match the passed ID. Returns array of item stacks that matched the ID passed.
	public static ItemStack[] searchInventory(EntityPlayer player, Item item){
		
		//Grabs the players inventory.
		InventoryPlayer invContainer=player.inventory;
		ItemStack[] inv = invContainer.mainInventory;
		
		//Array of item stacks that matched the ID passed.
		ItemStack[] found=new ItemStack[36];
		
		for(int i=0; i<=inv.length; i++){
			
			//If there is an item stack in that slot and it's ID matches the on passed.
			if(inv[i]!=null && inv[i].getItem() == item){
				
				//Adds the item stack to the found array to be returned.
				found[i]=inv[i];
				
			}
			
		}
		return found;
	}
	
	//Removes a certain amount of an item from the players inventory. Returns how many were removed.
	public static int consumeItems(EntityPlayer player, Item item, int howMany){
		
		//Grabs the players inventory.
		InventoryPlayer invContainer=player.inventory;
		ItemStack[] inv = invContainer.mainInventory;
		
		//Array of items that match the ID passed.
		ItemStack[] items=searchInventory(player, item);
		
		//Counter for how many were found and removed.
		int removed=0;
		
		for(int i=0; i<=items.length; i++){
			
			//If more need to be removed to match the number passed.
			if(removed<howMany){
			
			//Keeps track of how many are removed.
			removed=removed+items[i].stackSize;
			items[i]=null;
			
			}
			
			else if(removed>howMany){
				
				//Calculates how much overflow there is.
				int giveBk=removed-howMany;
				
				//Gives player back the overflow.
				invContainer.addItemStackToInventory(new ItemStack(item, giveBk));
				break;
				
			}
			
		}
		return removed;
	}
	
	//Fetches player's inventory container and returns it.
	public static InventoryPlayer getInvContainer(EntityPlayer player){
		
		return player.inventory;
		
	}
	
	//Fetches player's main inventory and returns it.
	public static ItemStack[] getMainInventory(EntityPlayer player){
		
		InventoryPlayer invContainer=player.inventory;
		return invContainer.mainInventory;
		
	}
	
	//Fetches array of player's armor and returns it.
	public static ItemStack[] getArmorInventory(EntityPlayer player){
		
		InventoryPlayer invContainer=player.inventory;
		return invContainer.armorInventory;
		
	}
	
}