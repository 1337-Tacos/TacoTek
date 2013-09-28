package assets.tacotek.proxy;

import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import cpw.mods.fml.server.FMLServerHandler;

public class ServerProxy {

	public String getSide() {
		return "Server";
	}

	public World getWorld() {
		return null;
		//Unsure why, but LP does this.
	}

	public void registerTileEntities() {
		//GameRegistry.registerTileEntity(LogisticsSolderingTileEntity.class, "logisticspipes.blocks.LogisticsSolderingTileEntity");
	}

	public EntityPlayer getClientPlayer() {
		return null;
		//Not Serverside
	}

	public boolean isMainThreadRunning() {
		return FMLServerHandler.instance().getServer().isServerRunning();
	}

	public void registerParticles() {
		//Only Client Side
	}


	public int addArmor(String armor) {
		return 0;
	}


	public void tick() {
		// TODO Auto-generated method stub
	}

	public int getDimensionForWorld(World world) {
		if(world instanceof WorldServer) {
			return ((WorldServer)world).provider.dimensionId;
		}
		if(world instanceof WorldClient) {
			return ((WorldClient)world).provider.dimensionId;
		}
		return world.getWorldInfo().getVanillaDimension();
	}

	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		// Only Client Side
		return null;
	}
}