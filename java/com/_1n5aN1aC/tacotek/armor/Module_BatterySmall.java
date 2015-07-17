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

/**
 * @author 1n5aN1aC
 * A simple Small Battery Module
 */
public class Module_BatterySmall extends GenericModule {
	
	public boolean energyProducer = false;
	public boolean energyStorage = true;
	public boolean energyConsumer = false;
	
	protected int curEnergy = 0;
	protected int maxEnergy = 10000;
	
	public Module_BatterySmall(String name) {
		super(name);
		this.curEnergy = 0;
		this.maxEnergy = 10000;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer player, List dataList, boolean bool) {
		super.addInformation(itemStack, player, dataList, bool);
		dataList.add(EnumChatFormatting.YELLOW + "" + EnumChatFormatting.ITALIC + "This is a Module_BatterySmall");
	}
	
	//Energy Methods
	
	@Override
	public int maxEnergyPulled() {
		return 10;
	}
	
	@Override
	public int maxEnergyReleased() {
		return 10;
	}
}