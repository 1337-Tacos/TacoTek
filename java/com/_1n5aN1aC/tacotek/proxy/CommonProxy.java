package com._1n5aN1aC.tacotek.proxy;

import com._1n5aN1aC.tacotek.blocks.BlocksHelper;
import com._1n5aN1aC.tacotek.items.ItemsHelper;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

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
    }

    public void postInit(FMLPostInitializationEvent e) {
		//TODO:  communicate with other mods, and adjust setup based on other mods
    }
}