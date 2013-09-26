package assets.tacotek.Items;

import java.util.Arrays;
import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.InventoryEnderChest;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import assets.tacotek.common.tacotek;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ElectricEnderChest extends GenericElectric {

	private static int energyCost = 10000;
	
	public ElectricEnderChest(int id, String name) {
		super(id, 100000, 1, 100);
		this.setUnlocalizedName(name);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister reg) {
		this.itemIcon = reg.registerIcon(tacotek.modID + ":" + this.getUnlocalizedName() );
	}
	
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer player, List dataList, boolean bool) {
		dataList.add("A handheld enderchest.");
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World par2World, EntityPlayer player) {
		boolean isServer = player instanceof EntityPlayerMP;
		
		if (!canTakeDamage(stack, energyCost)) {
			
			if (!isServer){
				player.addChatMessage("§8Not Enough Power!");
			}
			
			return stack;
		}
		
		InventoryEnderChest endInv=player.getInventoryEnderChest();
		
		damage(stack, energyCost, player);
		
		player.displayGUIChest(endInv);
		
		return stack;
	}
}
