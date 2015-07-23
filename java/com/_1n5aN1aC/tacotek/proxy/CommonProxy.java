package com._1n5aN1aC.tacotek.proxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

import com._1n5aN1aC.tacotek.armor.module.ModuleHelper;
import com._1n5aN1aC.tacotek.blocks.BlocksHelper;
import com._1n5aN1aC.tacotek.common.tacotek;
import com._1n5aN1aC.tacotek.gui.GUIHandler;
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
		//TODO:  register new handlers
		ModuleHelper.registerModules();
		NetworkRegistry.INSTANCE.registerGuiHandler(tacotek.instance, new GUIHandler());
		//TODO:  maybe move this to postInit?  Probably,
		//because then we could do more magic based on the existence of other mods or not.
	}

	public void postInit(FMLPostInitializationEvent e) {
		//TODO:  communicate with other mods, and adjust setup based on other mods
	}
}