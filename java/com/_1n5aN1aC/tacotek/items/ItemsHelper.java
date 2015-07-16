package com._1n5aN1aC.tacotek.items;

import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com._1n5aN1aC.tacotek.proxy.CommonProxy;

public final class ItemsHelper {
	//Enumerators
	public static ArmorMaterial tuxMaterial = EnumHelper.addArmorMaterial("tuxMaterial", "tacotek:tux", 5, new int[] {1, 3, 2, 1}, 30);
	public static ArmorMaterial modularMaterial = EnumHelper.addArmorMaterial("modularMaterial", "tacotek:modular", 16, new int[] {2, 3, 2, 1}, 0);
	
	//Generic Items
	public static GenericItem salt;
	
	//Foods
	public static Taco taco;
	
	//Armor
	public static GenericArmor tuxHelm;
	public static GenericArmor tuxChest;
	public static GenericArmor tuxLegs;
	public static GenericArmor tuxBoots;
	
	public static ModularArmor modularHelm;
	public static ModularArmor modularChest;
	public static ModularArmor modularLegs;
	public static ModularArmor modularBoots;

	public static void setupItems(CommonProxy proxy) {
		//Generic Items
		GameRegistry.registerItem( salt = new GenericItem("salt"), "salt");
		GameRegistry.registerItem( taco = new Taco("taco"), "taco");

		//Tux Armor
		GameRegistry.registerItem(tuxHelm = new GenericArmor("tux_helm", tuxMaterial, 1, 0), "tux_helm");
		GameRegistry.registerItem(tuxChest = new GenericArmor("tux_chest", tuxMaterial, 1, 1), "tux_chest");
		GameRegistry.registerItem(tuxLegs = new GenericArmor("tux_legs", tuxMaterial, 2, 2), "tux_legs");
		GameRegistry.registerItem(tuxBoots = new GenericArmor("tux_boots", tuxMaterial, 1, 3), "tux_boots");

		//Modular Armor #1
		GameRegistry.registerItem(modularHelm = new ModularArmor("modular_helm", modularMaterial, 1, 0), "modular_helm");
		GameRegistry.registerItem(modularChest = new ModularArmor("modular_chest", modularMaterial, 1, 1), "modular_chest");
		GameRegistry.registerItem(modularLegs = new ModularArmor("modular_legs", modularMaterial, 2, 2), "modular_legs");
		GameRegistry.registerItem(modularBoots = new ModularArmor("modular_boots", modularMaterial, 1, 3), "modular_boots");
	}
}