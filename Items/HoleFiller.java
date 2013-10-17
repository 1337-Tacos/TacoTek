package assets.tacotek.Items;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.InventoryEnderChest;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import assets.tacotek.common.tacotek;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class HoleFiller extends GenericElectric{

	private static int energyCost = 10000;
	
	public HoleFiller(int id, String name) {
		super(id, 100000, 1, 100);
		this.setUnlocalizedName(name);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister reg) {
		this.itemIcon = reg.registerIcon(tacotek.modID + ":" + this.getUnlocalizedName() );
	}
	
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer player, List dataList, boolean bool) {
		dataList.add("Fills creeper holes. Choking hazard. Contains small parts.");
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float par8, float par9, float par10) {
		boolean isServer = player instanceof EntityPlayerMP;
		
		if (!canTakeDamage(stack, energyCost)) {
			if (!isServer) {
				player.addChatMessage("§8Not Enough Power!");
			}
			return false;
		}
		
		return true;
	}
}
