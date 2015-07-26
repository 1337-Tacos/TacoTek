package com._1n5aN1aC.tacotek.common;

import java.io.File;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
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

import com._1n5aN1aC.tacotek.blocks.BlocksHelper;
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
	@Instance
	/** The instance of our mod */
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

	//Declare the proxies.  These are defined in the ModInfo class.
	@SidedProxy(clientSide = ModInfo.MOD_CLIENT_PROXY, serverSide = ModInfo.MOD_SERVER_PROXY)
	public static CommonProxy proxy;

	//Adds a creative tab for mod.
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
		//Diamond Block -> Taco Crate
		GameRegistry.addSmelting(Blocks.diamond_block, new ItemStack(BlocksHelper.tacoBox), 1.0F);
	}

	private static void craftingRecipes() {
		//nonsense shapeless recipe
		GameRegistry.addShapelessRecipe(new ItemStack(ItemsHelper.salt, 1),
				ItemsHelper.taco, ItemsHelper.taco, ItemsHelper.taco);

		//9 tacos -> taco crate
		//Featuring Killaa Formating - (Feel Free to Remove Formating)
		GameRegistry.addRecipe(new ItemStack(BlocksHelper.tacoBox, 1), new Object[]
				{ "TTT", 
				  "TTT", 
			      "TTT",
				  'T', ItemsHelper.taco});
	}
}