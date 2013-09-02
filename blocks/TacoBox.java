package assets.tacotek.blocks;

import java.util.List;
import java.util.Random;
import assets.tacotek.Items.Items;
import assets.tacotek.common.tacotek;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class TacoBox extends Block {

	private static String textureName;
	
	//Create Definitions for textures
	@SideOnly(Side.CLIENT)
	private Icon topTexture;
	@SideOnly(Side.CLIENT)
	private Icon bottomTexture;
	
	//Constructor
	public TacoBox(int id, String textureName) {
		super(id, Material.wood);
		this.textureName = textureName;
		
		this.setHardness(1F);
		this.setResistance(5F);
		this.setStepSound(Block.soundWoodFootstep);
		
	}
	
	public int idDropped(int i, Random rand, int j) {
		return Items.Taco.itemID;
	}
	
	public int quantityDropped(Random rand) {
		return 9;
		//return rand.nextInt(5) + 1;  //Between 1 and 6
	}
	
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer player, List dataList, boolean bool) {
		dataList.add("Store a Lot of Tacos");
		dataList.add("All in one place.");
	}
	
	//Register the different textures to the definitions.
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister reg) {
		this.blockIcon = reg.registerIcon(tacotek.modID + ":" + textureName);
		this.topTexture = reg.registerIcon(tacotek.modID + ":" + textureName + "_top");
		this.bottomTexture = reg.registerIcon(tacotek.modID + ":" + textureName + "_bottom");
	}
	
	//Now apply one of the textures, depending on the side.
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int meta) {
		//1 == top
		if(side == 1) {
			return this.topTexture;
		}
		//0 == bottom
		else if (side == 0) {
			return this.bottomTexture;
		}
		return this.blockIcon;
	}
}