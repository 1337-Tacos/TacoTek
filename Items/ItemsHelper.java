package assets.tacotek.Items;

import net.minecraft.item.Item;

public class ItemsHelper {
	//Items
	public static Item cheese;
	public static Item dough;
	public static Item flour;
	public static Item salt;
	public static Item taco;
	public static Item tortilla;
	public static Item uncookedTortilla;
	
	public static void setupItems() {
		//Item Loading
		flour=new Flour(4000).setUnlocalizedName("flour");
	}
	
}