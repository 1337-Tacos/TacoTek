package com._1n5aN1aC.tacotek.proxy;

import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

import com._1n5aN1aC.tacotek.armor.module.ModuleHelper;
import com._1n5aN1aC.tacotek.blocks.BlocksHelper;
import com._1n5aN1aC.tacotek.common.tacotek;
import com._1n5aN1aC.tacotek.gui.GUIHandler;
import com._1n5aN1aC.tacotek.handlers.TacoPlayerTickHandler;
import com._1n5aN1aC.tacotek.items.ItemsHelper;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent e) {
		//TODO:  Read config files
		//TODO:  create blocks & items, register them with game registry
		ItemsHelper.setupItems(this);
		BlocksHelper.setupBlocks(this);
		ModuleHelper.setupModules();
	}

	public void init(FMLInitializationEvent e) {
		//TODO:  build data structures

		//TODO:  add crafting recipes
		//TODO:  add furnace & other recipes.

		//TODO:  maybe move this to postInit?  Probably,
		//because then we could do more magic based on the existence of other mods or not.
		ModuleHelper.registerModules();

		//Register Network Components
		NetworkRegistry.INSTANCE.registerGuiHandler(tacotek.instance, new GUIHandler());
	}

	public void postInit(FMLPostInitializationEvent e) {
		//TODO:  communicate with other mods, and adjust setup based on other mods

		//Register Event Listeners
		FMLCommonHandler.instance().bus().register(new TacoPlayerTickHandler());
	}
}