package assets.tacotek.common;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class PlayerInventoryHelper {
	
	//This is just for the enderstorage bags.
	//It finds all itemstacks in players inventory that are of the passed type, deletes them, and returns how many it found.
	public static int loadBag(EntityPlayer player, int blockID, int curDmg){
		InventoryPlayer invContainer=player.inventory;
		ItemStack[] inv=invContainer.mainInventory;
		int howMany=0;
		
		//Makes sure bag isn't already full.
		if(curDmg!=0){
		
		for(int i=0; i<inv.length; i++){
			
			if (inv[i]!=null && inv[i].itemID==blockID){
			
			howMany=howMany+inv[i].stackSize;
			
			if (curDmg-howMany>0){
				inv[i]=null;
			}
			
			else{
				int overFlow=Math.abs(curDmg-howMany);
				ItemStack giveBack=new ItemStack(Block.torchWood, overFlow);
				invContainer.addItemStackToInventory(giveBack);
				howMany=howMany-overFlow;
				break;
			}
		}
	}
	}
	return howMany;
		
	}
}
