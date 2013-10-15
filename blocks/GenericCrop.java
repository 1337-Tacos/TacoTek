package assets.tacotek.blocks;

import net.minecraft.block.BlockCrops;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import assets.tacotek.Items.ItemsHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GenericCrop extends BlockCrops {
	
	public int seedItemID;
	public int fruitItemID;
	
	@SideOnly(Side.CLIENT)
	private Icon[] iconArray;

	public GenericCrop (int id, String name, int seedID, int fruitID) {
		super(id);
		this.setUnlocalizedName(name);
		
		this.seedItemID = seedID;
		this.fruitItemID = fruitID;
		//This allows you to change the hitboxes, and sort of rendering.
		//This can make the plant look significantly different, if the right values are edited.
		//setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.5F, 1.0F);
	}
	
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int par1, int par2) {
		if (par2 < 7) {
			if (par2 == 6) {
				par2 = 5;
			}
			return this.iconArray[par2 >> 1];
		} else {
			return this.iconArray[3];
		}
	}

	//Seed that is dropped by harvesting the crop
	protected int getSeedItem() {
		return seedItemID;
	}
	
	//Food that is dropped by the harvesting the crop
	protected int getCropItem() {
		return fruitItemID;
	}

	//Item selected when middle-clicking in creative (seed)
	public int idPicked (World world, int x, int y, int z) {
		return seedItemID;
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {
		this.iconArray = new Icon[4];
		
		for (int i = 0; i < this.iconArray.length; ++i) {
			this.iconArray[i] = par1IconRegister.registerIcon(this.getUnlocalizedName() + "_stage_" + (i + i));
		}
	}
}