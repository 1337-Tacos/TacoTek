package com._1n5aN1aC.tacotek.items;

import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com._1n5aN1aC.tacotek.armor.GenericArmor;
import com._1n5aN1aC.tacotek.armor.ModularArmor_T1;
import com._1n5aN1aC.tacotek.proxy.CommonProxy;

/**
 * This class handles keeping track of a reference to each item in our mod
 * As well as Handling the registration of each of them into forge
 * Additionally, it holds our armor enums, and armor items.
 * @author 1n5aN1aC
 */
public abstract class ItemsHelper {
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

	public static ModularArmor_T1 T1modularHelm;
	public static ModularArmor_T1 T1modularChest;
	public static ModularArmor_T1 T1modularLegs;
	public static ModularArmor_T1 T1modularBoots;

	public static void setupItems(CommonProxy proxy) {
		//Generic Items
		GameRegistry.registerItem( salt = new GenericItem("salt"), "salt");
		GameRegistry.registerItem( taco = new Taco("taco"), "taco");

		//Tux Armor
		GameRegistry.registerItem( tuxHelm = new GenericArmor("tux_helm", tuxMaterial, 1, 0), "tux_helm");
		GameRegistry.registerItem( tuxChest = new GenericArmor("tux_chest", tuxMaterial, 1, 1), "tux_chest");
		GameRegistry.registerItem( tuxLegs = new GenericArmor("tux_legs", tuxMaterial, 2, 2), "tux_legs");
		GameRegistry.registerItem( tuxBoots = new GenericArmor("tux_boots", tuxMaterial, 1, 3), "tux_boots");

		//Modular Armor #1
		GameRegistry.registerItem( T1modularHelm = new ModularArmor_T1("T1modular_helm", 3, modularMaterial, 1, 0), "T1modular_helm");
		GameRegistry.registerItem( T1modularChest = new ModularArmor_T1("T1modular_chest", 2, modularMaterial, 1, 1), "T1modular_chest");
		GameRegistry.registerItem( T1modularLegs = new ModularArmor_T1("T1modular_legs", 1, modularMaterial, 2, 2), "T1modular_legs");
		GameRegistry.registerItem( T1modularBoots = new ModularArmor_T1("T1modular_boots", 0, modularMaterial, 1, 3), "T1modular_boots");
	}
}