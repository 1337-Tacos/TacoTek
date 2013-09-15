package assets.tacotek.Items;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import assets.tacotek.common.tacotek;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GenericItem extends Item {
	
	//Item Description
	private String description = "error - bad description";
	
	//Constructor:id.
	public GenericItem(int id) {
		super(id);
		this.setCreativeTab(tacotek.tacotekTab);
	}
	
	//Constructor:id and name.
	public GenericItem(int id, String name) {
		super(id);
		this.setCreativeTab(tacotek.tacotekTab);
		this.setUnlocalizedName(name);
	}
	
	//Constructor:id, name, and description.
	public GenericItem(int id, String name, String desc){
		super(id);
		this.setCreativeTab(tacotek.tacotekTab);
		this.setUnlocalizedName(name);
		this.description=desc;
	}
	
	//Constuctor:id, name, description, and stack limit.
	public GenericItem(int id, String name, String desc, int stack){
		super(id);
		this.setCreativeTab(tacotek.tacotekTab);
		this.setUnlocalizedName(name);
		this.description = desc;
		this.maxStackSize=stack;
	}
	
	//Constructor:id, name, and stack limit.
	public GenericItem(int id, String name, int stack){
		super(id);
		this.setCreativeTab(tacotek.tacotekTab);
		this.setUnlocalizedName(name);
		this.maxStackSize=stack;
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister reg) {
		this.itemIcon = reg.registerIcon(tacotek.modID + ":" + this.getUnlocalizedName());
	}
	
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer player, List dataList, boolean bool) {
		dataList.add(description);
	}
}