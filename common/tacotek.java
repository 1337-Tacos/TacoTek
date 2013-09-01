package assets.tacotek.common;

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
	
	@Init
	public void load(FMLInitializationEvent event)
	{
		
		GameRegistry.addRecipe(new ItemStack(net.minecraft.item.Item.diamond, 4), new Object[]{
			"TDT",
			"TTT",
			"TtT",
			'T', Item.diamond,
			'D', Item.appleRed,
			't', Item.book
		});
		
	}
	
	public String getVersion()
	{
		return "0.1";
	}
	
}