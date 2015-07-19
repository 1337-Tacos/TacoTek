package com._1n5aN1aC.tacotek.common;

import java.io.File;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com._1n5aN1aC.tacotek.items.ItemsHelper;
import com._1n5aN1aC.tacotek.proxy.CommonProxy;

@Mod(
		//Gives forge info about mod.
		modid = ModInfo.MOD_ID,
		name = ModInfo.MOD_NAME,
		version = ModInfo.MOD_VERSION,
		dependencies = 
			//"required-after:IC2;" +
			"after:IC2;" +
			"after:ComputerCraft;" +
			"after:BuildCraft|Core;" +
			"after:BuildCraft|Transport;" +
			"after:BuildCraft|Builders;" +
			"after:BuildCraft|Silicon;" +
			"after:LogisticsPipes|Main",
		useMetadata = true )

public class tacotek {
	//Create the instance of the mod
	@Instance
	public static tacotek instance = new tacotek();

	//Part out the startup calls to the different side-proxies.
	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		this.proxy.preInit(e);
	}

	@EventHandler
	public void init(FMLInitializationEvent e) {
		this.proxy.init(e);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		this.proxy.postInit(e);
	}

	@SidedProxy(clientSide = "com._1n5aN1aC.tacotek.proxy.ClientProxy", serverSide = "com._1n5aN1aC.tacotek.proxy.ServerProxy")
	public static CommonProxy proxy;

	//Adds creative tab for mod.
	public static CreativeTabs tacotekTab = new CreativeTabs("tabTacoTek") { @Override public Item getTabIconItem() {return ItemsHelper.taco;}};

	@EventHandler
	public void load(FMLInitializationEvent event) {

		//Builds config.
		Configuration config = new Configuration(new File("config/TacoTek.cfg"));
		config.load();
		config.save();

		//Imports crafting recipes.
		craftingRecipes();

		//Imports smelting recipes.
		smeltingRecipes();
	}

	private static void smeltingRecipes() {
		//Diamonds->salt.
		GameRegistry.addSmelting(Items.diamond, new ItemStack(ItemsHelper.salt), 1.0F);
	}

	private static void craftingRecipes() {
		//Shapeless:4 bucket_water->salt.
		GameRegistry.addShapelessRecipe(new ItemStack(ItemsHelper.salt, 1),
				Items.water_bucket, Items.water_bucket, Items.water_bucket, Items.water_bucket );

		//non-sense recipe
		GameRegistry.addRecipe(new ItemStack(ItemsHelper.salt, 10), new Object[]
				{ "C", "B", "C",
			'C', ItemsHelper.salt,
			'B', Items.cooked_beef});
	}
}