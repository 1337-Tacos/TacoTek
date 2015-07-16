package com._1n5aN1aC.tacotek.proxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import com._1n5aN1aC.tacotek.armor.ModuleHelper;
import com._1n5aN1aC.tacotek.blocks.BlocksHelper;
import com._1n5aN1aC.tacotek.items.ItemsHelper;

public class CommonProxy {

    public void preInit(FMLPreInitializationEvent e) {
		//TODO:  Read config files
		//TODO:  create blocks & items, register them with game registry
    	ItemsHelper.setupItems(this);
    	BlocksHelper.setupBlocks(this);
    }

    public void init(FMLInitializationEvent e) {
		//TODO:  build data structures
		//TODO:  add crafting recipes
		//TODO:  register new handlers
		ModuleHelper.setupModules();
    }

    public void postInit(FMLPostInitializationEvent e) {
		//TODO:  communicate with other mods, and adjust setup based on other mods
    }
}