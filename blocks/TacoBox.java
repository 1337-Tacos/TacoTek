package assets.tacotek.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import assets.tacotek.Items.ItemsHelper;
import assets.tacotek.common.tacotek;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TacoBox extends Block {

	private static String name;
	
	//Create Definitions for textures
	@SideOnly(Side.CLIENT)
	private Icon topTexture;
	@SideOnly(Side.CLIENT)
	private Icon bottomTexture;
	
	//Constructor
	public TacoBox(int id, String name) {
		super(id, Material.wood);
		this.setUnlocalizedName(name);
		this.setCreativeTab(tacotek.tacotekTab);
		
		this.setHardness(1F);
		this.setResistance(5F);
		this.setStepSound(Block.soundWoodFootstep);
		
		//"pickaxe", "shovel", or "axe"?
		//The tier is 0 for wood, 1 for stone, 2 for iron, and 3 for diamond.
		//MinecraftForge.setBlockHarvestLevel(this, "shovel", 0);
	}
	
	public int idDropped(int i, Random rand, int j) {
		return ItemsHelper.taco.itemID;
	}
	
	public int quantityDropped(Random rand) {
		return 9;
	}
	
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer player, List dataList, boolean bool) {
		dataList.add("Store a Lot of Tacos");
		dataList.add("All in one Block.");
	}
	
	//Register the different textures to the definitions.
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister reg) {
		this.blockIcon = reg.registerIcon(tacotek.modID + ":" + name);
		this.topTexture = reg.registerIcon(tacotek.modID + ":" + name + "_top");
		this.bottomTexture = reg.registerIcon(tacotek.modID + ":" + name + "_bottom");
	}
	
	//Now apply one of the textures, depending on the side.
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int meta) {
		if(side == 1) { 	  //1 == top
			return this.topTexture;
		}
		else if (side == 0) { //0 == bottom
			return this.bottomTexture;
		}
		return this.blockIcon;
	}
}