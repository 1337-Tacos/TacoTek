package assets.tacotek.common;

import assets.tacotek.Init.*;
import assets.tacotek.blocks.*;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = tacotek.modid, name = "TacoTek", version = "0.1")
@NetworkMod(clientSideRequired = true, serverSideRequired = true)

public class tacotek
{

	public static final String modid = "tacotek";
	
	public static Block blockTaco;
	
	@Init
	public void load(FMLInitializationEvent event)
	{
		
		CraftingInit.addRecipes();
		
		blockTaco = new BlockTaco(834).setUnlocalizedName("blocktaco");
		
	}

	public String getVersion()
	{
		return "0.1";
	}
	
}