package assets.tacotek.proxy.interfaces;

import cpw.mods.fml.common.network.Player;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public interface IProxy {
	public String getSide();
	public World getWorld();
	public void registerTileEntities();
	public EntityPlayer getClientPlayer();
	public boolean isMainThreadRunning();
	
	public int addArmor(String armor);
	
	public void registerParticles();
	public void tick();
	public int getDimensionForWorld(World world);
}