package com._1n5aN1aC.tacotek.blocks;

import net.minecraftforge.fml.common.registry.GameRegistry;

import com._1n5aN1aC.tacotek.proxy.CommonProxy;

/**
 * This class handles keeping track of a reference to each placeable block
 * As well as Handling the registration of each of them into forge
 * @author 1n5aN1aC
 */
public abstract class BlocksHelper {

	//Blocks
	public static TacoBox tacoBox;

	/**
	 * Called during preInit phase to register all the blocks into the game.
	 * This method should contain a single line for each usable block in the game.
	 * @param commonProxy
	 */
	public static void setupBlocks(CommonProxy commonProxy) {

		GameRegistry.registerBlock(tacoBox = new TacoBox("tacobox"), "tacobox");

	}
}