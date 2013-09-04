package assets.tacotek.Items;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import assets.tacotek.common.IDsHelper;
import assets.tacotek.common.tacotek;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Toaster extends Item
{
	public Toaster(int id)
	{
		super(id);
		this.setCreativeTab(tacotek.tacotekTab);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister reg)
	{
		this.itemIcon = reg.registerIcon(tacotek.modID + ":" + this.getUnlocalizedName() );
	}
	
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer player, List dataList, boolean bool) {
		dataList.add("It's a flying toaster.");
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float par8, float par9, float par10) 
	{
		//This following block detects which side of the block you clicked on,
		//and then moves the block you are about to modify in the right direction.
		int xm = 0; int ym = 0; int zm = 0;  //xmoved, ymoved, zmoved.
		if (side == 0) {		//0 = botom
			ym = -1;
		} else if(side == 1) {	//1 = top
			ym = 1;
		} else if (side == 2) {	//2 = North
			zm = -1;
		} else if (side == 3) {	//3 - South
			zm = 1;
		} else if (side == 4) {	//4 = West
			xm = -1;
		} else if (side == 5) {	//5 = East
			xm = 1;
		}
		x = x+xm;  y = y+ym;  z = z+zm;	//Change the block we are modifying based on xm, ym , and zm.
		
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