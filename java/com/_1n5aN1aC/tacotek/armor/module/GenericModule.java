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

	/** Whether or not the item can produce power */
	public boolean energyProducer;
	/** Whether or not the item can store power (to share with others) */
	public boolean energyStorage;
	/** Whether or not the item can consume power */
	public boolean energyConsumer;

	/** The maximum amount of power that this item can hold. */
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
	}

	//Temporary method to test functionality
	//Generates power on right click.  Used to test NBT power storage.
	@Override
	public boolean onItemUseFirst(ItemStack itemStack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ) {
		addEnergy(itemStack, 20);
		return true;
	}


	//NBT Helper Methods
	/**
	 * Sets the power stored in this item. </br>
	 * Takes care of storing it into the NBT as well.
	 * @param stack the itemStack which we should set the power for
	 * @param power the amount of power to set it to.
	 */
	private void setNBTPower(ItemStack stack, int power) {
		if (stack.getTagCompound() == null)
			stack.setTagCompound( new NBTTagCompound() );
		stack.getTagCompound().setInteger("curEnergy", power);
	}

	/**
	 * return the amount of power stored in this items. </br>
	 * Takes care of making sure the power tags exist correctly.
	 * @param stack the itemStack which we should check the power for
	 * @return the amount of power currently int he module.
	 */
	private int getNBTPower(ItemStack stack) {
		NBTTagCompound tag = stack.getTagCompound();
		//If the NBT doesn't exist, or no power tag, set the tag to 0.
		if (tag == null || !tag.hasKey("curEnergy")) {
			setNBTPower(stack, 0);
			tag = stack.getTagCompound();
		}
		return tag.getInteger("curEnergy");
	}


	//Energy Max Methods
	/**
	 * @return the maximum amount of power that this module
	 * can Input per armor tick
	 */
	public int maxEnergyPulled() {
		return 0;
	}

	/**
	 * @return the maximum amount of power that this module
	 * can Output per armor tick
	 */
	public int maxEnergyReleased() {
		return 0;
	}

	//Power Methods
	/**
	 * A method that is called by the armor to add power to your Module</br>
	 * @param stack The itemstack which we want to add the power to
	 * @param energy The amount of energy to be added to the Module.
	 * @return the amount of energy that you were unable to add to this module.
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
		setNBTPower(stack, newEnergy);
		return 0;
	}

	/**
	 * Checks if there is enough power in the item.
	 * @param stack the itemStack which we need to check
	 * @param amount the amount of power we need to consume
	 * @return whether there is at least that amount of power in the item.
	 */
	public boolean canUseEnergy(ItemStack stack, int amount) {
		return (getNBTPower(stack) > amount);
	}

	/**
	 * Consumes power from an item
	 * @param stack the itemStack to consume from
	 * @param amount the amount of power to drain from the item
	 * @return the amount of energy which was unable to be used
	 */
	public int useEnergy(ItemStack stack, int amount) {
		int oldEnergy = getNBTPower(stack);
		int newEnergy = oldEnergy - amount;
		if (newEnergy >= 0) {
			setNBTPower(stack, newEnergy);
			return 0;
		}
		setNBTPower(stack, 0);
		return 0 - newEnergy;
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