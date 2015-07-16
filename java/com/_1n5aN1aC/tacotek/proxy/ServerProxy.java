package com._1n5aN1aC.tacotek.proxy;

import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.server.FMLServerHandler;

public class ServerProxy extends CommonProxy {
	
	@Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
    }
	
    @Override
    public void init(FMLInitializationEvent e) {
        super.init(e);
    }
    
    @Override
    public void postInit(FMLPostInitializationEvent e) {
        super.postInit(e);
    }
	
	
    
    
	
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
			return ((WorldServer)world).provider.getDimensionId();
		}
		else if(world instanceof WorldClient) {
			return ((WorldClient)world).provider.getDimensionId();
		}
		return 0;
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