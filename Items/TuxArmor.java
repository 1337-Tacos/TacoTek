package assets.tacotek.Items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import assets.tacotek.common.IDsHelper;
import assets.tacotek.common.tacotek;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TuxArmor extends ItemArmor {

	public TuxArmor(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4) {
		super(par1, par2EnumArmorMaterial, par3, par4);
		// TODO Auto-generated constructor stub
	}
	
	public String getArmorTextureFile(ItemStack itemstack) {
		if (itemstack.itemID == IDsHelper.tux_headID || itemstack.itemID == IDsHelper.tux_chestID || itemstack.itemID == IDsHelper.tux_bootsID) {
			return "/mods/Tut/Textures/armor/Lol_1.png";
		}
		if (itemstack.itemID == IDsHelper.tux_legsID) {
			return "/mods/Tut/Textures/armor/Lol_2.png";
		}
		else return null;
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister reg)
	{
		if (this == ItemsHelper.tux_head) {
			this.itemIcon = reg.registerIcon(tacotek.modID + ":" + this.getUnlocalizedName() );
		}
		if (this == ItemsHelper.tux_chest) {
			this.itemIcon = reg.registerIcon(tacotek.modID + ":" + this.getUnlocalizedName() );
		}
		if (this == ItemsHelper.tux_legs) {
			this.itemIcon = reg.registerIcon(tacotek.modID + ":" + this.getUnlocalizedName() );
		}
		if (this == ItemsHelper.tux_boots) {
			this.itemIcon = reg.registerIcon(tacotek.modID + ":" + this.getUnlocalizedName() );
		}
	}
	
}