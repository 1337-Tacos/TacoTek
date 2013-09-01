package assets.tacotek.Init;

import assets.tacotek.Items.flour;
import assets.tacotek.blocks.BlockTaco;
import assets.tacotek.common.tacotek;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ItemInit {

	public ItemInit()
	{
		super();
	}
	
	public static Item tempFlour;
	
	public static void addItems()
	{
		tempFlour=new flour(4000).setUnlocalizedName("flour");
		LanguageRegistry.addName(tempFlour,"Flour");
	}
	
}