package assets.tacotek.common;

import assets.tacotek.Init.*;
import assets.tacotek.blocks.*;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = TacoTek.modID, name = "TacoTek", version = "0.1")
@NetworkMod(clientSideRequired = true, serverSideRequired = true)
public class TacoTek
{

	public static final String modID = "tacotek";
	
	public static Block blockTaco;
	
	@EventHandler
	public void load(FMLInitializationEvent event)
	{
		CraftingInit.addRecipes();
		
		blockTaco = new BlockTaco(834).setUnlocalizedName("blocktaco").setCreativeTab(CreativeTabs.tabBlock);
		registerBlock(blockTaco, "Taco Block", blockTaco.getUnlocalizedName() );
	}
	
	public static void registerBlock(Block block, String name, String unlocalizedName)
	{
		GameRegistry.registerBlock(block, TacoTek.modID + unlocalizedName);
		LanguageRegistry.addName(block, name);
	}

	public String getVersion()
	{
		return "0.1";
	}
	
}