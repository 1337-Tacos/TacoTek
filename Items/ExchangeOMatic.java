package assets.tacotek.Items;

import ic2.api.item.ElectricItem;
import ic2.api.item.IElectricItem;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import assets.tacotek.common.IDsHelper;
import assets.tacotek.common.tacotek;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ExchangeOMatic extends GenericElectric {

	private static int convertID = net.minecraft.block.Block.stone.blockID;
	private static int useEnergy = 5;
	
	public ExchangeOMatic(int id) {
		super(id, 31337, 2, 100);
		this.setMaxDamage(100);
		this.setMaxStackSize(1);
		this.setCreativeTab(tacotek.tacotekTab);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister reg) {
		this.itemIcon = reg.registerIcon(tacotek.modID + ":" + this.getUnlocalizedName() );
	}
	
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer player, List dataList, boolean bool) {
		dataList.add("This is a placeholder");
	}
	
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float par8, float par9, float par10) {
		boolean isServer = player instanceof EntityPlayerMP;
		
		if (!canTakeDamage(stack, useEnergy)) {
			if (!isServer)
				player.addChatMessage("§8Not Enough Power!!");
			return false;
		}
		else if (isServer && player.isSneaking()) {
			if (convertID != net.minecraft.block.Block.stone.blockID && world.getBlockId(x, y, z) == net.minecraft.block.Block.stone.blockID) {
				convertID = net.minecraft.block.Block.stone.blockID;
				player.addChatMessage("§8Exchange O' Matic Now in Stone mode!");
			}
			else if (convertID != net.minecraft.block.Block.dirt.blockID && world.getBlockId(x, y, z) == net.minecraft.block.Block.dirt.blockID) {
				convertID = net.minecraft.block.Block.dirt.blockID;
				player.addChatMessage("§8Exchange O' Matic Now in Dirt mode!");
			}
			return false;
		}
		
		
		//Assuming player can edit that block, EDIT IT!
		if (player.canPlayerEdit(x, y, z, side, stack)) {
			damage(stack, useEnergy, player);
			world.setBlock(x, y, z, convertID);
			world.notifyBlockOfNeighborChange(x, y, z, convertID);
			return true;
		}
		else return false;
	}
	
    @SideOnly(Side.CLIENT)
    public void getSubItems(int var1, CreativeTabs var2, List var3) {
        ItemStack tCharged = new ItemStack(this, 1), tUncharged = new ItemStack(this, 1, getMaxDamage());
        ElectricItem.manager.charge(tCharged, Integer.MAX_VALUE, Integer.MAX_VALUE, true, false);
        var3.add(tCharged);
        var3.add(tUncharged);
    }
}