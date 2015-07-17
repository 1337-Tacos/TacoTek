package com._1n5aN1aC.tacotek.armor.module;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com._1n5aN1aC.tacotek.items.GenericItem;

/**
 * The GenericModule is an abstract class that all Modules inherit from. </br>
 * You then override certain energy methods, and then implement the
 * callbacks that you need to provide the functionality 
 * @author 1n5aN1aC
 */
public abstract class GenericModule extends GenericItem {
	
	public boolean energyProducer;
	public boolean energyStorage;
	public boolean energyConsumer;
	
	public int maxEnergy;
	
	/**
	 * Creates a GenericModule for power armor
	 * @param name the uniqueid of the item
	 * @param max the maximum amount of power the item can store
	 * @param produces does the item produce power?
	 * @param stores does the item store power?
	 * @param consumes does the item consume power?
	 */
	public GenericModule(String name, int max, boolean produces, boolean stores, boolean consumes) {
		super(name, 1);
		
		this.maxEnergy = max;
		this.energyProducer = produces;
		this.energyStorage = stores;
		this.energyConsumer = consumes;
	}
	
	
	//Data Methods
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer player, List dataList, boolean bool) {
		dataList.add("Energy: "+ EnumChatFormatting.AQUA  + Integer.toString(getNBTPower(itemStack)) + EnumChatFormatting.GRAY + "/" + EnumChatFormatting.BLUE + Integer.toString(maxEnergy));
		dataList.add(EnumChatFormatting.YELLOW + "" + EnumChatFormatting.ITALIC + "This is a GenericModule");
	}
	
	@Override
	public boolean onItemUseFirst(ItemStack itemStack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ) {
		addEnergy(itemStack, 20);
		return true;
	}
	
	
	//NBT Helper Methods
	
	public void setNBTPower(ItemStack stack, int power) {
		if (stack.getTagCompound() == null)
			stack.setTagCompound( new NBTTagCompound() );
		stack.getTagCompound().setInteger("curEnergy", power);
	}
	
	public int getNBTPower(ItemStack stack) {
		if (stack.getTagCompound() == null)
			stack.setTagCompound( new NBTTagCompound() );
		if (!stack.getTagCompound().hasKey("curEnergy") )
			stack.getTagCompound().setInteger("curEnergy", 0);
		return stack.getTagCompound().getInteger("curEnergy");
	}
	
	
	//Energy Methods
	
	public int maxEnergyPulled() {
		return 0;
	}
	
	public int maxEnergyReleased() {
		return 0;
	}
	
	/**
	 * A method that is called by the armor to add or remove from your Module</br>
	 * @param stack The itemstack which we want to add/subtract the power from
	 * @param energy The amount of energy to be added to or removed from
	 * the Module. </br> Must be able to accept a negative number, to instead
	 * subtract that amount from energy storage.
	 * @return the amount of energy that you were unable to add or remove
	 * From this module.
	 */
	public int addEnergy(ItemStack stack, int energy) {
		int oldEnergy = getNBTPower(stack);
		int newEnergy = oldEnergy + energy;
		
		//If we overfilled it, return by how much.
		if (newEnergy > this.maxEnergy) {
			int extra = (this.maxEnergy + energy) - oldEnergy;
			setNBTPower(stack, this.maxEnergy);
			return extra;
		}
		else if (newEnergy < 0) {
			int extra = oldEnergy - energy;
			setNBTPower(stack, 0);
			return extra;
		}
		else {
			setNBTPower(stack, newEnergy);
			return 0;
		}
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