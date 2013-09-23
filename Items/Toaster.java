package assets.tacotek.Items;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import assets.tacotek.common.IDsHelper;
import assets.tacotek.common.SideHelper;
import assets.tacotek.common.tacotek;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Toaster extends GenericItem {
	public Toaster(int id, String name) {
		super(id);
		this.setCreativeTab(tacotek.tacotekTab);
		this.setUnlocalizedName(name);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister reg) {
		this.itemIcon = reg.registerIcon(tacotek.modID + ":" + this.getUnlocalizedName() );
	}
	
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer player, List dataList, boolean bool) {
		dataList.add("It's a flying toaster.");
	}
	
	//Called when item is used.
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float par8, float par9, float par10)  {

		//Returns an array of coords that are adjusted for the side selected.
		int[] adjCoords=SideHelper.sideAdjust(x,y,z,side);
		
		//Converts the array elements back into x, y, and z.
		x=adjCoords[0];
		y=adjCoords[1];
		z=adjCoords[2];
				
		//Assuming player can edit that block, EDIT IT!
		if (player.canPlayerEdit(x, y, z, side, stack)) {
			world.setBlock(x, y, z, IDsHelper.tacoBoxID);
			world.notifyBlockOfNeighborChange(x, y, z, IDsHelper.tacoBoxID);
			--stack.stackSize;
			return true;
		}
		else return false;
	}
}