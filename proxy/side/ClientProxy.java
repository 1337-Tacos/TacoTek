package assets.tacotek.proxy.side;

import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import assets.tacotek.proxy.interfaces.IProxy;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.network.Player;

public class ClientProxy implements IProxy{

	@Override
	public String getSide() {
		return "Client";
	}

	@Override
	public World getWorld() {
		return FMLClientHandler.instance().getClient().theWorld;
	}

	@Override
	public void registerTileEntities() {
		//GameRegistry.registerTileEntity(LogisticsSolderingTileEntity.class, "logisticspipes.blocks.LogisticsSolderingTileEntity");
		//GameRegistry.registerTileEntity(LogisticsPowerJunctionTileEntity.class, "logisticspipes.blocks.powertile.LogisticsPowerJuntionTileEntity");
		//GameRegistry.registerTileEntity(LogisticsTileGenericPipe.class, LogisticsPipes.logisticsTileGenericPipeMapping);
		//LogisticsRenderPipe lrp = new LogisticsRenderPipe();
		//ClientRegistry.bindTileEntitySpecialRenderer(LogisticsTileGenericPipe.class, lrp);
		//SimpleServiceLocator.buildCraftProxy.resetItemRotation(lrp);
		//Object brp = TileEntityRenderer.instance.specialRendererMap.get(TileGenericPipe.class);
		//if(brp instanceof RenderPipe) {
		//	SimpleServiceLocator.buildCraftProxy.resetItemRotation((RenderPipe) brp);
		//}
		//RenderingRegistry.registerBlockHandler(new LogisticsPipeWorldRenderer());
	}

	@Override
	public EntityPlayer getClientPlayer() {
		return FMLClientHandler.instance().getClient().thePlayer;
	}

	@Override
	public boolean isMainThreadRunning() {
		return FMLClientHandler.instance().getClient().running;
	}
	
	
	@Override
	public int addArmor(String armor) {
		return RenderingRegistry.addNewArmourRendererPrefix(armor);
	}
	

	@Override
	public void registerParticles() {
		//PipeFXRenderHandler.registerParticleHandler(Particles.WhiteParticle, new EntityWhiteSparkleFXProvider());
	}

	@Override
	public void tick() {
		//Not Client Side
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