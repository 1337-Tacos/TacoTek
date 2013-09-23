package assets.tacotek.Items;

import assets.tacotek.common.IDsHelper;
import assets.tacotek.common.SideHelper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class TorchPlacer extends GenericItemDescription {

	public TorchPlacer(int id, String name, String desc, int dmg, int stack) {
		super(id, name, desc, stack);
		this.isDamageable();
		this.setMaxDamage(dmg);
	}
	
	//Forge calls this when the item is used.
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float par8, float par9, float par10) {
		boolean isServer = player instanceof EntityPlayerMP;
		
		//Checks if damage value is maxed.
		if (stack.getItemDamage()==stack.getMaxDamage()) {
			
			//Makes sure client side for player message.
			if (!isServer){
				//Displays chat that dispenser is out of torches.
				player.addChatMessage("§8No torches left.");
			}
			//Tells forge item use was illegal.
			return false;
		}
		
		//Returns an array of coords that are adjusted for the side selected.
		int[] adjCoords=SideHelper.sideAdjust(x,y,z,side);
		
		//Converts the array elements back into x, y, and z.
		x=adjCoords[0];
		y=adjCoords[1];
		z=adjCoords[2];
		
		//Checks if player can edit block.
		if (player.canPlayerEdit(x, y, z, side, stack)) {
			
			//Checks if location is empty.
			if(world.getBlockId(x,y,z)==0){
				world.setBlock(x, y, z, Block.torchWood.blockID);
				world.notifyBlockOfNeighborChange(x, y, z, Block.torchWood.blockID);
				stack.setItemDamage(stack.getItemDamage()+1);
				//Tells forge item use was legal.
				return true;
			}
		}
		return false;
	}
}
