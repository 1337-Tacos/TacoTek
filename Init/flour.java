package assets.tacotek.Init;

import assets.tacotek.common.tacotek;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class flour extends Item {
	public flour(int id){
		super(id);
		this.setCreativeTab(CreativeTabs.tabFood);
		
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister reg){
		this.itemIcon = reg.registerIcon(tacotek.modID + ":" + this.getUnlocalizedName());
	}
}
