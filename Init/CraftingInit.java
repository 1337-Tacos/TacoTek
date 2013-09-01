package assets.tacotek.Init;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class CraftingInit {

	public CraftingInit()
	{
		super();
	}
	
	public static void addRecipes()
	{
		GameRegistry.addRecipe(new ItemStack(net.minecraft.item.Item.diamond, 4), new Object[]{
			"TDT",
			"TTT",
			"TtT",
			'T', Item.diamond,
			'D', Item.appleRed,
			't', Item.book
		});
		
		GameRegistry.addRecipe(new ItemStack(net.minecraft.item.Item.plateIron, 1), new Object[]{
			"A A",
			"AAA",
			"AAA",
			'A', Item.appleRed
		});
	}
	
}