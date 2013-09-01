package assets.tacotek.Init;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import assets.tacotek.Items.*;
import assets.tacotek.Items.Items.*;
import assets.tacotek.common.tacotek;

public class CraftingInit {

	public CraftingInit()
	{
		super();
	}
	
	public static void addCraftingRecipes()
	{
		GameRegistry.addRecipe(new ItemStack(net.minecraft.item.Item.diamond, 4), new Object[]{
			"T T",
			"TTT",
			"T T",
			'T', assets.tacotek.Items.Items.Dough,
		});
		
		GameRegistry.addRecipe(new ItemStack(assets.tacotek.Items.Items.Dough, 1), new Object[]{
			"F",
			'F', Items.Flour,
		});
	}
	
}