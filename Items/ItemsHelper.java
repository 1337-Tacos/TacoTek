package assets.tacotek.Items;

import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.src.ModLoader;
import net.minecraftforge.common.EnumHelper;
import assets.tacotek.common.IDsHelper;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ItemsHelper {
	//Items
	public static Item cheese;
	public static Item dough;
	public static Item exchangeOMatic;
	public static Item flour;
	public static Item salt;
	public static Item taco;
	public static Item toaster;
	public static Item tortilla;
	public static Item uncookedTortilla;
	
	//Armor
	public static Item tux_head;
	public static Item tux_chest;
	public static Item tux_legs;
	public static Item tux_boots;
	
	public static EnumArmorMaterial TuxArmor = EnumHelper.addArmorMaterial("Tux", 66, new int[] {3,3,1,1}, 50);
	
	public static void setupItems() {
		//Item Loading
		cheese = new Cheese(IDsHelper.cheeseID).setUnlocalizedName("cheese");
		dough = new GenericItem(IDsHelper.doughID).setUnlocalizedName("dough");
		//exchangeOMatic = new ExchangeOMatic(IDsHelper.exchangeOMaticID).setUnlocalizedName("exchangeOMatic");
		flour = new GenericItem(IDsHelper.flourID).setUnlocalizedName("flour");
		salt = new GenericItem(IDsHelper.saltID).setUnlocalizedName("salt");
		taco = new Taco(IDsHelper.tacoID).setUnlocalizedName("taco");
		toaster = new Toaster(IDsHelper.toasterID).setUnlocalizedName("toaster");
		tortilla = new GenericItem(IDsHelper.tortillaID).setUnlocalizedName("tortilla");
		uncookedTortilla = new GenericItem(IDsHelper.uncookedTortillaID).setUnlocalizedName("uncookedtortilla");
		
		//Armor Loading
		tux_head = new TuxArmor(IDsHelper.tux_headID, TuxArmor, ModLoader.addArmor("Tux"), 0).setUnlocalizedName("tux_head");
		tux_chest = new TuxArmor(IDsHelper.tux_chestID, TuxArmor, ModLoader.addArmor("Tux"), 1).setUnlocalizedName("tux_chest");
		tux_legs = new TuxArmor(IDsHelper.tux_legsID, TuxArmor, ModLoader.addArmor("Tux"), 2).setUnlocalizedName("tux_legs");
		tux_boots = new TuxArmor(IDsHelper.tux_bootsID, TuxArmor, ModLoader.addArmor("Tux"), 3).setUnlocalizedName("tux_boots");
		
		gameRegisters();
        languageRegistry();
	}
	
	private static void gameRegisters() {
		//Item Registry
		GameRegistry.registerItem(cheese, "Cheese", null);
		GameRegistry.registerItem(dough, "Dough", null);
		//GameRegistry.registerItem(exchangeOMatic, "ExchangeOMatic", null);
		GameRegistry.registerItem(flour, "Flour", null);
		GameRegistry.registerItem(salt, "Salt", null);
		GameRegistry.registerItem(taco, "Taco", null);
		GameRegistry.registerItem(toaster, "Toaster", null);
		GameRegistry.registerItem(tortilla, "Tortilla", null);
		GameRegistry.registerItem(uncookedTortilla, "Uncooked Tortilla", null);
		
		//Armor Items
		GameRegistry.registerItem(tux_head, "tux_head", null);
		GameRegistry.registerItem(tux_chest, "tux_chest", null);
		GameRegistry.registerItem(tux_legs, "tux_legs", null);
		GameRegistry.registerItem(tux_boots, "tux_boots", null);
	}

    private static void languageRegistry() {
    	//Items
		LanguageRegistry.addName(cheese, "Cheese");
		LanguageRegistry.addName(dough, "Dough");
		//LanguageRegistry.addName(exchangeOMatic, "Exchange O Matic");
    	LanguageRegistry.addName(flour, "Flour");
		LanguageRegistry.addName(salt, "Salt");
		LanguageRegistry.addName(taco, "Taco");
		LanguageRegistry.addName(toaster, "Toaster");
		LanguageRegistry.addName(tortilla, "Tortilla");
		LanguageRegistry.addName(uncookedTortilla, "Uncooked Tortilla");
		
		//Armor Items
		LanguageRegistry.addName(tux_head, "Fedora");
		LanguageRegistry.addName(tux_chest, "Tuxedo");
		LanguageRegistry.addName(tux_legs, "Dress Pants");
		LanguageRegistry.addName(tux_boots, "Dress Shoes");
    }
}