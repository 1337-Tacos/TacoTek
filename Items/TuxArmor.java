package assets.tacotek.Items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import assets.tacotek.common.IDsHelper;
import assets.tacotek.common.tacotek;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TuxArmor extends ItemArmor {

	public TuxArmor(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4, String unlocalizedName)
	{
		super(par1, par2EnumArmorMaterial, par3, par4);
		this.setCreativeTab(tacotek.tacotekTab);
		this.setUnlocalizedName(unlocalizedName);
	}
	
	@Override
	public String getArmorTexture(ItemStack itemstack, Entity entity, int slot, int layer)
	{
		if (itemstack.itemID == IDsHelper.tux_headID + 256 || itemstack.itemID == IDsHelper.tux_chestID + 256 || itemstack.itemID == IDsHelper.tux_bootsID + 256) {
			return tacotek.modID + ":" + "textures/models/armor/tux_1.png";
		}
		if (itemstack.itemID == IDsHelper.tux_legsID + 256) {
			return tacotek.modID + ":" + "textures/models/armor/tux_2.png";
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