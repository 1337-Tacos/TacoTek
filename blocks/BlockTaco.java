package assets.tacotek.blocks;

import assets.tacotek.common.tacotek;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockTaco extends Block
{

	private static String textureName;
	
	public BlockTaco(int id, String textureName)
	{
		super(id, Material.rock);
		
		this.textureName = textureName;
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister reg) {
		this.blockIcon = reg.registerIcon(tacotek.modID + ":" + textureName);
	}
}