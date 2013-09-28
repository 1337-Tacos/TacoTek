package assets.tacotek.proxy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.network.IGuiHandler;

public class CommonProxy implements IGuiHandler { //THIS IS IMPORTANT, CANNOT BE A PROXY/GUI HANDLER WITHOUT THIS!!
	
	public String getSide() {
		return "Error";
	}
	
	public World getWorld() {
		return null;
	}
	
	public void registerRenderInformation() {
		//Client side texture registering
	}
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) { //For GUI's
		return null;
	}
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) { //For GUI's
		return null;
	}
	
	public void registerTiles(){
		//For registering TileEntities
	}
	
	public void registerBlocks(){
		//For registering Blocks
	}
	
	public void addNames(){
		//For adding Item's ingame names
	}
	
	public void addRecipes(){
		//For adding your Item's recipes
	}

	public void registerTileEntities() {
	}

	public EntityPlayer getClientPlayer() {
		return null;
	}

	public boolean isMainThreadRunning() {
		return false;
	}

	public int addArmor(String armor) {
		return 0;
	}

	public int getDimensionForWorld(World world) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void tick() {
		// TODO Auto-generated method stub
		
	}

	public void registerParticles() {
		// TODO Auto-generated method stub
		
	}
}