package assets.tacotek.Items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import assets.tacotek.common.tacotek;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GenericItem extends Item {
	public GenericItem(int id) {
		super(id);
		this.setCreativeTab(tacotek.tacotekTab);
	}
	
	public GenericItem(int id, String name) {
		super(id);
		this.setCreativeTab(tacotek.tacotekTab);
		this.setUnlocalizedName(name);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister reg) {
		this.itemIcon = reg.registerIcon(tacotek.modID + ":" + this.getUnlocalizedName());
	}
}