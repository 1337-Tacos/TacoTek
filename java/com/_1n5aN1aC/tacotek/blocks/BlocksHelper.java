package com._1n5aN1aC.tacotek.blocks;

import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.LanguageRegistry;

import com._1n5aN1aC.tacotek.common.tacotek;
import com._1n5aN1aC.tacotek.proxy.CommonProxy;

public class BlocksHelper {
	
	//Blocks
	public static GenericBlock tacoBox;
	
	public static void setupBlocks(CommonProxy commonProxy) {
		
		GameRegistry.registerBlock(tacoBox = new TacoBox("tacobox"), "tacobox");
		
	}
}