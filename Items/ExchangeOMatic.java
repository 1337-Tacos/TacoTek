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

public class ExchangeOMatic extends Item {

	public static int convertID = net.minecraft.block.Block.stone.blockID;
	
	public ExchangeOMatic(int id)
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
		dataList.add("This is a placeholder");
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float par8, float par9, float par10) 
	{
		if (player.isSneaking())
		{
			if (convertID == net.minecraft.block.Block.stone.blockID)
			{
				convertID = net.minecraft.block.Block.dirt.blockID;
				player.addChatMessage("§8Exchange O' Matic Now in Dirt mode!");
				return false;
			}
			else if (convertID == net.minecraft.block.Block.dirt.blockID)
			{
				convertID = net.minecraft.block.Block.stone.blockID;
				player.addChatMessage("§8Exchange O' Matic Now in Stone mode!");
				return false;
			}
			return false;
		}
		
		//Assuming player can edit that block, EDIT IT!
		if (player.canPlayerEdit(x, y, z, side, stack)) {
			world.setBlock(x, y, z, convertID);
			world.notifyBlockOfNeighborChange(x, y, z, convertID);
			return true;
		}
		else return false;
	}
}