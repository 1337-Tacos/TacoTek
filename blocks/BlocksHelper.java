package assets.tacotek.blocks;

import assets.tacotek.common.tacotek;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlocksHelper {
	//Blocks
	public static Block tacoBox;
	
	public static void setupBlocks() {
		//Normal Blocks
		tacoBox = new TacoBox(834, "tacobox").setUnlocalizedName("tacobox").setCreativeTab(tacotek.tacotekTab);
		//siliconOre = new BlockOre(IDsHelper.siliconOreID).setHardness(10F).setResistance(0.2F)
        //			   .setUnlocalizedName("SiliconOre").setCreativeTab(CommunityMod.modTab);
		
		//Machines
		
		//Liquids
		
		//Other
		
		gameRegisters();
        oreDictionary();
	}
	
	private static void gameRegisters() {
        // Block Registry
		GameRegistry.registerBlock(tacoBox, "Taco Box" );
	}
	
	private static void oreDictionary() {
	     //OreDictionary.registerOre("oreSilicon", siliconOre);
	}
}