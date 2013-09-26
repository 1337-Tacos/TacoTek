package assets.tacotek.proxy.side;

import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import assets.tacotek.proxy.interfaces.IProxy;
import cpw.mods.fml.common.network.Player;
import cpw.mods.fml.server.FMLServerHandler;

public class ServerProxy implements IProxy{

	@Override
	public String getSide() {
		return "Server";
	}

	@Override
	public World getWorld() {
		return null;
		//Unsure why, but LP does this.
	}

	@Override
	public void registerTileEntities() {
		//GameRegistry.registerTileEntity(LogisticsSolderingTileEntity.class, "logisticspipes.blocks.LogisticsSolderingTileEntity");
	}

	@Override
	public EntityPlayer getClientPlayer() {
		return null;
		//Not Serverside
	}

	@Override
	public boolean isMainThreadRunning() {
		return FMLServerHandler.instance().getServer().isServerRunning();
	}

	@Override
	public void registerParticles() {
		//Only Client Side
	}
	
	
	@Override
	public int addArmor(String armor) {
		return 0;
	}
	

	@Override
	public void tick() {
		// TODO Auto-generated method stub
	}

	@Override
	public int getDimensionForWorld(World world) {
		if(world instanceof WorldServer) {
			return ((WorldServer)world).provider.dimensionId;
		}
		if(world instanceof WorldClient) {
			return ((WorldClient)world).provider.dimensionId;
		}
		return world.getWorldInfo().getVanillaDimension();
	}
}