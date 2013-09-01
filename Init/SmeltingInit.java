package assets.tacotek.Init;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import assets.tacotek.Items.Dough;
import assets.tacotek.Items.Flour;
import assets.tacotek.Items.Items;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class SmeltingInit {
	public SmeltingInit()
	{
		super();
	}
	
	public static void addSmeltRecipes()
	{
		//Dough to bread.
		GameRegistry.addSmelting(Items.Dough.itemID, new ItemStack(Item.bread, 1), 0.5F);
		
		//UncookedTortilla to Tortilla
		GameRegistry.addSmelting(Items.UncookedTortilla.itemID, new ItemStack(Items.Tortilla, 1), 1.0F);
	}
}