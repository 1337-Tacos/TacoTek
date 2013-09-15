package assets.tacotek.Items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.SideOnly;
import cpw.mods.fml.relauncher.Side;

public class GenericItemDescription extends GenericItem {
	
	String description="No description.";

	public GenericItemDescription(int id, String name, String desc) {
		super(id, name);
		this.description=desc;
	}
	
	public GenericItemDescription(int id, String name, String desc, int stack){
		super(id, name, stack);
		this.description=desc;
	}

	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer player, List dataList, boolean bool) {
		dataList.add(description);
	}

}
