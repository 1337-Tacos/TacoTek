package assets.tacotek.Init;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import assets.tacotek.Items.Dough;
import assets.tacotek.Items.Flour;
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
		GameRegistry.addSmelting(assets.tacotek.Items.Items.Dough.itemID, new ItemStack(Item.bread, 1), 1.0F);
	}
}