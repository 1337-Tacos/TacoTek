package assets.tacotek.common;

import assets.tacotek.Init.*;
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
	
	@EventHandler
	public void load(FMLInitializationEvent event)
	{
		CraftingInit.addRecipes();
		BlockInit.addBlocks();
		//ItemInit.addItems();
	}

	public String getVersion()
	{
		return "0.1";
	}
	
}