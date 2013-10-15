package assets.tacotek.blocks;

import net.minecraft.block.Block;
import assets.tacotek.Items.GenericPlantable;
import assets.tacotek.common.IDsHelper;
import assets.tacotek.common.tacotek;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class BlocksHelper {
	
	//Blocks
	public static Block tacoBox;
	public static Block redOnionCrop;
	
	public static void setupBlocks() {
		//Normal Blocks
		tacoBox = new TacoBox(IDsHelper.tacoBoxID, "tacobox");
		
		//Crops
		redOnionCrop = new GenericCrop(IDsHelper.redOnionCropID, "redOnionCrop", 
				(new GenericPlantable(IDsHelper.redOnionID, 0, 0, "")).itemID,			//This line is the seed Item
				(new GenericPlantable(IDsHelper.bottleofMilkID, 0, 0, "")).itemID );	//This line is the plant Item
		
		//siliconOre = new BlockOre(IDsHelper.siliconOreID).setHardness(10F).setResistance(0.2F)
		//			   .setUnlocalizedName("SiliconOre").setCreativeTab(tacotek.tacotekTab);
		
		//Machines
		
		gameRegisters();
		languageRegistry();
		oreDictionary();
	}
	
	private static void gameRegisters() {
		//Blocks
		GameRegistry.registerBlock(tacoBox, tacotek.modID + tacoBox.getUnlocalizedName());
		//Crops
		GameRegistry.registerBlock(redOnionCrop, tacotek.modID + redOnionCrop.getUnlocalizedName());
	}
	
	/**
	 * Registers the Block Names to the registry
	 * This makes the Blocks actually have a name in-game.
	 */
	private static void languageRegistry() {
		LanguageRegistry.addName(tacoBox, "Taco Box");
	}
	
	/**
	 * Registers Blocks into the Ore Registry
	 * This makes the blocks compatible with other mod's blocks in crafting.
	 */
	private static void oreDictionary() {
		//OreDictionary.registerOre("oreSilicon", siliconOre);
	}
}