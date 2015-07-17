package com._1n5aN1aC.tacotek.armor;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com._1n5aN1aC.tacotek.items.GenericItem;

/**
 * @author 1n5aN1aC
 * The GenericModule is an abstract class that all Modules inherit from. </br>
 * You then override certain energy methods, and then implement the
 * callbacks that you need to provide the functionality 
 */
public abstract class GenericModule extends GenericItem {
	
	public boolean energyProducer = false;
	public boolean energyStorage = false;
	public boolean energyConsumer = false;
	
	protected int curEnergy = 0;
	protected int maxEnergy = 0;
	
	
	
	public GenericModule(String name) {
		super(name, 1);
	}
	
	//Energy Methods
	
	public int maxEnergyPulled() {
		return 0;
	}
	
	public int maxEnergyReleased() {
		return 0;
	}
	
	public int maxEnergyStored() {
		return maxEnergy;
	}
	
	public int getEnergy() {
		return curEnergy;
	}
	
	/**
	 * A method that is called by the armor to add or remove from your Module</br>
	 * @param energy The amount of energy to be added to or removed from
	 * the Module. </br> Must be able to accept a negative number, to instead
	 * subtract that amount from energy storage.
	 * @return the amount of energy that you were unable to add or remove
	 * From this module. 
	 */
	public int addEnergy(int energy) {
		int newEnergy = this.curEnergy + energy;
		
		//If we overfilled it, return by how much.
		if (newEnergy > this.maxEnergy) {
			int extra = (this.maxEnergy + energy) - this.curEnergy;
			this.curEnergy = this.maxEnergy;
			return extra;
		}
		
		if (newEnergy < 0) {
			int extra = this.curEnergy - energy;
			this.curEnergy = 0;
			return extra;
		}
		
		return 0;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer player, List dataList, boolean bool) {
		dataList.add("Energy: "+ EnumChatFormatting.AQUA + Integer.toString(curEnergy) + EnumChatFormatting.GRAY + "/" + EnumChatFormatting.BLUE + Integer.toString(maxEnergy));
		dataList.add(EnumChatFormatting.YELLOW + "" + EnumChatFormatting.ITALIC + "This is a GenericModule");
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ) {
		this.curEnergy += 20;
		System.out.println("clicked");
		return true;
	}
	
	
	
	//Callbacks
	
	public void onTick() {
		//Called once per tick
	}
	
	public void onTickSecond() {
		//Called once per second
	}
	
	public void ifDamaged() {
		//Do specific method stuff
	}
	
	public void ifDamaging() {
		//Do specific method stuff
	}
	
	//Other
	
	//TODO: Description tag generator
}