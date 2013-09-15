package assets.tacotek.Items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import assets.tacotek.common.tacotek;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GenericItem extends Item {
	
	//Constructor:id.
	public GenericItem(int id) {
		super(id);
		this.setCreativeTab(tacotek.tacotekTab);
	}
	
	//Constructor:id and name.
	public GenericItem(int id, String name) {
		this(id);
		this.setUnlocalizedName(name);
	}
	
	//Constructor:id, name, and stack limit.
	public GenericItem(int id, String name, int stack){
		this(id, name);
		this.maxStackSize=stack;
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister reg) {
		this.itemIcon = reg.registerIcon(tacotek.modID + ":" + this.getUnlocalizedName());
	}
}