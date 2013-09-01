package assets.tacotek.common;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = tacotek.modid, name = "TacoTek", version = "0.1")
@NetworkMod(clientSideRequired = true, serverSideRequired = true)
public class tacotek {
	
	public static final String modid = "tacotek";
	
	@Init
	public void load(FMLInitializationEvent event) {
		
	}
	
}