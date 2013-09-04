package assets.tacotek.Items;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.client.IRenderContextHandler;
import net.minecraftforge.client.IRenderHandler;

public class TuxArmor extends ItemArmor {

	public TuxArmor(int par1, EnumArmorMaterial par2EnumArmorMaterial,
			int par3, int par4) {
		super(par1, par2EnumArmorMaterial, par3, par4);
		// TODO Auto-generated constructor stub
	}
	
	public String getArmorTextureFile(ItemStack itemstack) {
		return field_111218_cA;
		
	}
	
}